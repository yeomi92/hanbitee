package serviceImpl;

import java.sql.SQLException;
import daoImpl.DoctorDAOImpl;
import domain.DoctorBean;
import service.DoctorService;

public class DoctorServiceImpl implements DoctorService{
	public static DoctorServiceImpl instance=new DoctorServiceImpl();
	public static DoctorServiceImpl getInstance(){return instance;}
	private DoctorDAOImpl dao;
	public DoctorServiceImpl() {
		dao=DoctorDAOImpl.getInstance();
	}
	@Override
	public int join(DoctorBean member) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DoctorBean findById(DoctorBean member) throws SQLException {
		return dao.selectById(member);
	}

	@Override
	public DoctorBean login(DoctorBean member) throws SQLException {
		
		return null;
	}

	@Override
	public int change(DoctorBean member) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int remove(DoctorBean member) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String[] getBirth(String jumin) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DoctorBean getSession() {
		// TODO Auto-generated method stub
		return null;
	}

}
