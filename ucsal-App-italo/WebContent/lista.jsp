<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Lista</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body>
	<div class="container-fluid">
		<table>
			<tr>
				<th>Nome</th>
				<th>Email</th>
			</tr>
			<c:forEach var="c" items="${lista}">
				<tr>
					<td>${c.nome}</td>
					<td>${c.email}</td>
				</tr>
			</c:forEach>

		</table>
		<a class="btn btn-primary mb-2" href="form.jsp">Inserir</a>
	</div>

</body>
</html>