package daoImpl;

import java.sql.*;
import constants.Database;
import dao.MemberDAO;
import domain.MemberBean;
import enums.Vendor;
import factory.DatabaseFactory;

public class MemberDAOImpl  implements MemberDAO {
	public static MemberDAOImpl getInstance() {
		return new MemberDAOImpl();
	}

	@Override
	public int insert(MemberBean member) throws SQLException {
		return DatabaseFactory.createDatabase(Vendor.ORACLE,Database.USERNAME,Database.PASSWORD).getConnection().createStatement().executeUpdate(String.format("INSERT INTO Member(id,name,ssn,password,profileImg,phone,email,rank)VALUES('%s','%s','%s','%s','%s','%s','%s','C')",member.getId(),member.getName(),member.getSsn(),member.getPassword(),member.getProfileImg(),member.getPhone(),member.getEmail()));
	}
	
	@Override
	public MemberBean selectById(String uid) throws SQLException {
		MemberBean temp=new MemberBean();
		ResultSet set=DatabaseFactory.createDatabase(Vendor.ORACLE,Database.USERNAME,Database.PASSWORD).getConnection().createStatement().executeQuery(String.format("SELECT * FROM Member WHERE id = '%s'", uid));
		if(set.next()){
			temp.setId(set.getString("id"));
			temp.setName(set.getString("name"));
			temp.setSsn(set.getString("ssn"));
			temp.setPassword(set.getString("password"));
			temp.setProfileImg(set.getString("profileImg"));
			temp.setPhone(set.getString("phone"));
			temp.setEmail(set.getString("email"));
			temp.setRank(set.getString("rank"));
		}else{
			temp=null;
		}
		return temp;
	}
	
	@Override
	public boolean login(MemberBean member) throws SQLException {
		boolean loginch=false;
		MemberBean mem=selectById(member.getId());
		if((member.getPassword().equals(mem.getPassword()))){
			loginch=true;
		}
		return loginch;
	}
	
	@Override
	public int update(MemberBean[] member) throws SQLException {
		System.out.println("member[0]: "+member[0]);
		System.out.println("member[1]: "+member[1]);
		return DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERNAME,Database.PASSWORD).getConnection().createStatement().executeUpdate(String.format("UPDATE Member SET name='%s',password='%s',profileImg='%s',phone='%s',email='%s' WHERE id='%s'",(member[0].getName().equals("")?member[1].getName():member[0].getName()),(member[0].getPassword().equals("")?member[1].getPassword():member[0].getPassword()),(member[0].getProfileImg().equals("")?member[1].getProfileImg():member[0].getProfileImg()),(member[0].getPhone().equals("")?member[1].getPhone():member[0].getPhone()),(member[0].getEmail().equals("")?member[1].getEmail():member[0].getEmail()),member[1].getId()));
	}
	
	@Override
	public int delete(MemberBean member) throws SQLException{
		String sql=String.format("DELETE FROM Member WHERE id='%s'", member.getId());
		return DatabaseFactory.createDatabase(Vendor.ORACLE,Database.USERNAME,Database.PASSWORD).getConnection().createStatement().executeUpdate(sql);
	}
}
