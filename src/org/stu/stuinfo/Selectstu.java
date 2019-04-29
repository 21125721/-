package org.stu.stuinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.stu.forout.Forout;
/**
 *查询学生数据 
 */
public class Selectstu {
	public static void selectstu(){
		Scanner scan = new Scanner(System.in);
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
					String sql = "select * from stu where stucode = ?";
					PreparedStatement pstat = conn.prepareStatement(sql);
					pstat.setInt(1, id);
					boolean flag = pstat.execute();
					ResultSet rs = pstat.getResultSet();
					if(flag){
						Forout.ForOut(13);
						Forout.stuprin();
						Forout.ForOut(13);
						System.out.println("\n|| 学号\t姓名\t性别     "
								+ "年龄      手机号            "
								+ "||");
						if(rs.next()){
							System.out.println("||  "+rs.getInt("stucode")+"\t"
													+rs.getString("name")+"\t"
													+rs.getString("sex")+"         "
													+rs.getInt("age")+"   "
													+rs.getString("phoneid")+"  ||");
						}else {
							System.out.println("没有数据");
							r = true;
						}
					}else {
						Forout.ForOut(42);
						System.out.println("没有这个学生,请重新输入");
						r = true;
					}
				}while(r);
				Forout.ForOut(42);
				System.out.println("\n打印完成,按任意键返回上一级");
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
