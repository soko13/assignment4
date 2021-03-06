package net.assignment.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import net.assignment.database.*;

public class FillDatabaseServlet extends HttpServlet{
	
	FillDatabaseDAO fillDatabaseDAO = new FillDatabaseDAO();
	
	public void init() {
		fillDatabaseDAO = new FillDatabaseDAO();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		try {
			if (fillDatabaseDAO.fillDatabase()) {
				response.sendRedirect("updatesuccess.jsp");
			} else {
			response.sendRedirect("updatefail.jsp");			
		} 
			}
		catch (ClassNotFoundException e) {
			e.printStackTrace(); }
	}
}

