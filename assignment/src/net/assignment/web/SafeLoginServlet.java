package net.assignment.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import net.assignment.bean.*;
import net.assignment.database.*;

public class SafeLoginServlet extends HttpServlet {
	
	private SafeLoginDAO safeLoginDAO; 
	
	public void init() {
		safeLoginDAO = new SafeLoginDAO();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		LoginBean loginBean = new LoginBean();
		loginBean.setUsername(username);
		loginBean.setPassword(password);
	
	try {
		if(SafeLoginDAO.validate(loginBean)) {
			response.sendRedirect("loginsuccess.jsp");
	} 	else {
			response.sendRedirect("loginfail.jsp");
		
		}
	} 	catch (ClassNotFoundException e) {
			e.printStackTrace();
	}
}
}