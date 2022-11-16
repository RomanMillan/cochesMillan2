package com.jacaranda;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Servlet implementation class UserCreate
 */
@WebServlet("/UserCreate")
public class UserCreate extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public UserCreate() {
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
		response.setContentType("text/html");
		
		//cogemos los datos
		String user = request.getParameter("user").trim();
		String password = DigestUtils.md2Hex(request.getParameter("password"));
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String gender = request.getParameter("gender");
		String birthday  = request.getParameter("birthday");
		boolean administrador = false;
		boolean genderB = true;
		if(gender.equals("Femenino")){
			genderB = false;
		}
		
		if(!user.isEmpty() || password.length() > 20) {
			if(UserControl.isValidUser(user, password)) {
				PrintWriter out = response.getWriter();
				out.println("<html><body>");
				out.println("<h1>El Usuario ya existe</h1>");
				out.println("<a href='html/Index.html'>Atras</a>");
				out.println("</body></html>");	
			}else {
				
				//Insertamos los datos
				//User u = new User(user,password,name,surname,genderB,birthday,administrador);
				User u = new User();
				
				u.setAdministrator(administrador);
				u.setGender(genderB);
				u.setName(name);
				u.setNick(user);
				u.setPassword(password);
				u.setSurname(surname);
				u.setBirthday(birthday);
				
				UserControl.addUser(u);
				
				PrintWriter out = response.getWriter();
				out.println("<html><body>");
				out.println("<h1>Usuario creado!</h1>");
				out.println("<a href='html/Index.html'>Atras</a>");
				out.println("</body></html>");	
			}
			
		}else {
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			out.println("<h1>Datos No validos</h1>");
			out.println("<a href='html/CreateUser.html'>Atras</a>");
			out.println("</body></html>");
		}
	
		
		
	}

}
