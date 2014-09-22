package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import setupClasses.*;


/**
 * Servlet implementation class InsertProducts
 */
//@WebServlet("/InsertProducts")
public class InsertProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JMSSetup proxy = new JMSSetup();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertProducts() {
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
		System.out.println("Inside dopost of insert catalog");
		response.setContentType("text/html");
		String qdone ="";		 
		 try{			
			 	String catId = request.getParameter("productCatlog");
			 	String Proname = request.getParameter("proname");
			 	String Prodesc = request.getParameter("prodesc");
			 	String Prorate = request.getParameter("proprice");
			 	String Proqty = request.getParameter("proqty");
			 	String uid = request.getSession().getAttribute("userid").toString();
			 	//jms//proxy.setEndpoint("http://localhost:8080/SimpleMarketPlace/services/Service");
				qdone = proxy.insertproduct(uid,catId, Proname, Prodesc, Prorate, Proqty);
				HttpSession session = request.getSession();
				if(qdone.substring(0, 4).equals("true")){
					session.setAttribute("userSession", session);
					out.println(Proname + ": Product inserted successfully");//Displaying the message on the servlet itself.
					out.println("\n <a href=\"InsertProduct.jsp\"><br>Go back to Insert Product again</a>");
				}
				else{
					out.println("Some error occured during insertion : Product might already exist");
					out.println("\n <a href=\"InsertProduct.jsp\"><br>Go back to Insert Product again</a>");
				}
		 }
		 catch (Exception e)
	     {
	            e.printStackTrace();
	     }

	}

}
