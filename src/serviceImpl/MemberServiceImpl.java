package serviceImpl;

import java.sql.SQLException;

import dao.MemberDAO;
import daoImpl.MemberDAOImpl;
import domain.MemberBean;
import service.MemberService;

public class MemberServiceImpl implements MemberService{
	private static MemberServiceImpl instance=new MemberServiceImpl();
	public static MemberServiceImpl getInstance() {return instance;}
	private MemberBean session;
	public MemberServiceImpl() {
		session=new MemberBean();
	}
	@Override
	public int join(MemberBean member) throws SQLException {
		return MemberDAOImpl.getInstance().insert(member);
	}

	@Override
	public MemberBean findById(String uid) throws SQLException {
		session=MemberDAOImpl.getInstance().selectById(uid);
		return session;
	}

	@Override
	public boolean login(MemberBean member) throws SQLException {
		return MemberDAOImpl.getInstance().login(member);
	}

	@Override
	public int change(MemberBean member) throws SQLException {
		MemberBean[] memArr=new MemberBean[2];
		memArr[0]=member;
		memArr[1]=session;		
		System.out.println("serviceImp session"+memArr[1]);
		return MemberDAOImpl.getInstance().update(memArr);
	}

	@Override
	public int remove(MemberBean member) throws SQLException {
		return MemberDAOImpl.getInstance().delete(session);
	}

}
