<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<form action="InserirServlet" method="POST">
			<div class="form-group">
				<label>Nome</label> <input class="form-control" type="text"
					name="nome" />
			</div>
			<div class="form-group">
				<label>Email</label> <input class="form-control" type="email"
					name="email" />
			</div>
			<div class="form-group">
				<label>Endereco</label> <input class="form-control" type="text"
					name="endereco" />
			</div>
			<div class="form-group">
				<label>Data Nascimento</label> <input class="form-control"
					type="date" name="dataNascimento" />
			</div>
			<button type="submit" class="btn btn-primary mb-2">Inserir</button>
		</form>
	</div>


</body>
</html>