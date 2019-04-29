package org.stu.scoreinfo;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.stu.Data.Dbconnection;
import org.stu.mainui.Mainui;
import org.stu.score.Score;
import org.stu.stuinfo.SQLexecute;
/**
 * �޸ĳɼ�
 *
 */
public class UpdateScore {
	static Connection conn = null;
	static Scanner scan = new Scanner(System.in);
	public static void updatescore() throws Exception {
		boolean flag = false;
			conn = Dbconnection.getConnection();
			if(conn==null) {
				System.out.println("��ȡʧ��");
			}else{
				//�����ѯ�����
				String sql = "select * from score "
						+ "where stucode = ? ";
				System.out.println("������ѧ��ID:");
				int stucode = scan.nextInt();
				scan.nextLine();
				Score score = new Score();
				SQLexecute<Score> sq = new SQLexecute<Score>();
				List<Score> list = sq.executeQuery
						(conn, sql,score, stucode);
				if(list.isEmpty()){
					System.out.println("û�����ѧ��,����������");
					flag = true;
				}else {
					String clazz = "    ";
					int i=0;
					List<String> cc =new ArrayList<String>();
					for(Score sc:list) {
						if(sc.getC()!=null) {
							clazz+=++i+":C����     ";
							cc.add("C");
						}
						if(sc.getJava()!=null) {
							clazz+=++i+":Java   ";
							cc.add("Java");
						}
						if(sc.getOracle()!=null) {
							clazz+=++i+":Oracle   ";
							cc.add("Oracle");
						}
						if(sc.getPS()!=null) {
							clazz+=++i+":PS    ";
							cc.add("PS");
						}
						if(sc.getHtml()!=null) {
							clazz+=++i+":Html    ";
							cc.add("Html");
						}
					}
					do {
						flag = false;
						System.out.println(clazz);
						System.out.println("\n��������Ҫ�޸ĵ�ѡ��");
						int input = scan.nextInt();
						scan.nextLine();
						int len = cc.size();
						switch(input) {
						case 1:
							if(input>len) {
								System.out.println("ѡ�����");
								flag=true;
							}else {
								 System.out.println("Ҫ��ѧ��Ϊ "+stucode+" ��"
										+ "ѧ��"+cc.get(0)+"�ɼ��޸�Ϊ��");
								int C = scan.nextInt();
								scan.nextLine();
								String updql = "update "
										+ "score set `"+cc.get(0)+"` = ? where `stucode` =?";
								SQLexecute<Score> upsq = 
										new SQLexecute<Score>();
								int rows = upsq.executeModify
										(conn, updql,C,stucode);
								if(rows<=0) {
									System.out.println("����ʧ��");
									flag = true;
								}else {
									System.out.println("���³ɹ�,Ӱ�죺"+
												rows+" ��");
									System.out.println("�Ƿ�����޸�:1����/"
											+ "������˳�");
									String y = scan.nextLine();
									switch(y) {
									case "1":flag = true;break;
									default:Mainui.Stuscore();break;
									}
								}
							}
							break;
						case 2:
							if(input>len) {
								System.out.println("ѡ�����");
								flag=true;
							}else {
								System.out.println("Ҫ��ѧ��Ϊ "+stucode+" ��"
										+ "ѧ��"+cc.get(1)+"�ɼ��޸�Ϊ��");
								int Java = scan.nextInt();
								scan.nextLine();
								String updqlm = "update "
										+ "score set `"+cc.get(1)+"` = ? where `stucode` =?";
								SQLexecute<Score> upsq2 = 
										new SQLexecute<Score>();
								int row = upsq2.executeModify
										(conn, updqlm,Java,stucode);
								if(row<=0) {
									System.out.println("����ʧ��");
									flag = true;
								}else {
									System.out.println("���³ɹ�,Ӱ�죺"+
												row+" ��");
									System.out.println("�Ƿ�����޸�:1����/"
											+ "������˳�");
									String y = scan.nextLine();
									switch(y) {
									case "1":flag = true;break;
									default:Mainui.Stuscore();break;
									}
								}
							}
							break;
						case 3:
							if(input>len) {
								System.out.println("ѡ�����");
								flag=true;
							}else {
								System.out.println("Ҫ��ѧ��Ϊ "+stucode+" ��"
										+ "ѧ��"+cc.get(2)+"�ɼ��޸�Ϊ��");
								int Oracle = scan.nextInt();
								scan.nextLine();
								String updqle = "update "
										+ "score set `"+cc.get(2)+"` = ? where `stucode` =?";
								SQLexecute<Score> upsqe = 
										new SQLexecute<Score>();
								int rowe = upsqe.executeModify
										(conn, updqle,Oracle,stucode);
								if(rowe<=0) {
									System.out.println("����ʧ��");
									flag = true;
								}else {
									System.out.println("���³ɹ�,Ӱ�죺"+
												rowe+" ��");
									System.out.println("�Ƿ�����޸�:1����/"
											+ "������˳�");
									String y = scan.nextLine();
									switch(y) {
									case "1":flag = true;break;
									default:Mainui.Stuscore();break;
									}
								}
							}
							break;
						case 4:
							if(input>len) {
								System.out.println("ѡ�����");
								flag=true;
							}else {
								System.out.println("Ҫ��ѧ��Ϊ "+stucode+" ��"
										+ "ѧ��"+cc.get(3)+"�ɼ��޸�Ϊ��");
								int ps = scan.nextInt();
								scan.nextLine();
								String updqle = "update "
										+ "score set `"+cc.get(3)+"` = ? where `stucode` =?";
								SQLexecute<Score> upsqe = 
										new SQLexecute<Score>();
								int rowe = upsqe.executeModify
										(conn, updqle,ps,stucode);
								if(rowe<=0) {
									System.out.println("����ʧ��");
									flag = true;
								}else {
									System.out.println("���³ɹ�,Ӱ�죺"+
												rowe+" ��");
									System.out.println("�Ƿ�����޸�:1����/"
											+ "������˳�");
									String y = scan.nextLine();
									switch(y) {
									case "1":flag = true;break;
									default:Mainui.Stuscore();break;
									}
								}
							}
							break;
						case 5:
							if(input>len) {
								System.out.println("ѡ�����");
								flag=true;
							}else {
								System.out.println("Ҫ��ѧ��Ϊ "+stucode+" ��"
										+ "ѧ��"+cc.get(4)+"�ɼ��޸�Ϊ��");
								int html = scan.nextInt();
								scan.nextLine();
								String updqle = "update "
										+ "score set `"+cc.get(4)+"` = ? where `stucode` =?";
								SQLexecute<Score> upsqe = 
										new SQLexecute<Score>();
								int rowe = upsqe.executeModify
										(conn, updqle,html,stucode);
								if(rowe<=0) {
									System.out.println("����ʧ��");
									flag = true;
								}else {
									System.out.println("���³ɹ�,Ӱ�죺"+
												rowe+" ��");
									System.out.println("�Ƿ�����޸�:1����/"
											+ "������˳�");
									String y = scan.nextLine();
									switch(y) {
									case "1":flag = true;break;
									default:Mainui.Stuscore();break;
									}
								}
							}
							break;
						default:System.out.println("����"
								+ "����,����������");
						flag = true;
						break;
						}
				}while(flag);
			}
			
		}
	}
}
