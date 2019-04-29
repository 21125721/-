package org.stu.stuinfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import org.stu.forout.Forout;
import org.stu.mainui.Mainui;
import org.stu.students.Students;
/**
 *�޸�ѧ������
 */
public class Updatestu {
	public static void update() throws Exception {
		Scanner scan = new Scanner(System.in);
		Connection conn = org.stu.Data.Dbconnection.getConnection();
		boolean flag = false;
		boolean real = false;
		if(conn == null) {
			System.out.println("��ȡʧ��");
		}else {
			try {
				do {
					real = false;
					flag = false;
					System.out.println("������Ҫ�޸ĵ�ѧ��id:");
					int id = scan.nextInt();
					scan.nextLine();
					String sqlselct = "select * from stu where stucode = ?";
					PreparedStatement pstat = conn.prepareStatement(sqlselct);
					pstat.setInt(1, id);
					ResultSet p = pstat.executeQuery();
					if(p.next()){
						do {
							Forout.ForOut(13);
							System.out.print("  ��ǰѧ����Ϣ    ");
							Forout.ForOut(13);
							System.out.println("\n|| ѧ��\t����\t�Ա�     ����      �ֻ���"
									+ "           ||");
							System.out.println("||  "+p.getInt("stucode")+"\t"
									+p.getString("name")+"\t"
									+p.getString("sex")+"         "
									+p.getInt("age")+"    "
									+p.getString("phoneid")+"||");
							System.out.println("||\t  1���޸�����    2���޸��Ա�               ||"
												+"\n||\t  3���޸�����    4:�޸��ֻ���"
												+ "             ||");
							System.out.println("||\t\t5:�������˵�                         ||");
							Forout.ForOut(43);
							System.out.println("\n���������ѡ��:");
							String column = scan.nextLine();
							switch (column) {
							case "1":
								do {
									System.out.println("�����������޸ĵ�ֵ:");
									String name = scan.nextLine();
									if("".trim().equals(name)) {
										real = true;
										System.out.println("��������Ϊ��,����������");
									}else {
										String sql = "update stu set name = ? where stucode = ?";
										SQLexecute<Students> sq = new SQLexecute<Students>();
										int rows=sq.executeModify(conn, sql,name,id);
										if(rows<=0) {
											System.out.println("����ʧ��,����������");
											real = true;
										}else {
											System.out.println("���³ɹ�,Ӱ��:"+rows+"��");
											System.out.println("�������������һ��");
											String sc = scan.nextLine();
											if("".equals(sc)) {
												Mainui.Stuinfo();
											}else {
												Mainui.Stuinfo();
											}
										}
									}
								}while(real);
								break;
							case "2":
								do {
									System.out.println("�����������޸ĵ�ֵ:");
									String sex = scan.nextLine();
									if(!sex.equals("��")&&!sex.equals("Ů")) {
										System.out.println("�Ա�ֻ��Ϊ��/Ů");
										real = true;
									}else {
										String sql = "update stu set sex = ? where stucode = ?";
										SQLexecute<Students> sq = new SQLexecute<Students>();
										int rows=sq.executeModify(conn, sql,sex,id);
										System.out.println("���³ɹ�,Ӱ��:"+rows+"��");
										System.out.println("�������������һ��");
										String sc = scan.nextLine();
										if("".equals(sc)) {
											Mainui.Stuinfo();
										}else {
											Mainui.Stuinfo();
										}
									}
								}while(real);
								break;
							case "3":
								do {
									System.out.println("�����������޸ĵ�ֵ:");
									int age = scan.nextInt();
									scan.nextLine();
									if(age>99||age<0) {
										System.out.println("����ֻ��Ϊ1-99");
										real = true;
									}else {
										String sql = "update stu set age = ? where stucode = ?";
										SQLexecute<Students> sq = new SQLexecute<Students>();
										int rows=sq.executeModify(conn, sql,age,id);
										System.out.println("���³ɹ�,Ӱ��:"+rows+"��");
										System.out.println("�������������һ��");
										String sc = scan.nextLine();
										if("".equals(sc)) {
											Mainui.Stuinfo();
										}else {
											Mainui.Stuinfo();
										}
									}
								}while(real);
								break;
							case "4":
								do {
									System.out.println("�����������޸ĵ�ֵ:");
									String phoneid = scan.nextLine();
									if(!phoneid.matches("^(13|15|18|17)\\d{9}$")) {
										System.out.println("�ֻ����������");
										real = true;
									}else {
										String sql = "update stu set phoneid = ? where stucode = ?";
										SQLexecute<Students> sq = new SQLexecute<Students>();
										int rows=sq.executeModify(conn, sql,phoneid,id);
										System.out.println("���³ɹ�,Ӱ��:"+rows+"��");
										System.out.println("�������������һ��");
										String sc = scan.nextLine();
										if("".equals(sc)) {
											Mainui.Stuinfo();
										}else {
											Mainui.Stuinfo();
										}
									}
								}while(real);
								break;
							case "5":Mainui.mainui();break;
							default:
								System.out.println("�������,����������");
								flag = true;
								break;
							}
						}while(flag);
					}else {
						flag = true;
						System.out.println("û�����ѧ��,����������");
					}
				}while(flag);
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
