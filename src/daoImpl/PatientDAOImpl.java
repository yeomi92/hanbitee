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
		ResultSet set=DatabaseFactory.createDatabase(Vendor.ORACLE,Database.USERNAME,Database.PASSWORD).getConnection().createStatement().executeQuery(String.format("select pat_id, nur_id, doc_id, pat_pass, pat_name, pat_gen, pat_jumin, pat_addr, pat_phone, pat_email, pat_job from patient where pat_id='%s'",uid));
		if(set.next()){
			temp.setPatID(set.getString("pat_id"));
			temp.setNurID(set.getString("nur_id"));
			temp.setDocID(set.getString("doc_id"));
			temp.setPatPass(set.getString("pat_pass"));
			temp.setPatName(set.getString("pat_name"));
			temp.setPatGen(set.getString("pat_gen"));
			temp.setPatJumin(set.getString("pat_jumin"));
			temp.setPatAddr(set.getString("pat_addr"));
			temp.setPatPhone(set.getString("pat_phone"));
			temp.setPatEmail(set.getString("pat_email"));
			temp.setPatJob(set.getString("pat_job"));

		}else{
			temp.setPatID("FAIL");
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
