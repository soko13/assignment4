package net.assignment.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import net.assignment.bean.*;
import net.assignment.database.*;

public class UnsafeLoginServlet extends HttpServlet {
	
	private UnsafeLoginDAO unsafeLoginDAO; 
	
	public void init() {
		unsafeLoginDAO = new UnsafeLoginDAO();
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			LoginBean loginBean = new LoginBean();
			loginBean.setUsername(username);
			loginBean.setPassword(password);
		
		try {
			if(UnsafeLoginDAO.validate(loginBean)) {
				// HttpSession session = request.getSession();
				// session.setAttribute("user", username);
				response.sendRedirect("loginsuccess.jsp");
		} 	else {
				// HttpSession session = request.getSession();
				//session.setAttribute("user", username);
				response.sendRedirect("loginfail.jsp");
			
			}
		} 	catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
	}
}