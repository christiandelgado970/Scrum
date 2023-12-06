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
							<form:label path="prioridad">Prioridad</form:label>
							<div class="input-group">
								<div class="input-group-append">
									<form:select path="prioridad" class="custom-select">
										<form:option value="1">1</form:option>
										<form:option value="2">2</form:option>
										<form:option value="3">3</form:option>
										<form:option value="4">4</form:option>
										<form:option value="5">5</form:option>
									</form:select>
								</div>
							</div>
							<form:errors path="prioridad" cssClass="text-warning" />
						</fieldset>

						<fieldset class="form-group">
							<form:label path="intduracion">Duracion</form:label>
							<form:input path="intduracion" type="text" class="form-control"
								required="required" />
							<form:errors path="intduracion" cssClass="text-warning" />
						</fieldset>

						<fieldset class="form-group">
							<form:label path="tipoduracion">Duracion(Unidad de tiempo)</form:label>
							<div class="input-group">
								<div class="input-group-append">
									<form:select path="tipoduracion" class="custom-select">
										<form:option value="Segundos">Segundos</form:option>
										<form:option value="Minutos">Minutos</form:option>
										<form:option value="Horas">Horas</form:option>
										<form:option value="Días">Días</form:option>
										<form:option value="Semanas">Semanas</form:option>
										<form:option value="Meses">Meses</form:option>
									</form:select>
								</div>
							</div>
							<form:errors path="tipoduracion" cssClass="text-warning" />
						</fieldset>


						<button type="submit" class="btn btn-success">Guardar</button>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="common/footer.jspf"%>