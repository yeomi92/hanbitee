package service;

import java.sql.SQLException;
import domain.DoctorBean;

public interface DoctorService {
	public int join(DoctorBean member) throws SQLException ;
	public DoctorBean findById(DoctorBean member) throws SQLException ;
	public DoctorBean login(DoctorBean member) throws SQLException ;
	public int change(DoctorBean member) throws SQLException ;
	public int remove(DoctorBean member) throws SQLException ;
	//util
	public String[] getBirth(String jumin);
	public DoctorBean getSession();
}
