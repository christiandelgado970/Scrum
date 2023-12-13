<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<div>
		<a type="button" class="btn btn-primary btn-md" href="/add-todo?username=${user.nombre}">Añadir</a>
		<a type="button" class="btn btn-primary btn-md" href="/filtrar-todo?username=${user.nombre}">Filtrar/a>
			<a type="button" class="btn btn-primary btn-md" href="/ordenar-todo?username=${user.nombre}">Ordenar
				de otra forma</a> <a type="button" class="btn btn-primary btn-md"
			href="/terminadas-todos?username=${user.nombre}">Archivadas</a>
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
						<th width="11.5%">Nombre</th>
						<th width="11.5%">Prioridad</th>
						<th width="11.5%">Duracion</th>
						<th width="11.5%">Estado</th>
						<th width="11.5%">Descripcion</th>
						<th width="17.5%"></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${todos}" var="todo">
						<c:if test="${todo.estado != 'Archivada'}">
							<tr
								style="${todo.estado == 'Completada' ? 'background-color: #c0c0c0;' : ''}">
								<c:choose>
									<c:when test="${user.admin == true}">
										<td>${todo.nombre}-${todo.usuario}</td>
									</c:when>
									<c:otherwise>
										<td>${todo.nombre}</td>
									</c:otherwise>
								</c:choose>
								<td>${todo.prioridad}</td>
								<td>${todo.intduracion} ${todo.tipoduracion}</td>
								<td>${todo.estado}</td>
								<td>${todo.descripcion}</td>
								<td><c:if test="${todo.estado != 'Completada'}">
										<a type="button" class="btn btn-success"
											href="/update-todo?id=${todo.id}&username=${user.nombre}">Editar</a>
										<a type="button" class="btn btn-warning"
											href="/terminar-todo?id=${todo.id}&username=${user.nombre}">Completar</a>
									</c:if> <a type="button" class="btn btn-warning"
									href="/archivar-todo?id=${todo.id}&username=${user.nombre}">Archivar</a></td>
							</tr>
						</c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>
<%@ include file="common/footer.jspf"%>