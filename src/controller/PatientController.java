package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.PatientBean;
import service.PatientService;
import serviceImpl.PatientServiceImpl;
import util.DispatcherServlet;
import util.Separator;

@WebServlet("/patient.do")
public class PatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PatientService service=PatientServiceImpl.getInstance();
		PatientBean bean=new PatientBean();
		System.out.println("servlet 진입성공");
		Separator.init(request, response);
		switch (Separator.command.getAction()) {
		case "move":DispatcherServlet.send(request, response);break;
		case "login":
			String pw=request.getParameter("password");
			bean.setPatID(request.getParameter("id"));
			try {
				bean=service.login(bean);
				System.out.println(bean.getPatID()+"--------"+bean.getPatPass());
				if(!bean.getPatID().equals("FAIL")&&bean.getPatPass().equals(pw)){
					DispatcherServlet.send(request, response);
				}else{
					// (bean.getPatID().equals("FAIL") || !bean.getPatPass().equals(pw))
					Separator.command.setPage("loginForm");
					Separator.command.setView();
					DispatcherServlet.send(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		default:break;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}