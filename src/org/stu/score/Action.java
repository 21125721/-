package org.stu.score;

import java.sql.Connection;

import org.stu.Data.Dbconnection;
import org.stu.students.Getstucode;
import org.stu.stuinfo.SQLexecute;

public class Action {

	public static void main(String[] args) throws Exception {
		Connection conn = Dbconnection.getConnection();
		int id =Getstucode.getstucode();
		System.out.println(id);
		String sqlclass5 = "update score set `Html`= ? where stucode=?";
		SQLexecute<Score> sq5 = new SQLexecute<Score>();
		int rows5=sq5.executeModify(conn,sqlclass5,0,id);
		if(rows5>0) {
			System.out.println("1");
		}else {
			System.out.println("0");
		}
	}

}
