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
 * �ɼ���ѯ
 * @author zcy12
 *
 */
public class Selectscore {
	public static void selectscore() {
		Scanner scan = new Scanner(System.in);
		//��ȡ���Ӷ���
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
					//�����ѯ��sql���
					String sql = "select * from Score where stucode = ?";
					SQLexecute<Score> sq = new SQLexecute<Score>();
					Score sc1 = new Score();
					List<Score> list = sq.executeQuery(conn, sql, sc1, id);
					if(list.isEmpty()) {
						System.out.println("��ѧ�������ڻ���û�гɼ�,����������");
						r = true;
					}else {
						String output ="  ";
						String h="  ѧ��";
						for(Score s:list) {
							output += s.getStucode();
							if(s.getC()!=null) {
								output+="   "+s.getC();
								h+="   C����";
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
				System.out.println("\n��ӡ���,�������������һ��");
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
