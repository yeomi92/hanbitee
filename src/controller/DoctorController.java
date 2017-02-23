package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.DoctorBean;
import domain.PatientBean;
import service.DoctorService;
import serviceImpl.DoctorServiceImpl;
import util.DispatcherServlet;
import util.Separator;

@WebServlet("/doctor.do")
public class DoctorController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Separator.init(request, response);
		HttpSession session=request.getSession();
		DoctorService service=new DoctorServiceImpl();
		switch (Separator.command.getAction()) {
		case "detail":
			try {
				DoctorBean temp=new DoctorBean();
				temp.setDocName(request.getParameter("docName"));
				session.setAttribute("doctor", service.findById(temp));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			System.out.println("의사 상세보기 경로: "+Separator.command.getView());
			DispatcherServlet.send(request, response);break;
		default:
			break;
		}
	}

}
