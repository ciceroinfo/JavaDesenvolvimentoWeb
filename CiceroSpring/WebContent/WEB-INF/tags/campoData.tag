<%@ attribute name="id" required="true" %>

<input id="${id}" name="${id}" type="text" />

<script type="text/javascript">
	$("#${id}").datepicker({dateFormat: 'dd/mm/yy'});
</script>