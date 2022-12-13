<%@page import="com.jacaranda.Cart"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.HashSet" %>
<%@page import= "java.util.Set" %>
<%@page import="com.jacaranda.Element"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Insert title here</title>
		<link rel='stylesheet' href='../css/Main.css' type='text/css'>
	</head>
	<body>
		<table align='center'>
			<thead>
				<tr>
					<td>Modelo</td>
					<td>Descripción</td>
					<td>Precio</td>
					<td>Cantidad</td> 
				</tr>
			</thead>
			<%  
			HttpSession sesion = request.getSession();
			Cart cart = (Cart) sesion.getAttribute("cart");
			
			Set<Element> listElement = cart.getMyCart();
			/* List<Element> el = ElementControl.getAllElements(); */
			
			for(Element i: listElement) {
			%>
				<tr>
					<td><%=i.getName()%></td>
					<td><%=i.getDescription()%></td>
					<td><%=i.getPrice()%></td>
				</tr>
			<%
			}
			%>
		</table>
	</body>
</html>