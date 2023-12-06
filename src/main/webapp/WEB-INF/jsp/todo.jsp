<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>
<div class="container">
	<div class="row">
		<div class="col-md-6 col-md-offset-3 ">
			<div class="panel panel-primary">
				<div class="panel-heading">Añadir tarea</div>
				<div class="panel-body">
					<form:form method="post" modelAttribute="todo">
						<form:hidden path="id" />
						
						<fieldset class="form-group">
							<form:label path="nombre">Nombre</form:label>
							<form:input path="nombre" type="text" class="form-control"
								required="required" />
							<form:errors path="nombre" cssClass="text-warning" />
						</fieldset>
						
						<fieldset class="form-group">
							<form:label path="descripcion">Description</form:label>
							<form:input path="descripcion" type="text" class="form-control"
								required="required" />
							<form:errors path="descripcion" cssClass="text-warning" />
						</fieldset>

						<fieldset class="form-group">
							<form:label path="Intduracion">Duracion</form:label>
							<form:input path="Intduracion" type="text" class="form-control"
								required="required" />
							<form:errors path="Intduracion" cssClass="text-warning" />
						</fieldset>

						
						<button type="submit" class="btn btn-success">Guardar</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>