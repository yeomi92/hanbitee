package util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Command;

public class DispatcherServlet {
	public static void send(HttpServletRequest request, HttpServletResponse response, Command command) throws ServletException, IOException{
		request.getRequestDispatcher(command.getView()).forward(request, response);
	}
}
