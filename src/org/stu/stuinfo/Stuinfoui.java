package org.stu.stuinfo;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.stu.Data.Dbconnection;
import org.stu.forout.Forout;
import org.stu.mainui.Mainui;
import org.stu.students.Students;


public class Stuinfoui {
	static Connection conn = null;
	static Scanner scan = new Scanner(System.in);
	public static void Stuinfoui() throws Exception {
		long begintime = new Date().getTime();
		Forout.ForOut(12);
		Forout.stuprin();
		Forout.ForOut(12);
		System.out.print("\n||\t\t 1������ѧ��\t\t||");
		System.out.print("\n||\t\t 2����ѯѧ��\t\t||");
		System.out.print("\n||\t\t 3�������ϼ�\t\t||");
		System.out.print("\n||\t\t 4����       ��\t\t||\n");
		Forout.ForOut(42);
		long endtime = new Date().getTime();
		System.out.println("\r\n�������,��ʱ��"+(endtime-begintime)+"ms");
		System.out.print("����������ѡ�");
		String n = scan.nextLine();
		switch(n) {
			case "1":allinfo();break;
			case "2":Selectstu.selectstu();break;
			case "3":Mainui.Stuinfo();break;
			case "4":Mainui.Exit();break;
			default:System.out.println("������������������");break;
		}  
		scan.close();
	}
	public static void allinfo(){
		conn =  Dbconnection.getConnection();
		if(conn ==null) {
			System.out.println("��ȡʧ��");
		}
		else {
			try {
				String sql = "select * from stu";
				PreparedStatement pstat = conn.prepareStatement(sql);
				boolean flag = pstat.execute();
				if(flag) {
					System.out.println("ѧ��\t����\t�Ա�\t����\t�ֻ���\t");
					/*while(rs.next()) {
						String sex = "";
						if(rs.getInt("sex")==1) {
							sex="��";
						}else {
							sex="Ů";
						}
						System.out.println(rs.getInt("stucode")+"\t"+
											rs.getString("name")+"\t"+
											sex+"\t"+
											rs.getInt("age")+"\t"+
											rs.getString("phoneid")+"\t");
					}*/
					Students stu = new Students();
					SQLexecute<Students> sq = new SQLexecute<Students>();
					List<Students> list =sq.executeQuery(conn, sql, stu);
					for(Students st:list) {
						System.out.println(st.toString());
					}
					System.out.println("��ӡ���,�������������һ��");
					String sc = scan.nextLine();
					if("".equals(sc)) {
						Stuinfoui();
					}else {
						Stuinfoui();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}	
}