<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1 align="center">liste Admin</h1>
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
		<c:forEach var="admin" items="${adminListe}">
			<tr bgcolor="lightyellow">
				<td>${admin.idAdmin}</td>
				<td>${admin.nomAdmin}</td>
				<td>${admin.passwordAdmin}</td>
				<%-- <td><a href="soumettreFormSuppr/${admin.id}">Supprimer</a> | <a href="affichFormmodif?id_param=${admin.id}">Editer</a> </td> --%>
		

				<td>
				  <spring:url value="/admin/${admin.id}" var="userUrl" />
				  <spring:url value="/admin/${admin.id}/delete" var="deleteUrl" />
				  <spring:url value="/admin/${admin.id}/update" var="updateUrl" />

				  <button class="btn btn-info"
                                          onclick="location.href='${userUrl}'">Query</button>
				  <button class="btn btn-primary"
                                          onclick="location.href='${updateUrl}'">Update</button>
				  <button class="btn btn-danger"
                                          onclick="this.disabled=true;post('${deleteUrl}')">Delete</button>
                  </td>
		</tr>
		</c:forEach>

	</table>
</body>
</html>