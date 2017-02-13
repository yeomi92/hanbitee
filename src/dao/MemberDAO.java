package dao;

import java.sql.SQLException;

import domain.MemberBean;

public interface MemberDAO {
	public int insert(MemberBean member)throws SQLException;
	public MemberBean selectById(String uid)throws SQLException;
	public boolean login(MemberBean member)throws SQLException;
	public int update(MemberBean[] member)throws SQLException;
	public int delete(MemberBean member)throws SQLException;
}
