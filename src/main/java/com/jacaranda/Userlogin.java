package com.jacaranda;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    }

    //METODO DOGET
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// Comprobar que no estoy recibiendo ningun paraématro
		// -sui no tengo pararmeto llamo a dopost y si tengo error
	
		doPost(req,resp);
			
			
			
	}

	String nick;
	String password;
	//METODO DOPOST
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession sesion = request.getSession();

//		if(sesion.getAttribute("login")==null && !request.getParameter("user").equals(nick)) {
		if(sesion.getAttribute(nick) == null) {
			nick = request.getParameter("user");
			password = DigestUtils.md2Hex(request.getParameter("password"));
		}
			if(UserControl.isValidUser(nick,password)) {
				if(!UserControl.isAdministrator(nick,password)) {
					sesion.setAttribute("login","true");
					sesion.setAttribute("user",nick);
					
					out.println("<html>"
							+ "<head>"
							+ "<link rel='stylesheet' href='css/Main.css' type='text/css'>"
							+ "</head>"
							+ "<body>");
					out.println("<header class='title'><h1>Bienvenido " + nick+"</h1>");
					out.println("<h2>Lista de coches</h2>"
							+ "<a href='/cochesMillan2/html/Index.html'>Atras</a> <input type='submit' value='cerrar sesión'>"
							+ "</header>");
					out.println("<table border='1px' align='center'>"
							+ "<thead>"
							+ "<tr>"
							+ "<td>Modelo</td><td>Descripción</td><td>Precio</td><td>Cantidad</td> <td>Añadir</td>"
							+ "</tr>"
							+ "</thead>");
		
					List<Element> el = ElementControl.getAllElements();
					for(Element i: el) {
						out.println("<tr><td>"+ i.getName()+"</td>");
						out.println("<td>"+ i.getDescription()+"</td>");
						out.println("<td>"+ i.getPrice()+" e</td>");
						out.println("<form action='CartQuery' method='post'>");
						out.println("<td hidden='true'><input name='idE' value='"+i.getId()+"'></td>");
						out.println("<td><input type='number' name='quE'></td>");
						out.println("<td><button type='submit'>Añadir</button></td></form></tr>");
					}
					
					out.println("</table>");
					out.println("</body></html>");
				}else {
					response.sendRedirect("html/CreateElement.html");			
				}
			}else {
				response.sendRedirect("html/ErrorUser.html");	
			}

	}

}
