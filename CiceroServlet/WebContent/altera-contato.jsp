<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cicero"%>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" href="css/jquery-ui.css" rel="stylesheet"></link>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>

<style type="text/css">
html, body {
	margin: 0;
	padding: 0;
	height: 100%;
}

#container {
	min-height: 100%;
	position: relative;
}

#header {
	/*background: #ff0;*/
	padding: 10px;
}

#body {
	padding: 10px;
	padding-bottom: 60px; /* Height of the footer */
}

#footer {
	position: absolute;
	bottom: 0;
	width: 100%;
	height: 60px; /* Height of the footer */
	/*background: #6cf;*/
}
</style>

</head>

<body>
	<div id="container">

		<c:import url="cabecalho.jsp" />

		<div id="body">

			<form action="mvc" method="post">

				<input type="hidden" name="logica" value="AlteraContatoLogica">
				<input type="hidden" name="id" value="1">

				<table>
					<tr>
						<td>Nome:</td>
						<td><input type="text" name="nome" /></td>
					</tr>
					<tr>
						<td>Email:</td>
						<td><input type="text" name="email" /></td>
					</tr>
					<tr>
						<td>Endereço:</td>
						<td><input type="text" name="endereco" /></td>
					</tr>
					<tr>
						<td>Data de Nascimento:</td>
						<td><cicero:campoData id="dataNascimento" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="Gravar" /></td>
					</tr>
				</table>
			</form>
		</div>

		<c:import url="rodape.jsp" />
	</div>
</body>
</html>