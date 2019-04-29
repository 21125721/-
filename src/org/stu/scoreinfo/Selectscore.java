package org.stu.scoreinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Scanner;

import org.stu.forout.Forout;
import org.stu.mainui.Mainui;
import org.stu.score.Score;
import org.stu.students.Students;
import org.stu.stuinfo.SQLexecute;
import org.stu.stuinfo.Stuinfoui;
/**
 * 成绩查询
 * @author zcy12
 *
 */
public class Selectscore {
	public static void selectscore() {
		Scanner scan = new Scanner(System.in);
		//获取连接对象
		Connection conn = org.stu.Data.Dbconnection.getConnection();
		boolean r = false;
		if(conn == null) {
			System.out.println("获取失败");
		}else {
			try {
				do{
					r = false;
					System.out.println("请输入要查询的学生id");
					int id = scan.nextInt();
					scan.nextLine();
					//定义查询的sql语句
					String sql = "select * from Score where stucode = ?";
					SQLexecute<Score> sq = new SQLexecute<Score>();
					Score sc1 = new Score();
					List<Score> list = sq.executeQuery(conn, sql, sc1, id);
					if(list.isEmpty()) {
						System.out.println("该学生不存在或者没有成绩,请重新输入");
						r = true;
					}else {
						String output ="  ";
						String h="  学号";
						for(Score s:list) {
							output += s.getStucode();
							if(s.getC()!=null) {
								output+="   "+s.getC();
								h+="   C语言";
							}
							if(s.getJava()!=null) {
								output+="   "+s.getJava();
								h+="   Java";
							}
							if(s.getOracle()!=null) {
								output+="   "+s.getOracle();
								h+="   Oracle";
							}
							if(s.getPS()!=null) {
								output+="   "+s.getPS();
								h+="   PS";
							}
							if(s.getHtml()!=null) {
								output+="   "+s.getHtml();
								h+="   Html";
							}
						}
						System.out.println(h);
						System.out.println(output);
					}
				}while(r);
				System.out.println("\n打印完成,按任意键返回上一级");
				String sc = scan.nextLine();
				if("".equals(sc)) {
					Mainui.Stuscore();
				}else {
					Mainui.Stuscore();
				}
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		scan.close();
	}
}
