package org.stu.mainui;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

import org.stu.Data.Dbconnection;
import org.stu.forout.Forout;
import org.stu.stuinfo.Addstuinfo;
import org.stu.stuinfo.Stuinfoui;
import org.stu.stuinfo.Updatestu;
/**
 * ������
 * @author zcy12
 *
 */
public class Mainui {
	private static Scanner scan = new Scanner(System.in);
	static Connection conn = null;
	//��½����
	public static void login() throws Exception {
		conn = Dbconnection.getConnection();
		Forout.ForOut(14,100);
		Forout.stuprin(100);
		Forout.ForOut(15,100);
		System.out.println();
		System.out.print("\t\t�˺�:");
		String username = scan.nextLine();
		System.out.print("\t\t����:");
		int password = scan.nextInt();
		scan.nextLine();
		if(conn == null){
			System.out.println("��ȡʧ��");
		}else {
			try {
				String sql = "select * from userdata";
				Statement stat = conn.createStatement();
				ResultSet rs = stat.executeQuery(sql);
					while(rs.next()) {
						if(username.equals(rs.getString("username"))&&password==rs.getInt("pwd")){
							System.out.println("\t\t��½�ɹ���");
							mainui();
							break;
						}else {
							System.out.println("\t\t�˺Ż��������");
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
	 * ���˵�
	 * @author zcy12
	 *
	 *
	 */
	//���˵�
	public static void mainui() throws Exception {
		long begintime = new Date().getTime();
		Forout.ForOut(14,100);
		Forout.stuprin(100);
		Forout.ForOut(15,100);
		System.out.print("\n||\t\t 1��ѧ����Ϣ\t\t||");
		System.out.print("\n||\t\t 2���γ̰���\t\t||");
		System.out.print("\n||\t\t 3��ѧ���ɼ�\t\t||");
		System.out.print("\n||\t\t 4����       ��\t\t||\n");
		Forout.ForOut(42,100);
		long endtime = new Date().getTime();
		System.out.println("\r\n�������,��ʱ��"+(endtime-begintime)+"ms");
		System.out.print("����������ѡ�\n");
		String n = scan.nextLine();
		switch(n) {
			case "1" : Stuinfo();break;
			case "2" : Classset();break;
			case "3" :Stuscore();break;
			case "4" : Exit();break;
			default:System.out.println("������������������");mainui();break;
		}
		}
	/**
	 * ѧ����Ϣ
	 * @author zcy12
	 *
	 */
	//ѧ����Ϣ
	public static void Stuinfo() throws Exception {
		long begintime = new Date().getTime();
		Forout.ForOut(14);
		Forout.stuprin();
		Forout.ForOut(15);
		System.out.print("\n||\t\t 1��ѧ����Ϣ\t\t||");
		System.out.print("\n||\t\t 2�����ѧ��\t\t||");
		System.out.print("\n||\t\t 3���޸�ѧ��\t\t||");
		System.out.print("\n||\t\t 4�����ز˵�\t\t||");
		System.out.print("\n||\t\t 5����       ��\t\t||\n");
		Forout.ForOut(42);
		long endtime = new Date().getTime();
		System.out.println("\r\n�������,��ʱ��"+(endtime-begintime)+"ms");
		System.out.print("����������ѡ�");
		String n = scan.nextLine();
		switch(n) {
			case "1":Stuinfoui.Stuinfoui();break;
			case "2":Addstuinfo.addstuinfo();break;
			case "3":Updatestu.update();break;
			case "4":mainui();break;
			case "5":Exit();break;
			default:System.out.println("������������������");Stuinfo();break;
		}
	}
	/**
	 * �γ̰���
	 * @author zcy12
	 */
	//�γ̰���
	public static void Classset() throws Exception {
		long begintime = new Date().getTime();
		Forout.ForOut(14);
		Forout.stuprin();
		Forout.ForOut(15);
		System.out.print("\n||\t\t 1���鿴�γ�\t\t||");
		System.out.print("\n||\t\t 2���޸Ŀγ�\t\t||");
		System.out.print("\n||\t\t 3�����ز˵�\t\t||");
		System.out.print("\n||\t\t 4����       ��\t\t||\n");
		Forout.ForOut(42);
		long endtime = new Date().getTime();
		System.out.println("\r\n�������,��ʱ��"+(endtime-begintime)+"ms");
		System.out.print("����������ѡ�");
		String n = scan.nextLine();
		switch(n) {
		case "1":break;
		case "2":break;
		case "3":mainui();break;
		case "4":Exit();break;
		default:System.out.println("������������������");Classset();break;
	}
	}
	/**
	 * ѧ���ɼ�
	 * @author zcy12
	 */
	//ѧ���ɼ�
	public static void Stuscore() throws Exception {
		long begintime = new Date().getTime();
		Forout.ForOut(14);
		Forout.stuprin();
		Forout.ForOut(15);
		System.out.print("\n||\t\t 1���鿴�ɼ�        \t\t||");
		System.out.print("\n||\t\t 2���޸ĳɼ�\t\t||");
		System.out.print("\n||\t\t 3�����ز˵�\t\t||");
		System.out.print("\n||\t\t 4����        ��\t\t||\n");
		Forout.ForOut(42);
		long endtime = new Date().getTime();
		System.out.println("\r\n�������,��ʱ��"+(endtime-begintime)+"ms");
		System.out.print("����������ѡ�");
		String n = scan.nextLine();
		switch(n) {
		case "1":break;
		case "2":break;
		case "3":mainui();break;
		case "4":Exit();break;
		default:System.out.println("������������������");Stuscore();break;
	}
	}
	//�˳�
	public static void Exit() throws InterruptedException {
		System.out.println("�˳��ɹ�");
		System.exit(0);
	}
	@Override
	protected void finalize() throws Throwable { 
		super.finalize();
		scan.close();
		scan = null;
	}
}
	

