<html>
<head>
<meta charset="UTF-8">
<link type="text/css" href="css/jquery-ui.css" rel="stylesheet"></link>
<script type="text/javascript" src="js/jquery.js"></script>
<script type="text/javascript" src="js/jquery-ui.js"></script>

<script type="text/javascript">
	$(function() {
	    $( "#dataNascimento" ).datepicker();
	  });
</script>

</head>

<body>

	<form action="AdicionaContato">
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
				<td>Data Nascimento:</td>
				<td><input type="text" name="dataNascimento" id="dataNascimento" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Gravar" /></td>
			</tr>
		</table>
	</form>

</body>
</html>