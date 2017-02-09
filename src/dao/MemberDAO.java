package dao;

import domain.MemberBean;

public interface MemberDAO {
	public void insert(MemberBean member);
	public MemberBean selectById(String uid);
	public boolean login(MemberBean member);
	public void update(MemberBean member);
	public void delete(MemberBean member);
}
