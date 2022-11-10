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
				
				out.println("<html><body>");
				out.println("<h1>Bienvenido " + nick+"</h1>");
				out.println("<h2>Lista de coches</h2>");
				out.println("<table border='1px'><tr><td>Modelo</td><td>Descripción</td><td>Precio</td></tr>");
	
				List<Element> el = ElementControl.getAllElements();
				for(Element i: el) {
					out.println("<tr><td>"+ i.getName()+"</td>");
					out.println("<td>"+ i.getDescription()+"</td>");
					out.println("<td>"+ i.getPrice()+" e</td></tr>");
				}
				
				
				out.println("</table>");
				out.println("<a href='/cochesMillan2/html/Index.html'>Atras</a>");
				out.println("</body></html>");
			}else {
//				out.println("<html><body><h1>Agregar coche</h1>");
//				out.println("<form action=\"CreateElement\" method=\"post\">\r\n"
//						+ "        <table>\r\n"
//						+ "            <tr>\r\n"
//						+ "                <td>\r\n"
//						+ "                    <label for=\"\">nombre</label> <br>\r\n"
//						+ "                    <input type=\"text\" name=\"nameElement\">\r\n"
//						+ "                </td>\r\n"
//						+ "            </tr>\r\n"
//						+ "            <tr>\r\n"
//						+ "                <td>\r\n"
//						+ "                    <label for=\"\">descripción</label><br>\r\n"
//						+ "                    <textarea name=\"description\" cols=\"50\" rows=\"4\" max=\"10\"></textarea>\r\n"
//						+ "                </td>\r\n"
//						+ "            </tr>\r\n"
//						+ "            <tr>\r\n"
//						+ "                <td>\r\n"
//						+ "                    <label for=\"\">Precio</label><br>\r\n"
//						+ "                    <input type=\"number\" name=\"priceElement\">\r\n"
//						+ "                </td>\r\n"
//						+ "            </tr>\r\n"
//						+ "            <tr>\r\n"
//						+ "                <td>\r\n"
//						+ "                    <label for=\"\">marca</label><br>\r\n"
//						+ "                    <input type=\"text\" name=\"trademarks\">\r\n"
//						+ "                </td>\r\n"
//						+ "            </tr>\r\n"
//						+ "            <tr>\r\n"
//						+ "                <td>\r\n"
//						+ "                    <input type=\"button\" name=\"button\" value=\"enviar\">\r\n"
//						+ "                </td>\r\n"
//						+ "            </tr>\r\n"
//						+ "        </table>\r\n"
//						+ "    </form>");
//				out.println("</body></html>");
				RequestDispatcher rd;
				rd = request.getRequestDispatcher("/html/CreateElement.html");
				rd.forward(request, response);
			}
		}else {
//			out.println("<html><body>");
//			out.println("<h1>No se encuentra el usuario</h1>");
//			out.println("<a href='Index.html'>Atras</a>");
//			out.println("</body></html>");
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("/html/ErrorUser.html");
			rd.forward(request, response);
		}
		
	}

}
