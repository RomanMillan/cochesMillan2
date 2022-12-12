<%@page import="java.awt.Button"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="com.jacaranda.ElementControl"%>
 <%@page import="com.jacaranda.Element"%>
 <%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<link rel='stylesheet' href='../css/Main.css' type='text/css'>
	</head>
	<body>
		<h1>Bienvenido <%=session.getAttribute("user")%></h1>
		<h2>Lista de coches</h2>
		<a href='/cochesMillan2/html/Index.jsp'>Atras</a> 
		<a href='/cochesMillan2/html/Index.jsp'>Cerrar Sesion</a>	
		<%
		if(session.getAttribute("administrator").equals("true")){
		%>
			<button><a href="CreateElement.html">Insertar Modelo</a></button>
		<%
		};
		%>
		<table align='center'>
			<thead>
				<tr>
					<td>Modelo</td>
					<td>Descripción</td>
					<td>Precio</td>
					<td>Cantidad</td> 
					<td>Añadir</td>
				</tr>
			</thead>
			<%  
			List<Element> el = ElementControl.getAllElements();
			for(Element i: el) {
			%>
				<tr>
					<td><%=i.getName()%></td>
					<td><%=i.getDescription()%></td>
					<td><%=i.getPrice()%></td>
					<form action='CartQuery' method='post'>
						<td hidden='true'>
							<input name='idE' value='<%=i.getId()%>'>
						</td>
						<td>
							<input type='number' name='quE'>
						</td>
						<td>
							<button type='submit'>Añadir</button>
						</td>
					</form>
				</tr>
			<%
			}
			%>
		</table>
	</body>
</html>