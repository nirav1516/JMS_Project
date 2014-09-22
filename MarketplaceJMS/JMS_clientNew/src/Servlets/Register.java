package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import setupClasses.*;

/**
 * Servlet implementation class Register
 */
//@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String qdone = "" ; //jms//proxy=new String qdone =();    
    JMSSetup proxy = new JMSSetup();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String qdone = "";		 
		 try{			
			 	String fname = request.getParameter("firstname");
			 	String lname = request.getParameter("lastname");
			 	String Email = request.getParameter("EmailId");
			 	String pass = request.getParameter("password");
			 //jms//	proxy.setEndpoint("http://localhost:8080/SimpleMarketPlace/services/Service");
				qdone = proxy.register(fname, lname, Email, pass);
				HttpSession session = request.getSession();
				if(qdone.substring(0,4).equals("true")){
					session.setAttribute("userSession", session);
					out.println("WELCOME to Simple Market Place :"+ fname);//Displaying the message on the servlet itself.
					out.println("\n <a href=\"Register.jsp\"><br>Go back to Registration again</a>");
				}
				else{
					out.println("<h4>User with "+ Email + " already exists</h4>");
					out.println("\n <a href=\"Register.jsp\"><br>Go back to Registration again</a>");
				}
		 }
		 catch (Exception e)
	     {
	            e.printStackTrace();
	     }
	}

}
