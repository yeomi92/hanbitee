package daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;

import constants.Database;
import dao.DoctorDAO;
import domain.DoctorBean;
import enums.Vendor;
import factory.DatabaseFactory;

public class DoctorDAOImpl implements DoctorDAO{
	public static DoctorDAOImpl getInstance() {
		return new DoctorDAOImpl();
	}

	@Override
	public int insert(DoctorBean member) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DoctorBean selectById(DoctorBean member) throws SQLException {
		DoctorBean temp=new DoctorBean();
		ResultSet set=DatabaseFactory.createDatabase(Vendor.ORACLE,Database.USERNAME,Database.PASSWORD).getConnection().createStatement().executeQuery(String.format("select doc_id, doc_pass, major_treat, doc_name, doc_gen, doc_phone, doc_email, doc_position from doctor where doc_name='%s' or doc_id='%s'",member.getDocName(),member.getDocID()));
		if(set.next()){
			temp.setDocID(set.getString("doc_id"));
			temp.setDocPass(set.getString("doc_pass"));
			temp.setMajorTreat(set.getString("major_treat"));
			temp.setDocName(set.getString("doc_name"));
			temp.setDocGen(set.getString("doc_gen"));
			temp.setDocPhone(set.getString("doc_phone"));
			temp.setDocEmail(set.getString("doc_email"));
			temp.setDocPosition(set.getString("doc_position"));
		}
		return temp;
	}

	@Override
	public boolean login(DoctorBean member) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int update(DoctorBean[] member) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(DoctorBean member) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
