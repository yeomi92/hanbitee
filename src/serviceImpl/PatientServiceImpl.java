package serviceImpl;

import java.sql.SQLException;
import java.util.Calendar;

import dao.PatientDAO;
import daoImpl.PatientDAOImpl;
import domain.PatientBean;
import service.PatientService;

public class PatientServiceImpl implements PatientService{
	private PatientBean session;
	private static PatientServiceImpl instance=new PatientServiceImpl();
	PatientDAOImpl dao;
	public static PatientServiceImpl getInstance() {return instance;}
	public PatientServiceImpl() {
		dao=PatientDAOImpl.getInstance();
		session=new PatientBean();
	}
	public PatientBean getSession(){
		return session;
	}
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
		session=findById(member.getPatID());
		return session;
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
	
	@Override
	public String[] getBirth(String jumin) {
		String[] birth=new String[2];
		int ssn=Integer.parseInt(jumin.substring(0,2));
		switch(jumin.charAt(7)){
			case '1':case '2':
				birth[0]=String.valueOf(Calendar.getInstance().get(Calendar.YEAR)-(1900+ssn)+1)+"技";
				birth[1]="19"+jumin.substring(0,2)+"斥"+jumin.substring(2,4)+"岿"+jumin.substring(4,6)+"老";
				break;
			case '3':case '4':
				birth[0]=String.valueOf(Calendar.getInstance().get(Calendar.YEAR)-(2000+ssn)+1)+"技";
				birth[1]="20"+jumin.substring(0,2)+"斥"+jumin.substring(2,4)+"岿"+jumin.substring(4,6)+"老";
				break;
		}
		return birth;
	}

}
