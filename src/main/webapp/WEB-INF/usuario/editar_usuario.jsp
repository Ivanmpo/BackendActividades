<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar Usuario</title>
</head>
<body>


	<form:form action="/usuario/modificar" method="POST" modelAttribute="usuario">
		<form:hidden path="id"/>
		<input type="hidden" name="_method" value="PUT">
		
		<form:label path="rut">Rut:</form:label>
		<form:input type="text" id="rut" path="rut"/>
		<br>
		
		<form:label path="nombre">Nombre:</form:label>
		<form:input type="text" id="nombre" path="nombre"/>

		<br>
		<form:label path="apellido">Apellido</form:label>
		<form:input type="text"
			id="apellido" path="apellido"/>
		<br>
		<form:label  path="edad">Edad</form:label >
		<form:input type="text" id="edad"
			path="edad" />
		<br>
		<form:label  path="email">Email</form:label>
		<form:input type="text"
			id="email" path="email"/>
		<br>
		<br>
		<hr>
		<input type="submit" value="Actualizar Usuario">
	</form:form>
</body>
</html>