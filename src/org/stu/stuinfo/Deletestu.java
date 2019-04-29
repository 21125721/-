package org.stu.stuinfo;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import org.stu.Data.Dbconnection;
import org.stu.mainui.Mainui;
import org.stu.score.Score;
import org.stu.students.Students;

public class Deletestu {
	static Scanner scan = new Scanner(System.in);
	public static void deletestu() throws Exception {
		Connection conn = Dbconnection.getConnection();
		boolean flag = false;
		do {
			flag = false;
			System.out.println("������Ҫɾ����ѧ��ID:");
			String stuid = scan.nextLine();
			if(stuid.equals("")) {
				flag = true;
				System.out.println("�������,����������");
			}else {
				String sql = "select * from stu where stucode = ?";
				Students stu = new Students();
				SQLexecute<Students> sq = new SQLexecute<Students>();
				List<Students> list = sq.executeQuery(conn, sql,stu, stuid);
				if(list.isEmpty()) {
					System.out.println("û�и�ѧ��,����������");
					flag = true;
				}else {
					System.out.println("�Ƿ�ɾ��:1:ɾ��/���������");
					String input = scan.nextLine();
					if(input.equals("1")) {
						String sql2 = "delete from Score where stucode = ?";
						SQLexecute<Score> sq2 = new SQLexecute<Score>();
						int row2 = sq2.executeModify(conn, sql2, stuid);
						if(row2>0) {
							String sql3 = "delete from stu where stucode = ?";
							SQLexecute<Students> sq3 = new SQLexecute<Students>();
							int row3 = sq3.executeModify(conn, sql3, stuid);
							if(row3>0){
								System.out.println("ɾ���ɹ�");
								System.out.println("�Ƿ����:1:����/�����������һ��");
								String choose = scan.nextLine();
								if(choose.equals("1")) {
									flag = true;
								}else {
									Mainui.Stuinfo();
								}
							}else {
								System.out.println("ɾ��ʧ��");
							}
						}else {
							System.out.println("ɾ��ʧ��");
						}
					}else {
						Mainui.Stuinfo();
					}
				}
			}
		}while(flag);
	}
}
