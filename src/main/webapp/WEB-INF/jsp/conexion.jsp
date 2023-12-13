<%@ include file="common/header.jspf"%>
<h2>Conexión</h2>
<form action="/conexion" method="post">
	<label for="username">Nombre:</label> <input type="text"
		id="username" name="username" required> <br> <label
		for="password">Contraseña:</label> <input type="password" id="password"
		name="password" required> <br>
	<button type="submit">Conectarse</button>
</form>
<form action="/registro" method="get">
    <button type="submit">Registrarse</button>
</form>
<%@ include file="common/footer.jspf"%>