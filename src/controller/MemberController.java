package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({"/patient/loginForm.do","/patient/registForm.do","/admin/loginForm.do"})
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MemberController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("servlet 진입성공");
		String path=request.getServletPath();
		System.out.println("request가 걸어온 길: "+path);
		this.dopatient(path, request, response);
		
		
	}
	
	protected void dopatient(String path,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String patPath="/WEB-INF/jsp/patient/";
		String extension=".jsp";
		String cmd=path.split("/")[2];
		System.out.println(cmd);
		switch (cmd) {
		case "loginForm.do":
			request.getRequestDispatcher(patPath+"loginForm"+extension).forward(request,response);
			break;
		case "registForm.do":
			request.getRequestDispatcher(patPath+"registerForm"+extension).forward(request,response);
			break;
		default:break;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
