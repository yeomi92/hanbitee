package daoImpl;

import java.sql.*;
import constants.Database;
import dao.MemberDAO;
import domain.MemberBean;
import enums.Vendor;
import factory.DatabaseFactory;

public class MemberDAOImpl implements MemberDAO{
	@Override
	public void insert(MemberBean member) {
		try {
			DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERNAME,Database.PASSWORD).getConnection().createStatement().executeUpdate(String.format("INSERT INTO Member(id,name,ssn,password,profileImg,phone,email,rank)VALUES('%s','%s','%s','%s','%s','%s','%s','C')",member.getId(),member.getName(),member.getSsn(),member.getPassword(),member.getProfileImg(),member.getPhone(),member.getEmail()));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public MemberBean selectById(String uid) {
		MemberBean temp=new MemberBean();
		String sql=String.format("SELECT * FROM Member WHERE id = '%s'", uid);
		try {
			ResultSet set=DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERNAME,Database.PASSWORD).getConnection().createStatement().executeQuery(sql);
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
		try {
			ResultSet set1=DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERNAME,Database.PASSWORD).getConnection().createStatement().executeQuery(String.format("SELECT * FROM Member WHERE id = '%s'", member.getId()));
			while(set1.next()){
				DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERNAME,Database.PASSWORD).getConnection().createStatement().executeUpdate(String.format("UPDATE Member SET name='%s',password='%s',profileImg='%s',phone='%s',email='%s' WHERE id='%s'",(member.getName().equals("")?set1.getString("name"):member.getName()),(member.getPassword().equals("")?set1.getString("password"):member.getPassword()),(member.getProfileImg().equals("")?set1.getString("profileImg"):member.getProfileImg()),(member.getPhone().equals("")?set1.getString("phone"):member.getPhone()),(member.getEmail().equals("")?set1.getString("email"):member.getEmail()),member.getId()));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	@Override
	public void delete(MemberBean member) {
		String sql=String.format("DELETE FROM Member WHERE id='%s'", member.getId());
		try {
			DatabaseFactory.createDatabase(Vendor.ORACLE,Database.USERNAME,Database.PASSWORD).getConnection().createStatement().executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
