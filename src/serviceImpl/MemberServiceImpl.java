package serviceImpl;

import java.sql.SQLException;

import dao.MemberDAO;
import daoImpl.MemberDAOImpl;
import domain.MemberBean;
import service.MemberService;

public class MemberServiceImpl implements MemberService{
	/*private static MemberServiceImpl instance=new MemberServiceImpl();
	public static MemberServiceImpl getInstance() {
		return instance;
	}*/
	public static MemberServiceImpl getInstance() {
		return new MemberServiceImpl();
	}
	@Override
	public void join(MemberBean member) throws SQLException {
		MemberDAOImpl.getInstance().insert(member);
	}

	@Override
	public MemberBean findById(String uid) throws SQLException {
		return MemberDAOImpl.getInstance().selectById(uid);
	}

	@Override
	public boolean login(MemberBean member) throws SQLException {
		return MemberDAOImpl.getInstance().login(member);
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
