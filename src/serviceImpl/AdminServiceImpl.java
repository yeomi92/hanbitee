package serviceImpl;

import domain.MemberBean;
import service.AdminService;
import java.util.*;

public class AdminServiceImpl implements AdminService{
	private Map<String,MemberBean> map;
	public AdminServiceImpl() {
		map = new HashMap<String,MemberBean>();
	}
	@Override
	public void regist(MemberBean member) {
		map.put(member.getId(), member);
	}
	@Override
	public MemberBean findById(String uid) {
		return map.get(uid);
	}
	@Override
	public List<MemberBean> findByName(String name) {
		List<MemberBean> temp=new ArrayList<MemberBean>();
		for(MemberBean i : memberList()){
			if(name.equals(i.getName())){
				temp.add(i);
			}
		}
		return temp;
	}
	@Override
	public List<MemberBean> memberList() {
		List<MemberBean> temp=new ArrayList<MemberBean>();
		for(Map.Entry<String, MemberBean> e : map.entrySet()){
			temp.add(e.getValue());
		}
		return temp;
	}
	@Override
	public int count() {
		return map.size();
	}
	@Override
	public void update(MemberBean member) {
		if(map.containsKey(member.getId())){
			map.get(member.getId()).setName(member.getName().equals("")?map.get(member.getId()).getName():member.getName());
			map.get(member.getId()).setEmail(member.getEmail().equals("")?map.get(member.getId()).getEmail():member.getEmail());
			map.get(member.getId()).setPhone(member.getPhone().equals("")?map.get(member.getId()).getPhone():member.getPhone());
		}
	}
	@Override
	public void remove(String uid) {
			map.remove(uid);
	}
	@Override
	public Map<String, MemberBean> mapFindByName(String name) {
		Map<String, MemberBean> temp=new HashMap<String,MemberBean>();
		for(Map.Entry<String, MemberBean> e : map.entrySet()){
			if(name.equals(e.getValue().getName())){
				temp.put(e.getKey(), e.getValue());
			}
		}
		return temp;
	}
	@Override
	public Set<String> keyList() {
		return map.keySet();
	}
	
}
