package com.jacaranda;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;

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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//cogemos los datos
		String nick = request.getParameter("user");
		String password = DigestUtils.md2Hex(request.getParameter("password"));
		
		
		if(UserControl.isValidUser(nick,password)) {
			if(!UserControl.isAdministrator(nick,password)) {
				HttpSession sesion = request.getSession();
				sesion.setAttribute("login","true");
				sesion.setAttribute("user",nick);
				
				out.println("<html>"
						+ "<head>"
						+ "<link rel=\"stylesheet\" href=\"css/Main.css\" type=\"text/css\">"
						+ "</head>"
						+ "<body>");
				out.println("<header class='title'><h1>Bienvenido " + nick+"</h1>");
				out.println("<h2>Lista de coches</h2>"
						+ "<a href='/cochesMillan2/html/Index.html'>Atras</a>"
						+ "</header>");
				out.println("<table border='1px' align='center'>"
						+ "<thead>"
						+ "<tr>"
						+ "<td>Modelo</td><td>Descripción</td><td>Precio</td>"
						+ "</tr>"
						+ "</thead>");
	
				List<Element> el = ElementControl.getAllElements();
				for(Element i: el) {
					out.println("<tr><td>"+ i.getName()+"</td>");
					out.println("<td>"+ i.getDescription()+"</td>");
					out.println("<td>"+ i.getPrice()+" e</td></tr>");
				}
				
				
				out.println("</table>");
				out.println("</body></html>");
			}else {
				response.sendRedirect("html/CreateElement.html");			}
		}else {
			response.sendRedirect("html/ErrorUser.html");	
		}
		
	}

}
