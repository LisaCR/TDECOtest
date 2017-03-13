<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/w3.css" />"></link>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/CommerceStyle.css" />"></link>
</head>
<body>

	<ul>
		<li><a class="active" href="${pageContext.request.contextPath}/admin/accueilAdmin">Accueil admin</a></li>
		<li><a class="active" href="${pageContext.request.contextPath}/admin/accueilGeneral">Accueil général</a></li>
		<li><a href="${pageContext.request.contextPath}/admin/listeAdmin">Gestion des administrateurs</a></li>
		<li><a href="${pageContext.request.contextPath}/produit/listeProduit">Gestion des produits</a></li>
		<li><a href="${pageContext.request.contextPath}/categorie/listeCategorie">Gestion des catégories</a></li>
	</ul>
	<h1 align="center">liste Admin</h1>


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
			</tr>

		</c:forEach>




	</table>
</body>
</html>