package org.stu.mainui;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

import org.stu.Data.Dbconnection;
import org.stu.forout.Forout;
import org.stu.scoreinfo.Allscore;
import org.stu.scoreinfo.Selectscore;
import org.stu.scoreinfo.UpdateScore;
import org.stu.stuinfo.Addstuinfo;
import org.stu.stuinfo.Deletestu;
import org.stu.stuinfo.Stuinfoui;
import org.stu.stuinfo.Updatestu;
/**
 * 主界面
 *
 */
public class Mainui {
	private static Scanner scan = new Scanner(System.in);
	static Connection conn = null;
	//登陆界面
	public static void login() throws Exception {
		conn = Dbconnection.getConnection();
		Forout.ForOut(13,30);
		Forout.stuprin(30);
		Forout.ForOut(13,30);
		System.out.println();
		System.out.print("\t\t账号:");
		String username = scan.nextLine();
		System.out.print("\t\t密码:");
		int password = scan.nextInt();
		scan.nextLine();
		if(conn == null){
			System.out.println("获取失败");
		}else {
			try {
				String sql = "select * from userdata";
				Statement stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(sql);
					while(rs.next()) {
						if(username.equals(rs.getString("username"))&&password==rs.getInt("pwd")){
							System.out.println("\t\t登陆成功！");
							mainui();
							break;
						}else {
							System.out.println("\t\t账号或密码错误");
							login();
						}
					}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if(conn !=null) {
					try {
						conn.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
		
	}
	/**
	 * 主菜单
	 * @author zcy12
	 *
	 *
	 */
	//主菜单
	public static void mainui() throws Exception {
		long begintime = new Date().getTime();
		Forout.ForOut(13,30);
		Forout.stuprin(30);
		Forout.ForOut(13,30);
		System.out.print("\n||\t\t 1、学生信息\t\t||");
		System.out.print("\n||\t\t 2、学生成绩\t\t||");
		System.out.print("\n||\t\t 3、退       出\t\t||\n");
		Forout.ForOut(42,10);
		long endtime = new Date().getTime();
		System.out.println("\r\n加载完成,耗时："+(endtime-begintime)+"ms");
		System.out.print("请输入您的选项：\n");
		String n = scan.nextLine();
		switch(n) {
			case "1" : Stuinfo();break;
			case "2" :Stuscore();break;
			case "3" : Exit();break;
			default:System.out.println("输入有误，请重新输入");mainui();break;
		}
		}
	/**
	 * 学生信息
	 * @author zcy12
	 *
	 */
	//学生信息
	public static void Stuinfo() throws Exception {
		long begintime = new Date().getTime();
		Forout.ForOut(13);
		Forout.stuprin();
		Forout.ForOut(13);
		System.out.print("\n||\t\t 1、学生信息\t\t||");
		System.out.print("\n||\t\t 2、添加学生\t\t||");
		System.out.print("\n||\t\t 3、修改学生\t\t||");
		System.out.print("\n||\t\t 4、删除学生\t\t||");
		System.out.print("\n||\t\t 5、返回菜单\t\t||\n");
		Forout.ForOut(42);
		long endtime = new Date().getTime();
		System.out.println("\r\n加载完成,耗时："+(endtime-begintime)+"ms");
		System.out.print("请输入您的选项：");
		String n = scan.nextLine();
		switch(n) {
			case "1":Stuinfoui.Stuinfoui();break;
			case "2":Addstuinfo.addstuinfo();break;
			case "3":Updatestu.update();break;
			case "4":Deletestu.deletestu();;break;
			case "5":mainui();break;
			default:System.out.println("输入有误，请重新输入");Stuinfo();break;
		}
	}
	/**
	 * 学生成绩
	 * @author zcy12
	 */
	//学生成绩
	public static void Stuscore() throws Exception {
		long begintime = new Date().getTime();
		Forout.ForOut(13);
		Forout.stuprin();
		Forout.ForOut(13);
		System.out.print("\n||\t\t 1、所有成绩        \t\t||");
		System.out.print("\n||\t\t 2、查询成绩\t\t||");
		System.out.print("\n||\t\t 3、修改成绩\t\t||");
		System.out.print("\n||\t\t 4、返回菜单\t\t||\n");
		Forout.ForOut(42);
		long endtime = new Date().getTime();
		System.out.println("\r\n加载完成,耗时："+(endtime-begintime)+"ms");
		System.out.print("请输入您的选项：");
		String n = scan.nextLine();
		switch(n) {
		case "1":Allscore.allscore();break;
		case "2":Selectscore.selectscore();break;
		case "3":UpdateScore.updatescore();break;
		case "4":Mainui.mainui();break;
		default:System.out.println("输入有误，请重新输入");Stuscore();break;
	}
	}
	//退出
	public static void Exit() throws InterruptedException {
		System.out.println("退出成功");
		System.exit(0);
	}
	@Override
	protected void finalize() throws Throwable { 
		super.finalize();
		scan.close();
		scan = null;
	}
}
	

