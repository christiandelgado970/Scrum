<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">

	<div class="panel panel-primary">
		<div class="panel-heading">Página principal</div>
		<div class="panel-body">
			Bienvenido ${user.nombre}! <a href="/list-todos?username=${user.nombre}">Pulsa aquí</a> para
			gestionar tus tareas.
		</div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>