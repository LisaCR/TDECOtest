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


	<c:if test="${not empty msg}">
		    <div class="alert alert-${css} alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert"
                                aria-label="Close">
				<span aria-hidden="true">×</span>
			</button>
			<strong>${msg}</strong>
		    </div>
		</c:if>
		
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
		
		</tr>
		
			<td>
				  <spring:url value="/admin/${admin.idAdmin}" var="adminUrl" />
				  <spring:url value="/admin/${admin.idAdmin}/delete" var="deleteUrl" />
				  <spring:url value="/admin/${admin.idAdmin}/update" var="updateUrl" />

				  <button class="btn btn-info"
                                          onclick="location.href='${adminUrl}'">Query</button>
				  <button class="btn btn-primary"
                                          onclick="location.href='${updateUrl}'">Update</button>
				  <button class="btn btn-danger"
                                          onclick="location.href='${deleteUrl}'">Delete</button>
                  </td>
                  
		</c:forEach>

	</table>
</body>
</html>