package daoImpl;

import java.sql.*;
import constants.Database;
import dao.PatientDAO;
import domain.PatientBean;
import enums.Vendor;
import factory.DatabaseFactory;

public class PatientDAOImpl  implements PatientDAO {
	public static PatientDAOImpl getInstance() {
		return new PatientDAOImpl();
	}

	@Override
	public int insert(PatientBean patient) throws SQLException {
		return DatabaseFactory.createDatabase(Vendor.ORACLE,Database.USERNAME,Database.PASSWORD).getConnection().createStatement().executeUpdate("");
	}
	
	@Override
	public PatientBean selectById(String uid) throws SQLException {
		PatientBean temp=new PatientBean();
		ResultSet set=DatabaseFactory.createDatabase(Vendor.ORACLE,Database.USERNAME,Database.PASSWORD).getConnection().createStatement().executeQuery("");
		if(set.next()){
			
		}else{
			temp=null;
		}
		return temp;
	}
	
	@Override
	public boolean login(PatientBean patient) throws SQLException {
		boolean loginch=false;
		/*PatientBean mem=selectById(patient.getId());
		if((patient.getPassword().equals(mem.getPassword()))){
			loginch=true;
		}*/
		return loginch;
	}
	
	@Override
	public int update(PatientBean[] patient) throws SQLException {
		return DatabaseFactory.createDatabase(Vendor.ORACLE, Database.USERNAME,Database.PASSWORD).getConnection().createStatement().executeUpdate("");
	}
	
	@Override
	public int delete(PatientBean patient) throws SQLException{
		String sql="";
		return DatabaseFactory.createDatabase(Vendor.ORACLE,Database.USERNAME,Database.PASSWORD).getConnection().createStatement().executeUpdate(sql);
	}
}
