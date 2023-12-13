<%@ include file="common/header.jspf"%>
<h2>Registro</h2>
<form action="/registro" method="post">
	<label for="username">Nombre:</label> <input type="text"
		id="username" name="username" required> <br> <label
		for="password">Contraseña:</label> <input type="password" id="password"
		name="password" required> <br>
	<button type="submit">Registrarse</button>
</form>
<form action="/conexion" method="get">
    <button type="submit">Volver</button>
</form>
<%@ include file="common/footer.jspf"%>