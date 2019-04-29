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
	 * ���ѧ����Ϣ
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
				System.out.println("��ȡʧ��");
			}else {
				//����������ݵ�sql���
				String sql = "insert into stu(`name`,`sex`,`age`,`phoneid`) values(?,?,?,?)";
				do {
					flag = false;
					System.out.println("����������:");
					name = scan.nextLine();
					if("".trim().equals(name)) {
						System.out.println("��������Ϊ��, ����������");
						flag = true;
					}
				}while(flag);
				do {
					flag = false;
					System.out.println("�������Ա�:��/Ů");
					sex = scan.nextLine();
					if(!sex.equals("��")&&!sex.equals("Ů")) {
						System.out.println("�������,����������:");
						flag = true;
					}
				}while(flag);
				do {
					flag = false;
					System.out.println("����������:");
					age = scan.nextInt();
					scan.nextLine();
					if(age <1&&age >99) {
						System.out.println("�������,����������:");
						flag = true;
					}
				}while(flag);
				do {
					flag = false;
					System.out.println("�������ֻ���:");
					phoneid = scan.nextLine();
					if(!phoneid.trim().matches("^(13|15|18|17)\\d{9}$")) {
						System.out.println("�������,����������:");
						flag = true;
					}
				}while(flag);
				SQLexecute<Students> sq = new SQLexecute<Students>();
				int rows=sq.executeModify(conn,sql,name,sex,age,phoneid);
				if(rows<0) {
					System.out.println("���ʧ��");
				}else {
					System.out.println("��ӳɹ�,Ӱ��:"+rows+"��");
					String sqlclass = 
							"insert into score(`existence`)values(?)";
					SQLexecute<Score> sqq = new SQLexecute<Score>();
					int row=sqq.executeModify(conn, sqlclass,1);
					if(row>0) {
						System.out.println("��ӳɹ�");
					}else {
						System.out.println("ʧ��");
					}
					System.out.println("�����ѡ��γ�");
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
