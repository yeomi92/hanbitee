package service;

import java.sql.SQLException;

import domain.PatientBean;

public interface PatientService {
	public int join(PatientBean member) throws SQLException ;
	public PatientBean findById(String uid) throws SQLException ;
	public PatientBean login(PatientBean member) throws SQLException ;
	public int change(PatientBean member) throws SQLException ;
	public int remove(PatientBean member) throws SQLException ;
}
