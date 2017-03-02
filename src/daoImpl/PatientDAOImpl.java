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
		return DatabaseFactory.createDatabase(Vendor.ORACLE,Database.USERNAME,Database.PASSWORD).getConnection().createStatement().executeUpdate(String.format("INSERT INTO Patient(pat_id,nur_id,doc_id,pat_pass,pat_name,pat_gen,pat_jumin,pat_addr,pat_phone,pat_email,pat_job) VALUES('%s','%s','%s','%s','%s','%s','%s','%s','%s','%s','%s')", patient.getPatID(),patient.getNurID(),patient.getDocID(),patient.getPatPass(),patient.getPatName(),patient.getPatGen(),patient.getPatJumin(),patient.getPatAddr(),patient.getPatPhone(),patient.getPatEmail(),patient.getPatJob()));
	}
	
	@Override
	public PatientBean selectById(String uid) throws SQLException {
		PatientBean temp=new PatientBean();
		ResultSet set=DatabaseFactory.createDatabase(Vendor.ORACLE,Database.USERNAME,Database.PASSWORD).getConnection().createStatement().executeQuery(String.format("select p.pat_id, p.nur_id, p.doc_id, p.pat_pass, p.pat_name, p.pat_gen, p.pat_jumin, p.pat_addr, p.pat_phone, p.pat_email, p.pat_job, d.doc_name from patient p, doctor d where p.pat_id='%s' and p.doc_id=d.doc_id",uid));
		if(set.next()){
			temp.setPatID(set.getString("pat_id"));
			temp.setNurID(set.getString("nur_id"));
			temp.setDocID(set.getString("doc_name"));
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
