package com.cg.labproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/Servlet1")
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//LocalDate date= LocalDate.now();
		response.setContentType("text/html");
		//response.sendRedirect("Home.html");
		PrintWriter printWriter=response.getWriter();
		String username = request.getParameter("uname");
		String password = request.getParameter("pass");
		HttpSession session=request.getSession();
		
		session.setAttribute("name",username);
		
		if(username.equals("kathir")&&password.equals("kathir123"))
		{
		//printWriter.println("<h1> date"+date+"</h1>");
			//request.getRequestDispatcher("servlet2").include(request, response);
			response.sendRedirect("servlet2");
		}
		else
		{
			printWriter.println("Wrong username/password");
			request.getRequestDispatcher("Home.html").include(request, response);
		}
		printWriter.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
