package org.stu.stuinfo;

import java.sql.Connection;
import java.util.Scanner;

import org.stu.Data.Dbconnection;
import org.stu.mainui.Mainui;
import org.stu.score.Score;
import org.stu.scoreinfo.AddScore;
import org.stu.students.Students;

public class Addstuinfo{
	static Scanner scan = new Scanner(System.in);
	/**
	 * 添加学生信息
	 */
	public static void addstuinfo(){
		Connection conn = null;
		boolean flag = false;
		String name = "";
		String sex = ""; 
		int age = 0;
		String phoneid = "";
		String one = "";
		try {
			conn = Dbconnection.getConnection();
			if(conn == null) {
				System.out.println("获取失败");
			}else {
				//定义插入数据的sql语句
				String sql = "insert into stu(`name`,`sex`,`age`,`phoneid`) values(?,?,?,?)";
				do {
					flag = false;
					System.out.println("请输入姓名:");
					name = scan.nextLine();
					if("".trim().equals(name)) {
						System.out.println("姓名不能为空, 请重新输入");
						flag = true;
					}
				}while(flag);
				do {
					flag = false;
					System.out.println("请输入性别:男/女");
					sex = scan.nextLine();
					if(!sex.equals("男")&&!sex.equals("女")) {
						System.out.println("输入错误,请重新输入:");
						flag = true;
					}
				}while(flag);
				do {
					flag = false;
					System.out.println("请输入年龄:");
					age = scan.nextInt();
					scan.nextLine();
					if(age <1&&age >99) {
						System.out.println("输入错误,请重新输入:");
						flag = true;
					}
				}while(flag);
				do {
					flag = false;
					System.out.println("请输入手机号:");
					phoneid = scan.nextLine();
					if(!phoneid.trim().matches("^(13|15|18|17)\\d{9}$")) {
						System.out.println("输入错误,请重新输入:");
						flag = true;
					}
				}while(flag);
				SQLexecute<Students> sq = new SQLexecute<Students>();
				int rows=sq.executeModify(conn,sql,name,sex,age,phoneid);
				if(rows<0) {
					System.out.println("添加失败");
				}else {
					System.out.println("添加成功,影响:"+rows+"行");
					String sqlclass = 
							"insert into score(`existence`)values(?)";
					SQLexecute<Score> sqq = new SQLexecute<Score>();
					int row=sqq.executeModify(conn, sqlclass,1);
					if(row>0) {
						System.out.println("添加成功");
					}else {
						System.out.println("失败");
					}
					System.out.println("任意键选择课程");
					String i = scan.nextLine();
					if(i.equals("")) {
						AddScore.addscore();
					}else{
						AddScore.addscore();
					}
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
