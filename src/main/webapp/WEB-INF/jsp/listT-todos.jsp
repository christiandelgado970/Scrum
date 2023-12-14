<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">
	<div>
	    <a type="button" class="btn btn-primary btn-md" href="/filtrar-todo?username=${user.nombre}">Filtrar/a>
	    <a type="button" class="btn btn-primary btn-md" href="/ordenar-todo?username=${user.nombre}">Ordenar de otra forma</a>
		<a type="button" class="btn btn-primary btn-md" href="/list-todos?username=${user.nombre}">Volver</a>
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
						<th width="20%%">Nombre</th>
						<th width="20%%">Prioridad</th>
						<th width="20%">Duracion</th>
						<th width="20%%">Estado</th>
						<th width="20%%">Descripcion</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${todos}" var="todo">
					<c:if test="${todo.estado == 'Archivada'}">
						 <tr>
							<c:choose>
									<c:when test="${user.admin == true}">
										<td>${todo.nombre} - ${todo.usuario}</td>
									</c:when>
									<c:otherwise>
										<td>${todo.nombre}</td>
									</c:otherwise>
								</c:choose>
							<td>${todo.prioridad}</td>
							<td>${todo.intduracion} ${todo.tipoduracion}</td>
							<td>${todo.estado}</td>
							<td>${todo.descripcion}</td>
						</tr>
				      </c:if>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

</div>
<%@ include file="common/footer.jspf"%>