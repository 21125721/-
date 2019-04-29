package org.stu.scoreinfo;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

import org.stu.Data.Dbconnection;
import org.stu.mainui.Mainui;
import org.stu.score.Score;
import org.stu.students.Students;
import org.stu.stuinfo.SQLexecute;
/**
 *获取所有成绩
 *
 */
public class Allscore {
	/**
	 * 输出全部成绩
	 */
	public static void allscore() throws Exception {
		Scanner scan = new Scanner(System.in);
		Connection conn = Dbconnection.getConnection();
		String sql = "select * from score";
		SQLexecute<Score> sq = new SQLexecute<Score>();
		Score score = new Score();
		List<Score> list = sq.executeQuery(conn, sql, score);
		String sql2 = "select * from stu";
		SQLexecute<Students> sq2 = new SQLexecute<Students>();
		Students stu = new Students();
		List<Students> list2 = sq2.executeQuery(conn, sql2, stu);
		System.out.println("     学号       姓名         C语言         Java  Oralce "
							+ " PS      Html");
		
		for(Score sc:list) {
			int a = 0;
			System.out.printf("%6d  %6s  %6d %6d  %6d  %6d  %6d\n",
							sc.getStucode(),list2.get(a).getName(),sc.getC(),
							sc.getJava(),sc.getOracle(),
							sc.getPS(),sc.getHtml());
			a++;
		}
		System.out.println("任意键返回上一级");
		String ff=scan.nextLine();
		if(ff.equals("")) {
			Mainui.Stuscore();
		}else {
			Mainui.Stuscore();
		}
		scan.close();
	}
}	
