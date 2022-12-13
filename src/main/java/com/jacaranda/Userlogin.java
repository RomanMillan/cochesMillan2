package com.jacaranda;

import java.io.IOException;

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
			
//		resp.setContentType("text/html");
//		PrintWriter out = resp.getWriter();
//		out.print("hola");
		
			
	}

	//METODO DOPOST
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   
		
		/*
		 * Me puede llegar aqui, que venga porque ha introducido usuario y login
		 *       -> Si el usuario y el password es correcto
		 *       		->session.setAttrbitue("user",usuario);
		 *       		-> Que sea administrador
		 *       				-> Pongo una señal en la session diciendo administrador
		 *                            (session.setAttributle("administrado", True)
		 *       		-> Que sea normal
		 *          			-> Pongo una señal en la session diciendo NO administrador
		 *                            (session.setAttributle("administrado", false)
		 *       		-> Yo puedo mostrar la página, sólo que en la cabecera, miro si 
		 *       			es administrador pongo un botón, y si no lo es, no lo pongo.
		 *       -> Si el usuario y password no son correcto -> Error
		 * Me puede llegar aqui, porque ya esté logeado, con lo cual tiene session
		 * 		-> Recupero la sessión
		 * 			-> No está definido user -> Error
		 * 			-> Tengo el valor de user -> 
		 * 		        -> Yo puedo mostrar la página, sólo que en la cabecera, miro si 
		 *       			es administrador pongo un botón, y si no lo es, no lo pongo.
		 * Me puede llegar aquí, por otro movito  -> Error
		 * 
		 * 
		 */
			
		response.setContentType("text/html");
		HttpSession sesion = request.getSession();

		if(sesion.getAttribute("login")== null) {
			String nick = request.getParameter("user");
			String password = DigestUtils.md2Hex(request.getParameter("password"));
//			sesion.setAttribute("cart", "false");
			
			if(UserControl.isValidUser(nick,password)) {
				sesion.setAttribute("login","true");
				sesion.setAttribute("user",nick);
				Cart cart = new Cart(); 
				sesion.setAttribute("cart",cart);
				sesion.setAttribute("administrator", "false");
				if(UserControl.isAdministrator(nick,password)) {
					sesion.setAttribute("administrator", "true");
					response.sendRedirect("jsp/cars.jsp");
				}else {
					response.sendRedirect("jsp/cars.jsp");
				}
			}else {
				response.sendRedirect("html/ErrorUser.html");
			}
		}else {
			response.sendRedirect("jsp/cars.jsp");
		}
				
	}
	

}
