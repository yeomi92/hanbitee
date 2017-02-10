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
	public void join(MemberBean member) throws SQLException {
		MemberDAOImpl.getInstance().insert(member);
	}

	@Override
	public MemberBean findById(String uid) throws SQLException {
		session=MemberDAOImpl.getInstance().selectById(uid);
		return session;
	}

	@Override
	public boolean login(MemberBean member) throws SQLException {
		
		return MemberDAOImpl.getInstance().login(session);
	}

	@Override
	public void change(MemberBean member) throws SQLException {
		MemberDAOImpl.getInstance().update(member);
	}

	@Override
	public void remove(MemberBean member) throws SQLException {
		MemberDAOImpl.getInstance().delete(member);
	}

}
