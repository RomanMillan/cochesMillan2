<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/Index.css" type="text/css">
</head>
<body>
<%session.invalidate(); %>
<div align="center">
			<form class="form" action="../Userlogin" method="post">
				<table>				
					<tr>
						<td align="center" colspan="2">
							<h1 class="title">ComproCoches.com</h1>
						</td>
						</tr>
					<tr>
						<td align="center" colspan="2">
							<h2 class="subtitle">Entrar</h2>
						</td>
					</tr>
					<tr>
						<td> 
							<input type="text" required name="user" min="1" max="100" placeholder="Nombre">
							<br> <br>
							<input required type="password" min="1" name="password" placeholder="Constraseña">
						<br> <br>
						</td>
					</tr>
					<tr align="center">
						<td colspan="2"> 
							<input class="submit2" type="submit" name="Login" value="Entrar"> 				
						</td>
					</tr>
					</table>
				</form>
				<hr>
			<table>
				<tr>
					<td align="center" colspan="2">
						<form class="form" action="CreateUser.html">
							<h2 class="subtitle">Crear Cuenta</h2>
							<input class="submit2" type="submit" value="Crear">
						</form>
					</td>
				</tr>
			</table>
		</div>
</body>
</html>