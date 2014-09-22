package Servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jms.JMSException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import setupClasses.*;
/**
 * Servlet implementation class procedetoorder
 */
//@WebServlet("/procedetoorder")
public class procedetoorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	JMSSetup proxy = new JMSSetup();      
    /**
     * @see HttpServlet#HttpServlet()
     */
    public procedetoorder() {
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
		System.out.println("doPost procedeorder");
		PrintWriter out = response.getWriter();
		System.out.println("User Id : " + request.getSession().getAttribute("userid"));
		String uid = request.getSession().getAttribute("userid").toString();
		String qdone = "";
		 try {
			qdone = proxy.generateOrder(uid);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(qdone.substring(0,4).equals("true")){
			
			System.out.println("Going to orderdetails.jsp");
			
			response.sendRedirect("/JMS_clientNew/View/orderdetails");
		}
		else{
			out.println("Something went wrong");
			out.println("\n <a href=\"index.jsp\"><br>Go back to Home</a>");
		}
		
		
	}

}
