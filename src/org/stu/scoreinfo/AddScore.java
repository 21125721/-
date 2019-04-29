package org.stu.scoreinfo;

import java.sql.Connection;
import java.util.Scanner;

import org.stu.Data.Dbconnection;
import org.stu.score.Score;
import org.stu.students.Getstucode;
import org.stu.students.Students;
import org.stu.stuinfo.Addstuinfo;
import org.stu.stuinfo.SQLexecute;

public class AddScore extends Addstuinfo{
	public static void addscore() throws Exception {
		boolean flag = false;
		Scanner scan = new Scanner(System.in);
		String one ="";
		int id = Getstucode.getstucode();
		Connection conn = Dbconnection.getConnection();
		do { 
			flag = false;
			System.out.println("\t1:C      2:Java");
			System.out.println("\t3:Oracle    4:PS");
			System.out.println("\t5:Html");
			System.out.println("请选择课程:");
			one = scan.nextLine();
			switch(one) {
			case "1":one = "C";
				String sqlclass = "update score set `C` = ?"
						+ " where stucode = ?";
				SQLexecute<Score> sq = new SQLexecute<Score>();
				int rows=sq.executeModify(conn,sqlclass,0,id);
				if(rows>0) {
					System.out.println("添加成功,影响："+rows+" 行");
					System.out.println("是否继续选择:1:继续/任意键返回上一级");
					String y = scan.nextLine();
					if(y.equals("1")) {
						flag = true;
					}else {
						
					}
				}else {
					System.out.println("添加失败");
				}
				break;
			case "2":one = "Java";
				String sqlclass2 = "update score set `Java`= ?"
						+ " where stucode = ?";
				SQLexecute<Score> sq2 = new SQLexecute<Score>();
				int rows2=sq2.executeModify(conn,sqlclass2,0,id);
				if(rows2>0) {
					System.out.println("添加成功,影响："+rows2+" 行");
					System.out.println("是否继续选择:1:继续/任意键返回上一级");
					String y = scan.nextLine();
					if(y.equals("1")) {
						flag = true;
					}else {
						
					}
				}else {
					System.out.println("添加失败");
				}
				break;
			case "3":one = "Oracle";
				String sqlclass3 = "update score set `Oracle`= ?"
						+ " where stucode=?";
				SQLexecute<Score> sq3 = new SQLexecute<Score>();
				int rows3=sq3.executeModify(conn,sqlclass3,0,id);
				if(rows3>0) {
					System.out.println("添加成功,影响："+rows3+" 行");
					System.out.println("是否继续选择:1:继续/任意键返回上一级");
					String y = scan.nextLine();
					if(y.equals("1")) {
						flag = true;
					}else {
						
					}
				}else {
					System.out.println("添加失败");
				}
				break;
			case "4":one = "PS";
				String sqlclass4 = "update score set `PS` = ?"
						+ " where stucode=?";
				SQLexecute<Score> sq4 = new SQLexecute<Score>();
				int rows4=sq4.executeModify(conn,sqlclass4,0,id);
				if(rows4>0) {
					System.out.println("添加成功,影响："+rows4+" 行");
					System.out.println("是否继续选择:1:继续/任意键返回上一级");
					String y = scan.nextLine();
					if(y.equals("1")) {
						flag = true;
					}else {
						
					}
				}else {
					System.out.println("添加失败");
				}
				break;
			case "5":one = "Html";
				String sqlclass5 = "update score set `Html`= ?"
						+ " where stucode=?";
				SQLexecute<Score> sq5 = new SQLexecute<Score>();
				int rows5=sq5.executeModify(conn,sqlclass5,0,id);
				if(rows5>0) {
					System.out.println("添加成功,影响："+rows5+" 行");
					System.out.println("是否继续选择:1:继续/任意键返回上一级");
					String y = scan.nextLine();
					if(y.equals("1")) {
						flag = true;
					}else {
						
					}
				}else {
					System.out.println("添加失败");
				}
				break;
			default:System.out.println("输入错误,请重新输入");
					flag=true;
					break;
			}
			
		}while(flag);
		scan.close();
	}
}
