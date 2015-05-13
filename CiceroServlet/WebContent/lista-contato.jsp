<%@ page import="com.ciceroinfo.bo.Contato"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<meta charset="UTF-8">
<link type="text/css" href="css/jquery-ui.css" rel="stylesheet"></link>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>

<script type="text/javascript">
	$(function() {
		$("#dataNascimento").datepicker();
	});
</script>

</head>

<body>
	<c:import url="cabecalho.jsp" />
	<jsp:useBean id="dao" class="com.ciceroinfo.dao.ContatoDAO" />

	<form action="AdicionaContato">

		<table border="1" style="border-collapse: collapse">

			<tr>
				<th>ID</th>
				<th>Nome</th>
				<th>Email</th>
				<th>Endereço</th>
				<th>Data Nascimento</th>
			</tr>

			<c:forEach var="contato" items="${dao.list}" varStatus="id">

				<tr bgcolor="#${id.count % 2 == 0 ? 'F0F0F0' : 'FFFFFF'}">
					<td>${contato.id}</td>
					<td>${contato.nome}</td>
					<c:if test="${not empty contato.email}">
						<td><a href="mailto:${contato.email}">${contato.email}</a></td>
					</c:if>
					<td align="center">${contato.endereco }</td>
					<td><fmt:formatDate value="${contato.dataNascimento.time}"
							pattern="dd/MM/yyyy" /></td>
				</tr>

			</c:forEach>

		</table>
	</form>
	<c:import url="rodape.jsp" />
</body>
</html>