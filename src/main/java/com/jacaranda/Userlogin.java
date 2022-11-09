package com.jacaranda;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Userlogin
 */
@WebServlet("/Userlogin")
public class Userlogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Userlogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		response.setContentType("text/html");
		
		//cogemos los datos
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		
		
		
		if(UserControl.validUser(password)) {
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<h1>Estas dentro</h1>");
			out.println("<a href='/cochesMillan2/html/Index.html'>Atras</a>");
			out.println("</body></html>");
		}else {
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<h1>No se encuentra el usuario</h1>");
			out.println("<a href='/cochesMillan2/html/Index.html'>Atras</a>");
			out.println("</body></html>");
		}
		
	}

}
