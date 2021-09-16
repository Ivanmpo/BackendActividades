<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Productos</title>
</head>
<body>


	<form:form action="/producto/crear" method="POST" modelAttribute="producto">

		
		<form:label path="nombre">Nombre:</form:label>
		<form:input type="text" id="nombre" path="nombre"/>

		<br>
		<form:label path="codigo">Código</form:label>
		<form:input type="text"
			id="codigo" path="codigo"/>
		<br>
		<form:label  path="valor">Valor</form:label >
		<form:input type="text" id="valor"
			path="valor" />
		<br>
		<br>
		<hr>
		<input type="submit" value="Crear Producto">
	</form:form>
	
	
	<h1>Lista Productos</h1>
	<table>
		<thead>
			<tr>
				<th>#</th>
				<th>Nombre</th>
				<th>Código</th>
				<th>Valor</th>
				<th>Acción</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${listaProductos}" var="producto">
				<tr>
					<td> <c:out value="${producto.id}"/> </td>
					<td> <c:out value="${producto.nombre}"></c:out> </td>
					<td> <c:out value="${producto.codigo}"></c:out> </td>
					<td> <c:out value="${producto.valor}"></c:out> </td>
					<!-- 
					<td> 
						<form action="/empleado/eliminar/${empleado.id}" method="POST">
							<input type="hidden" name="_method" value="DELETE">
							<input type="submit" value="Eliminar" >
						</form>
					</td>
					 -->
					 <td> 
					 	<a href="/producto/actualizar/${producto.id}">Editar</a>
						<form action="/producto/eliminar" method="POST">
							<input type="hidden" name="id" value="<c:out value="${producto.id}" />">
							<input type="submit" value="Eliminar" >
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>