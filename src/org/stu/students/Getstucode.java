package org.stu.students;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.stu.Data.Dbconnection;

public class Getstucode {
	public static int getstucode() throws Exception {
		int id = 0;
		Connection conn = Dbconnection.getConnection();
		String sql = "select * from stu where stucode=("
				+ "	select max(stucode) from stu)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		if(rs.next()) {
			id=rs.getInt("stucode");
		}
		return id;
	}
}
