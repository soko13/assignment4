package net.assignment.web;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import net.assignment.database.SafeLoginDAO;

// Extend HttpServlet class to create Http Servlet
//@WebServlet("/safeLogin")

public class SafeLoginServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		response.setContentType("text/html"); 
		PrintWriter out = response.getWriter();
		
		String username = request.getParameter("uname");
		String password = request.getParameter("psw");
		
		if(SafeLoginDAO.validate(username, password)) {
			RequestDispatcher rd = request.getRequestDispatcher("servlet2");
			rd.forward(request,response);
		}
		
		else {
			out.print("Please check your credentials");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.include(request,response);
		}
		
		out.close();
	}
	
	/*public void doGet(HttpServletRequest request, 
      HttpServletResponse response)
      throws ServletException, IOException 
   {

      // Setting up the content type of webpage
      response.setContentType("text/html");

      // Writing message to the web page
      PrintWriter out = response.getWriter();
      out.println("<html></html>");
   } */
}