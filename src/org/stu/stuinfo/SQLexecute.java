package org.stu.stuinfo;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ��װJDBC
 * @author 19392
 */
public class SQLexecute<T> {
		public List<T> executeQuery(Connection conn,String sql,T t,Object...params)
			throws SQLException, IllegalArgumentException,
				IllegalAccessException, InstantiationException{
			List<T> list = new ArrayList<T>();
			ResultSet rs = null;
			//ȥ��ǰ��ո�
			sql = sql.trim();
			//�鿴�ַ���SQL���Ƿ�ǰ��select
			if(!sql.toLowerCase().startsWith("select")){
				throw new SQLException("�ڴ�Ӧ��ִ��select���");
			}
			//�鿴SQL������Ƿ��в���
			String tmp = sql.replace("?", "");
			int len = Math.abs(tmp.length()-sql.length());
			//�ж�SQL����еġ�����������params��Ԫ�صĸ����Ƿ����
			if(len != params.length) {
				throw new SQLException("����������ƥ��");
			}
			if(len>0) {
				//���ִ��Ԥ�����PreparedStatement
				PreparedStatement pstat = conn.prepareStatement(sql);
				//���ò���
				for(int i=0;i<params.length;i++) {
					pstat.setObject(i+1, params[i]);
				}
				//ִ��
				rs = pstat.executeQuery();
			}
			else {
				//ִ��û�в�����SQL���
				Statement stat = conn.createStatement();
				rs = stat.executeQuery(sql);
			}
			//ʹ�÷���
			Class<?> clazz = t.getClass();
			//��������
			while(rs.next()) {
				//ʹ�÷���
				//Class<?> clazz = t.getClass();
				//ʵ�����������Ķ���
				Object obj = clazz.newInstance();
				//���������е���
				Field[] fields = clazz.getDeclaredFields();
				for(Field field : fields) {
					//ʹ��ע�����ӳ��
					if(field.isAnnotationPresent(ColumnName.class)) {
						ColumnName cn = field.getAnnotation(ColumnName.class);
						//���ע���е��ֶ���
						String cname = cn.value();
						//�������Ա��ֵ
						field.setAccessible(true);
						field.set(obj, rs.getObject(cname));
					}
				}
				//����������б�
				list.add((T)obj);
			}
			return list;
		}
		
		public int executeModify(Connection conn,
				String sql,
				Object...param)
			throws Exception{
			Integer result = null;
			//�ж��Ƿ���ִ��insert,delete,update
			String pstr = "(insert|delete|update)";
			Pattern pattern = Pattern.compile(pstr);
			Matcher matcher = pattern.matcher(sql);
			if(!matcher.find()) {
				throw new Exception("�ڴ�ִ��insert/update/delete���");
			}
			//�ж��Ƿ��в���
			sql = sql.trim().toLowerCase();
			//��������
			String tmp = sql.replace("?", "");
			int len = Math.abs(tmp.length() - sql.length());
			//�жϸ���
			if(len!=param.length) {
				throw new Exception("����������ƥ��");
			}
			//�ж�len�Ƿ������
			if(len>0) {
				PreparedStatement pstat = conn.prepareStatement(sql);
				for(int i=0;i<param.length;i++) {
					pstat.setObject(i+1, param[i]);
				}
				result = pstat.executeUpdate();
			}
			else {
				Statement stat = conn.createStatement();
				result = stat.executeUpdate(sql);
			}
			return result;
		}
}
