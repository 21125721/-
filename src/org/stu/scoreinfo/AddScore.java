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
			System.out.println("��ѡ��γ�:");
			one = scan.nextLine();
			switch(one) {
			case "1":one = "C";
				String sqlclass = "update score set `C` = ?"
						+ " where stucode = ?";
				SQLexecute<Score> sq = new SQLexecute<Score>();
				int rows=sq.executeModify(conn,sqlclass,0,id);
				if(rows>0) {
					System.out.println("��ӳɹ�,Ӱ�죺"+rows+" ��");
					System.out.println("�Ƿ����ѡ��:1:����/�����������һ��");
					String y = scan.nextLine();
					if(y.equals("1")) {
						flag = true;
					}else {
						
					}
				}else {
					System.out.println("���ʧ��");
				}
				break;
			case "2":one = "Java";
				String sqlclass2 = "update score set `Java`= ?"
						+ " where stucode = ?";
				SQLexecute<Score> sq2 = new SQLexecute<Score>();
				int rows2=sq2.executeModify(conn,sqlclass2,0,id);
				if(rows2>0) {
					System.out.println("��ӳɹ�,Ӱ�죺"+rows2+" ��");
					System.out.println("�Ƿ����ѡ��:1:����/�����������һ��");
					String y = scan.nextLine();
					if(y.equals("1")) {
						flag = true;
					}else {
						
					}
				}else {
					System.out.println("���ʧ��");
				}
				break;
			case "3":one = "Oracle";
				String sqlclass3 = "update score set `Oracle`= ?"
						+ " where stucode=?";
				SQLexecute<Score> sq3 = new SQLexecute<Score>();
				int rows3=sq3.executeModify(conn,sqlclass3,0,id);
				if(rows3>0) {
					System.out.println("��ӳɹ�,Ӱ�죺"+rows3+" ��");
					System.out.println("�Ƿ����ѡ��:1:����/�����������һ��");
					String y = scan.nextLine();
					if(y.equals("1")) {
						flag = true;
					}else {
						
					}
				}else {
					System.out.println("���ʧ��");
				}
				break;
			case "4":one = "PS";
				String sqlclass4 = "update score set `PS` = ?"
						+ " where stucode=?";
				SQLexecute<Score> sq4 = new SQLexecute<Score>();
				int rows4=sq4.executeModify(conn,sqlclass4,0,id);
				if(rows4>0) {
					System.out.println("��ӳɹ�,Ӱ�죺"+rows4+" ��");
					System.out.println("�Ƿ����ѡ��:1:����/�����������һ��");
					String y = scan.nextLine();
					if(y.equals("1")) {
						flag = true;
					}else {
						
					}
				}else {
					System.out.println("���ʧ��");
				}
				break;
			case "5":one = "Html";
				String sqlclass5 = "update score set `Html`= ?"
						+ " where stucode=?";
				SQLexecute<Score> sq5 = new SQLexecute<Score>();
				int rows5=sq5.executeModify(conn,sqlclass5,0,id);
				if(rows5>0) {
					System.out.println("��ӳɹ�,Ӱ�죺"+rows5+" ��");
					System.out.println("�Ƿ����ѡ��:1:����/�����������һ��");
					String y = scan.nextLine();
					if(y.equals("1")) {
						flag = true;
					}else {
						
					}
				}else {
					System.out.println("���ʧ��");
				}
				break;
			default:System.out.println("�������,����������");
					flag=true;
					break;
			}
			
		}while(flag);
		scan.close();
	}
}
