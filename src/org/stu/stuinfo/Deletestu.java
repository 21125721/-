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
			System.out.println("请输入要删除的学生ID:");
			String stuid = scan.nextLine();
			if(stuid.equals("")) {
				flag = true;
				System.out.println("输入错误,请重新输入");
			}else {
				String sql = "select * from stu where stucode = ?";
				Students stu = new Students();
				SQLexecute<Students> sq = new SQLexecute<Students>();
				List<Students> list = sq.executeQuery(conn, sql,stu, stuid);
				if(list.isEmpty()) {
					System.out.println("没有该学生,请重新输入");
					flag = true;
				}else {
					System.out.println("是否删除:1:删除/任意键返回");
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
								System.out.println("删除成功");
								System.out.println("是否继续:1:继续/任意键返回上一级");
								String choose = scan.nextLine();
								if(choose.equals("1")) {
									flag = true;
								}else {
									Mainui.Stuinfo();
								}
							}else {
								System.out.println("删除失败");
							}
						}else {
							System.out.println("删除失败");
						}
					}else {
						Mainui.Stuinfo();
					}
				}
			}
		}while(flag);
	}
}
