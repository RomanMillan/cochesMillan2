package com.jacaranda;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Servlet implementation class CreateElement
 */
@WebServlet("/CreateElement")
public class CreateElement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateElement() {
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
		
		//cogemos los datos
		String nameElement = request.getParameter("nameElement");
		String description = request.getParameter("description");;
		int priceElement = Integer.parseInt(request.getParameter("priceElement"));
		String trademarks = request.getParameter("trademarks");
		
		List<Category> listCategory = CategoryControl.getCategory();
		Category c= null;
		Iterator <Category> pointer = listCategory.iterator();
		Category aux = null;
		boolean found = false;
		while(pointer.hasNext()&&!found) {
			aux = pointer.next();
			if(aux.getName().equals(trademarks)) {
				found = true;
				c = aux;
			}
		}
		
		
		//Insertamos los datos
		Element e = new Element(nameElement, description, priceElement, c);
		
		ElementControl.addElement(e);
		
		
		PrintWriter out = response.getWriter();
		out.println("<html><body><head>"
				+ "<link rel=\"stylesheet\" href=\"css/Main.css\" type=\"text/css\">"
				+ "</head>");
		out.println("<h1>¡Modelo añadido!</h1>");
		out.println("<a href='html/CreateElement.html'>Atras</a>");
		out.println("</body></html>");
		
	}

}
