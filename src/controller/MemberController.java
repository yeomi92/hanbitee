package controller;

import java.sql.SQLException;

import serviceImpl.MemberServiceImpl;

public class MemberController {
	public static void main(String[] args) {
		try {
			System.out.println(MemberServiceImpl.getInstance().findById("hong"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*private MemberService service;
	public MemberController() {
		service=new MemberServiceImpl();
	}*/
	
}
