package serviceImpl;

import java.sql.SQLException;

import dao.PatientDAO;
import daoImpl.PatientDAOImpl;
import domain.PatientBean;
import service.PatientService;

public class PatientServiceImpl implements PatientService{
	private static PatientServiceImpl instance=new PatientServiceImpl();
	PatientDAOImpl dao=PatientDAOImpl.getInstance();
	public static PatientServiceImpl getInstance() {return instance;}
	@Override
	public int join(PatientBean member) throws SQLException {
		return PatientDAOImpl.getInstance().insert(member);
	}

	@Override
	public PatientBean findById(String uid) throws SQLException {
		return dao.selectById(uid);
	}

	@Override
	public PatientBean login(PatientBean member) throws SQLException {
		return this.findById(member.getPatID());
	}

	@Override
	public int change(PatientBean member) throws SQLException {
		PatientBean[] memArr=new PatientBean[2];
		memArr[0]=member;
		memArr[1]=member;		
		System.out.println("serviceImp session"+memArr[1]);
		return PatientDAOImpl.getInstance().update(memArr);
	}

	@Override
	public int remove(PatientBean member) throws SQLException {
		PatientBean bean=new PatientBean();
		return PatientDAOImpl.getInstance().delete(bean);
	}

}
