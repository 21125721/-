package org.stu.stuinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

import org.stu.Data.Dbconnection;
import org.stu.students.Students;

public class Addstuinfo{
	static Scanner scan = new Scanner(System.in);
	/**
	 * ���ѧ����Ϣ
	 */
	public static void addstuinfo(){
		Connection conn = null;
		boolean flag = false;
		String name = "";
		String sex = ""; 
		int age = 0;
		String phoneid = "";
		try {
			conn = Dbconnection.getConnection();
			if(conn == null) {
				System.out.println("��ȡʧ��");
			}else {
				String sql = "insert into stu(name,sex,age,phoneid) values(?,?,?,?)";
				PreparedStatement pstat = conn.prepareStatement(sql);
				do {
					flag = false;
					System.out.println("����������:");
					name = scan.nextLine();
					if("".trim().equals(name)) {
						System.out.println("��������Ϊ��, ����������");
						flag = true;
					}else {
//						pstat.setString(1, name);
						
					}
				}while(flag);
				do {
					flag = false;
					System.out.println("�������Ա�:��/Ů");
					sex = scan.nextLine();
					scan.nextLine();
					if(!sex.equals("��")||!sex.equals("Ů")) {
						System.out.println("�������,����������:");
						flag = true;
					}else {
						//pstat.setInt(2, sex);
					}
				}while(flag);
				do {
					flag = false;
					System.out.println("����������:");
					age = scan.nextInt();
					scan.nextLine();
					if(age <1&&age >99) {
						System.out.println("�������,����������:");
						flag = true;
					}else {
						//pstat.setInt(3, age);
					}
				}while(flag);
				do {
					flag = false;
					System.out.println("�������ֻ���:");
					phoneid = scan.nextLine();
					if(!phoneid.trim().matches("^(13|15|18|17)\\d{9}$")) {
						System.out.println("�������,����������:");
						flag = true;
					}else {
						//pstat.setString(4, phoneid);
					}
				}while(flag);
				Students stu = new Students();
				SQLexecute<Students> sq = new SQLexecute<Students>();
				int rows=sq.executeModify(conn, sql,name,sex,age,phoneid);
				boolean f = pstat.execute();
				if(f) {
					System.out.println("�н����");
				}else {
					System.out.println("��ӳɹ�,Ӱ��:"+pstat.getUpdateCount()+"��");
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
