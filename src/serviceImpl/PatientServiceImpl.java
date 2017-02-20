package serviceImpl;

import java.sql.SQLException;

import dao.PatientDAO;
import daoImpl.PatientDAOImpl;
import domain.PatientBean;
import service.PatientService;

public class PatientServiceImpl implements PatientService{
	private static PatientServiceImpl instance=new PatientServiceImpl();
	public static PatientServiceImpl getInstance() {return instance;}
	private PatientBean session;
	public PatientServiceImpl() {
		session=new PatientBean();
	}
	@Override
	public int join(PatientBean member) throws SQLException {
		return PatientDAOImpl.getInstance().insert(member);
	}

	@Override
	public PatientBean findById(String uid) throws SQLException {
		session=PatientDAOImpl.getInstance().selectById(uid);
		return session;
	}

	@Override
	public boolean login(PatientBean member) throws SQLException {
		return PatientDAOImpl.getInstance().login(member);
	}

	@Override
	public int change(PatientBean member) throws SQLException {
		PatientBean[] memArr=new PatientBean[2];
		memArr[0]=member;
		memArr[1]=session;		
		System.out.println("serviceImp session"+memArr[1]);
		return PatientDAOImpl.getInstance().update(memArr);
	}

	@Override
	public int remove(PatientBean member) throws SQLException {
		return PatientDAOImpl.getInstance().delete(session);
	}

}
