package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.ActionPath;

@WebServlet({"/patient/loginForm.do","/patient/registerForm.do"})
public class PatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PatientController() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("servlet 진입성공");
		String path=request.getServletPath();
		System.out.println("request가 걸어온 길: "+path);
		String[] action=ActionPath.getAction(path);
		switch (action[1]) {
		case "loginForm":
			request.getRequestDispatcher(action[3]).forward(request,response);
			break;
		case "registerForm":
			request.getRequestDispatcher(action[3]).forward(request,response);
			break;
		default:break;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
