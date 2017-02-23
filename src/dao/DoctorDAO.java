package dao;

import java.sql.SQLException;

import domain.DoctorBean;

public interface DoctorDAO {
	public int insert(DoctorBean member)throws SQLException;
	public DoctorBean selectById(DoctorBean member)throws SQLException;
	public boolean login(DoctorBean member)throws SQLException;
	public int update(DoctorBean[] member)throws SQLException;
	public int delete(DoctorBean member)throws SQLException;
}
