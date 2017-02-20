package dao;

import java.sql.SQLException;
import domain.PatientBean;

public interface PatientDAO {
	public int insert(PatientBean member)throws SQLException;
	public PatientBean selectById(String uid)throws SQLException;
	public boolean login(PatientBean member)throws SQLException;
	public int update(PatientBean[] member)throws SQLException;
	public int delete(PatientBean member)throws SQLException;
}
