<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<div>
		<a type="button" class="btn btn-primary btn-md" href="/add-todo">Añadir</a>
	    <a type="button" class="btn btn-primary btn-md" href="/filtrar-todo">Filtrar/a>
	    <a type="button" class="btn btn-primary btn-md" href="/ordenar-todo">Ordenar</a>
		<a type="button" class="btn btn-primary btn-md" href="/terminadadas-todo">Terminadas</a>
	</div>
	<br>
	<div class="panel panel-primary">
		<div class="panel-heading">
			<h3>Lista de tareas</h3>
		</div>
		<div class="panel-body">
			<table class="table table-striped">
				<thead>
					<tr>
						<th width="12.5%">Nombre</th>
						<th width="12.5%">Prioridad</th>
						<th width="12.5%">Duracion</th>
						<th width="12.5%">Estado</th>
						<th width="12.5%">Descripcion</th>
						<th width="12.5%"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${todos}" var="todo">
						<tr>
							<td>${todo.nombre}</td>
							<td>${todo.prioridad}</td>
							<td>${todo.intduracion} ${todo.tipoduracion}</td>
							<td>${todo.estado}</td>
							<td>${todo.descripcion}</td>
							<td><a type="button" class="btn btn-success"
								href="/update-todo?id=${todo.id}">Editar</a> <a type="button"
								class="btn btn-warning" href="/delete-todo?id=${todo.id}">Terminar</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>
<%@ include file="common/footer.jspf"%>