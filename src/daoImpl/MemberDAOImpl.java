package daoImpl;

import java.sql.*;
import constants.Database;
import dao.MemberDAO;
import domain.MemberBean;
import enums.Vendor;
import factory.DatabaseFactory;

public class MemberDAOImpl implements MemberDAO{
	private Connection connection;
	private Statement stmt;
	private ResultSet set;
	public MemberDAOImpl() {
		try {
			connection=DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERNAME,Database.PASSWORD).getConnection();
			stmt=connection.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void insert(MemberBean member) {
		try {
			int count=stmt.executeUpdate(String.format("INSERT INTO Member(id,name,ssn,password,profileImg,phone,email,rank)VALUES('%s','%s','%s','%s','%s','%s','%s','C')",member.getId(),member.getName(),member.getSsn(),member.getPassword(),member.getProfileImg(),member.getPhone(),member.getEmail()));
			System.out.println(count);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public MemberBean selectById(String uid) {
		MemberBean temp=new MemberBean();
		String sql=String.format("SELECT * FROM Member WHERE id = '%s'", uid);
		try {
			set=stmt.executeQuery(sql);
			if(stmt.execute(String.format(sql))){
				set=stmt.executeQuery(String.format(sql));
				while(set.next()){
					temp.setId(set.getString("id"));
					temp.setName(set.getString("name"));
					temp.setSsn(set.getString("ssn"));
					temp.setPassword(set.getString("password"));
					temp.setProfileImg(set.getString("profileImg"));
					temp.setPhone(set.getString("phone"));
					temp.setEmail(set.getString("email"));
					temp.setRank(set.getString("rank"));
				}
			}else{
				temp=null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public boolean login(MemberBean member) {
		return false;
	}

	@Override
	public void update(MemberBean member) {
		String sql=String.format("SELECT * FROM Member WHERE id = '%s'", member.getId());
		
	}

	@Override
	public void delete(MemberBean member) {
		
	}
}
