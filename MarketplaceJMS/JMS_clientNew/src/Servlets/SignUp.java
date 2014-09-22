package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import setupClasses.*;
import modelclasses.*;
//import modelclasses.*;

/**
 * Servlet implementation class SignUp
 */
//@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JMSSetup proxy=new JMSSetup();       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
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
		Catalog[] catalogs;
		User u;
		response.setContentType("text/html");
		String qdone;		 
		 try{			
			 	String user = request.getParameter("user");
			 	String pass = request.getParameter("pass");
			 	//jms//proxy.setEndpoint("http://localhost:8080/SimpleMarketPlace/services/Service");
				u = proxy.login(user,pass);
				System.out.println("Got user");
				HttpSession session = request.getSession();
				if(u.getUserid() != null){
				/*if(true){*/
				System.out.println("userid" + u.getUserid());
				session.setAttribute("userid", u.getUserid());
					
					System.out.println("username: " + u.getUsername());
					session.setAttribute("username", u.getUsername());
					session.setAttribute("lastlogin", u.getLastlogin());
					catalogs = proxy.fetchcatlogs();
					for (int i=0;i<catalogs.length;i++)
					{
						System.out.println(catalogs[i].getCatid());
						System.out.println(catalogs[i].getCatname());
					}
					request.setAttribute("cataloglist", catalogs);
					session.setAttribute("cataloglist", catalogs);//jms//*/
					System.out.println("Going to index.jsp");
					System.out.println(request.getAttribute("cataloglist"));
					request.getRequestDispatcher("index.jsp").forward(request, response);
					System.out.println("WELCOME to Simple Market Place :"+ user);//Displaying the message on the servlet itself.
					//out.println("\n <a href=\"SignUp.jsp\"><br>Go back to Login again</a>");
				}
				else{
					out.println("nodata");
					out.println("\n <a href=\"SignUp.jsp\"><br>Go back to Login again</a>");
				}
		 }
		 catch (Exception e)
	     {
	            e.printStackTrace();
	     }
	}

}
