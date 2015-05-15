<%@ page import="com.ciceroinfo.bo.Contato"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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

<script type="text/javascript">
	$(function() {
		$("#dataNascimento").datepicker();
	});
</script>

</head>

<body>
	<div id="container">

		<c:import url="cabecalho.jsp" />


		<div id="body">

			<jsp:useBean id="dao" class="com.ciceroinfo.dao.ContatoDAO" />


			<form action="AdicionaContato">

				<table border="1" style="border-collapse: collapse">

					<tr>
						<th>ID</th>
						<th>Nome</th>
						<th>Email</th>
						<th>Endereço</th>
						<th>Data de Nascimento</th>
						<th>Ação</th>
					</tr>

					<c:forEach var="contato" items="${dao.list}" varStatus="id">

						<tr bgcolor="#${id.count % 2 == 0 ? 'F0F0F0' : 'FFFFFF'}">
							<td align="center">${contato.id}</td>
							<td align="left">${contato.nome}</td>
							<td align="left"><c:if test="${not empty contato.email}">
									<a href="mailto:${contato.email}">${contato.email}</a>
								</c:if></td>
							<td align="left">${contato.endereco }</td>
							<td align="center"><c:if
									test="${contato.dataNascimento ne null}">
									<fmt:formatDate value="${contato.dataNascimento.time}"
										pattern="dd/MM/yyyy" />
								</c:if></td>
							<td align="center">
								<a href="altera-contato.jsp">Alterar</a>&nbsp;&nbsp;
								<a href="lista-contato.jsp">Remover</a></td>
						</tr>

					</c:forEach>

				</table>
				<a href="adiciona-contato.jsp">Adicionar</a>
			</form>

		</div>

		<c:import url="rodape.jsp" />
	</div>
</body>
</html>