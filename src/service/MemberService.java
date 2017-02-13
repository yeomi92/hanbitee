package service;

import java.sql.SQLException;

import domain.MemberBean;

public interface MemberService {
	public int join(MemberBean member) throws SQLException ;
	public MemberBean findById(String uid) throws SQLException ;
	public boolean login(MemberBean member) throws SQLException ;
	public int change(MemberBean member) throws SQLException ;
	public int remove(MemberBean member) throws SQLException ;
}
