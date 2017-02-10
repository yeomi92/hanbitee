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
	public void insert(MemberBean member) throws SQLException {
		DatabaseFactory.createDatabase(Vendor.ORACLE,Database.USERNAME,Database.PASSWORD).getConnection().createStatement().executeUpdate(String.format("INSERT INTO Member(id,name,ssn,password,profileImg,phone,email,rank)VALUES('%s','%s','%s','%s','%s','%s','%s','C')",member.getId(),member.getName(),member.getSsn(),member.getPassword(),member.getProfileImg(),member.getPhone(),member.getEmail()));
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
		}
		return temp;
	}
	
	@Override
	public boolean login(MemberBean member) throws SQLException {
		boolean loginch=false;
		MemberBean temp=selectById(member.getId());
		if(temp.getId().equals("")){
			loginch=false;
		}else{
			if((member.getId().equals(temp.getId()))&&(member.getPassword().equals(temp.getPassword()))){
				loginch=true;
			}
		}
		return loginch;
	}
	
	@Override
	public void update(MemberBean member) throws SQLException {
		MemberBean temp = selectById(member.getId());
		DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERNAME,Database.PASSWORD).getConnection().createStatement().executeUpdate(String.format("UPDATE Member SET name='%s',password='%s',profileImg='%s',phone='%s',email='%s' WHERE id='%s'",(member.getName().equals("")?temp.getName():member.getName()),(member.getPassword().equals("")?temp.getPassword():member.getPassword()),(member.getProfileImg().equals("")?temp.getProfileImg():member.getProfileImg()),(member.getPhone().equals("")?temp.getPhone():member.getPhone()),(member.getEmail().equals("")?temp.getEmail():member.getEmail()),member.getId()));
	}
	
	@Override
	public void delete(MemberBean member) throws SQLException{
		String sql=String.format("DELETE FROM Member WHERE id='%s'", member.getId());
		DatabaseFactory.createDatabase(Vendor.ORACLE,Database.USERNAME,Database.PASSWORD).getConnection().createStatement().executeUpdate(sql);
	}
}
