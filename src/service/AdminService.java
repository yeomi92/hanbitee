package service;

import domain.MemberBean;
import java.util.*;

public interface AdminService {
	//create
	public void regist(MemberBean member);
	//read
	public MemberBean findById(String uid);
	public List<MemberBean> findByName(String name);//������������ Sequence������ �ִ� ArrayList�� ������.
	public Map<String,MemberBean> mapFindByName(String name);
	public List<MemberBean> memberList();//������������ Sequence������ �ִ� ArrayList�� ������.
	public Set<String> keyList();
	public int count();
	//update
	public void update(MemberBean member);
	//remove
	//public void remove(String uid, String pw);//�̷����ϸ� PW�� ����ȴ�.
	public void remove(String uid);
}