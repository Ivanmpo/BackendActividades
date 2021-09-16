<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Usuarios</title>
</head>
<body>


	<form:form action="/usuario/crear" method="POST" modelAttribute="usuario">
		<form:label path="rut">Rut:</form:label>
		<input type="text" id="rut" name="rut"/>
		<br>
		
		<form:label path="nombre">Nombre:</form:label>
		<input type="text" id="nombre" name="nombre"/>

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
		<input type="submit" value="Crear Usuario">
	</form:form>
	
	
	<h1>Lista Usuarios</h1>
	<table>
		<thead>
			<tr>
				<th>#</th>
				<th>Rut</th>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Edad</th>
				<th>Email</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listaUsuarios}" var="usuario">
				<tr>
					<td> <c:out value="${usuario.id}"/> </td>
					<td> <c:out value="${usuario.rut}"></c:out> </td>
					<td> <c:out value="${usuario.nombre}"></c:out> </td>
					<td> <c:out value="${usuario.apellido}"></c:out> </td>
					<td> <c:out value="${usuario.edad}"></c:out> </td>
					<td> <c:out value="${empleado.email}"></c:out> </td>
					<!-- 
					<td> 
						<form action="/empleado/eliminar/${empleado.id}" method="POST">
							<input type="hidden" name="_method" value="DELETE">
							<input type="submit" value="Eliminar" >
						</form>
					</td>
					 -->
					 <td> 
					 	<a href="/usuario/actualizar/${usuario.id}">Editar</a>
						<form action="/usuario/eliminar" method="POST">
							<input type="hidden" name="id" value="<c:out value="${usuario.id}" />">
							<input type="submit" value="Eliminar" >
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>