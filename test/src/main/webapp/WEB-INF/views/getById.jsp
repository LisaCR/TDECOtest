<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">Admin by Id</h1>
<%-- 	<a href="${pageContext.request.contextPath}/admin/affichFormAjout">ajouter</a> --%>
<%-- 	<a href="${pageContext.request.contextPath}/admin/affichFormSupp">supprimer</a> --%>
<!-- 	<a href="">getById</a>
	<a href="">ajouter</a> -->

	<table align="center" cellspacing="0" cellpadding="6" border="1" width="60%">
		<tr bgcolor="grey" style="color:white">
			<th>ID</th>
			<th>Nom</th>
			<th>Mail</th>
<!-- 			<th>Supp/Edit</th> -->
		</tr>
		<c:forEach var="admin" items="${admin}">
			<tr bgcolor="lightyellow">
				<td>${admin.idAdmin}</td>
				<td>${admin.nomAdmin}</td>
				<td>${admin.passwordAdmin}</td>
				<%-- <td><a href="soumettreFormSuppr/${admin.id}">Supprimer</a> | <a href="affichFormmodif?id_param=${admin.id}">Editer</a> </td> --%>
			</tr>

		</c:forEach>




	</table>
</body>
</html>