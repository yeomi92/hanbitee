package util;

import java.sql.*;

import constants.Database;

public class JdbcTest {
	public String getName() {
		String rs="";
		try {
			Class.forName(Database.ORACLE_DRIVER);
			Connection connection=DriverManager.getConnection(Database.ORACLE_URL,Database.USERNAME,Database.PASSWORD);
			Statement stmt=connection.createStatement();
			String sql="SELECT * FROM Member WHERE id='hong'",result="";
			ResultSet set=stmt.executeQuery(sql);
			while(set.next()){
				rs=set.getString("name");
			}
		} catch (Exception e) {
			rs="에러발생";
			e.printStackTrace();
		}
		return rs;
	}
}
