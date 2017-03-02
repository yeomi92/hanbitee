package controller;

import java.io.IOException;
import java.sql.SQLException;
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
import util.ParamMap;
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
			String docId=request.getParameter("doctor");
			String nurId=request.getParameter("nurse");
			String name=request.getParameter("name");
			String email=request.getParameter("email");
			String addr=request.getParameter("addr");
			String password=request.getParameter("password");
			String year=request.getParameter("year");
			String month=request.getParameter("month");
			String date=request.getParameter("date");
			String telecom=request.getParameter("telecom");
			String phoneNo1=request.getParameter("phoneNo1");
			String phoneNo2=request.getParameter("phoneNo2");
			String phoneNo3=request.getParameter("phoneNo3");
			String gender=request.getParameter("gender");
			String job=ParamMap.getValues(request, "job");
			ArrayList<String> list=new ArrayList<>();
			list.add(id);
			list.add(docId);
			list.add(nurId);
			list.add(name);
			list.add(email);
			list.add(addr);
			list.add(password);
			list.add(year);
			list.add(month);
			list.add(date);
			list.add(telecom);
			list.add(phoneNo1);
			list.add(phoneNo2);
			list.add(phoneNo3);
			list.add(gender);
			list.add(job);
			System.out.println(list);
			String temp=(gender.equals("male"))?"1":"2";
			month=(month.length()==1)?"0"+month:month;
			date=(date.length()==1)?"0"+date:date;
			String patJumin=year.substring(2,4)+month+date+"-"+temp;
			bean.setPatID(id);
			bean.setDocID(docId);
			bean.setNurID(nurId);
			bean.setPatAddr(addr);
			bean.setPatEmail(email);
			bean.setPatGen(gender);
			bean.setPatJob(job);
			bean.setPatJumin(patJumin);
			bean.setPatName(name);
			bean.setPatPass(password);
			bean.setPatPhone(phoneNo1+"-"+phoneNo2+"-"+phoneNo3);
			try {
				if(service.join(bean)==1){
					System.out.println("회원가입 성공");
					DispatcherServlet.send(request, response);
				}else{
					System.out.println("회원가입 실패");
					Separator.command.setPage("registerForm");
					Separator.command.setView();
					DispatcherServlet.send(request, response);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			break;
		default:break;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}