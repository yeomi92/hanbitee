package service;

import java.sql.SQLException;

import domain.MemberBean;

public interface MemberService {
	public void join(MemberBean member) throws SQLException ;
	public MemberBean findById(String uid) throws SQLException ;
	public boolean login(MemberBean member) throws SQLException ;
	public void change(MemberBean member) throws SQLException ;
	public void remove(MemberBean member) throws SQLException ;
}
