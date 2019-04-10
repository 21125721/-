package org.stu.stuinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Selectstu {
	public static void selectstu(){
		Scanner scan = new Scanner(System.in);
		Connection conn = org.stu.Data.Dbconnection.getConnection();
		boolean r = false;
		if(conn == null) {
			System.out.println("��ȡʧ��");
		}else {
			try {
				do{
					r = false;
					System.out.println("������Ҫ��ѯ��ѧ��id");
					int id = scan.nextInt();
					scan.nextLine();
					String sql = "select * from stu where stucode = ?";
					PreparedStatement pstat = conn.prepareStatement(sql);
					pstat.setInt(1, id);
					boolean flag = pstat.execute();
					ResultSet rs = pstat.getResultSet();
					if(flag){
						if(rs.next()){
							System.out.println("ѧ��:"+rs.getInt("stucode")+"\t"+
												"����:"+rs.getString("name")+"\t"+
												"�Ա�"+rs.getString("sex")+"\t"+
												"����:"+rs.getInt("age")+"\t"+
												"�ֻ���"+rs.getString("phoneid"));
						}else {
							System.out.println("û������");
							r = true;
						}
					}else {
						System.out.println("û�����ѧ��,����������");
						r = true;
					}
				}while(r);
				System.out.println("��ӡ���,�������������һ��");
				String sc = scan.nextLine();
				if("".equals(sc)) {
					Stuinfoui.Stuinfoui();
				}else {
					Stuinfoui.Stuinfoui();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		scan.close();
	}
}
