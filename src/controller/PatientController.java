package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.PatientBean;
import service.PatientService;
import serviceImpl.PatientServiceImpl;
import util.DispatcherServlet;
import util.Separator;

@WebServlet("/patient.do")
public class PatientController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session=request.getSession();
		PatientService service=PatientServiceImpl.getInstance();
		PatientBean bean=new PatientBean();
		System.out.println("servlet 진입성공");
		Separator.init(request, response);
		switch (Separator.command.getAction()) {
		case "move":DispatcherServlet.send(request, response);break;
		case "mypage":
			String[] birth=service.getBirth(service.getSession().getPatJumin());
			System.out.println("생년월일:"+birth[1]);
			request.setAttribute("age",birth[0]);
			request.setAttribute("birth",birth[1]);
			DispatcherServlet.send(request, response);
			break;
		case "login":
			String pw=request.getParameter("password");
			bean.setPatID(request.getParameter("id"));
			try {
				bean=service.login(bean);
				if(!bean.getPatID().equals("FAIL")&&bean.getPatPass().equals(pw)){
					session.setAttribute("user",bean);
					DispatcherServlet.send(request, response);
				}else{
					Separator.command.setPage("loginForm");
					Separator.command.setView();
					DispatcherServlet.send(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		case "register":
			String id=request.getParameter("id");
			String password=request.getParameter("password");
			String year=request.getParameter("year");
			String month=request.getParameter("month");
			String date=request.getParameter("date");
			String telecom=request.getParameter("telecom");
			String firstNum=request.getParameter("firstNum");
			String middleNum=request.getParameter("middleNum");
			String lastNum=request.getParameter("lastNum");
			String rdBtn=request.getParameter("rdBtn");
			String[] ckbox=(String[])request.getParameterMap().get("ckbox");
			ArrayList<String> list=new ArrayList<>();
			list.add(id);
			list.add(password);
			list.add(year);
			list.add(month);
			list.add(date);
			list.add(telecom);
			list.add(firstNum);
			list.add(middleNum);
			list.add(lastNum);
			list.add(rdBtn);
			String ckbox2="";
			for(String s:ckbox){
				ckbox2+=s+",";
			}
			list.add(ckbox2);
			System.out.println(list);
			//DispatcherServlet.send(request, response);
			break;
		default:break;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}