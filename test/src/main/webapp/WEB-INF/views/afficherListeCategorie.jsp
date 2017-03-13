<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>


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
<%-- 		<li><a class="active" href="${pageContext.request.contextPath}/admin/accueilGeneral">Accueil général</a></li>
 --%>		<li><a href="${pageContext.request.contextPath}/admin/listeAdmin">Gestion des administrateurs</a></li>
		<li><a href="${pageContext.request.contextPath}/produit/listeProduit">Gestion des produits</a></li>
		<li><a href="${pageContext.request.contextPath}/categorie/listeCategorie">Gestion des catégories</a></li>
	</ul>
	<h1 align="center">liste Categorie</h1>

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
			<th>Description</th>
			<th>Nom</th>
 			<th>Action</th> 
<!-- 			<th>Supp/Edit</th> -->
		</tr>
		<c:forEach var="categorie" items="${categorieListe}">
			<tr bgcolor="lightyellow">
				<td>${categorie.idCategorie}</td>
				<td>${categorie.description}</td>
				<td>${categorie.nomCategorie}</td>
		<td>
				  <spring:url value="/categorie/${categorie.idCategorie}" var="categorieUrl" />
				  <spring:url value="/categorie/${categorie.idCategorie}/delete" var="deleteUrl" />
<%-- 				  <spring:url value="/categorie/${categorie.idCategorie}/update" var="updateUrl" /> --%>

<%-- 				  <button class="btn btn-info" onclick="location.href='${categorieUrl}'">Query</button>
				  <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button> --%>
				  <button class="btn btn-danger" onclick="location.href='${deleteUrl}'">Delete</button>
                  </td>
                  <tr>
              
		</c:forEach>

	</table>
	
	<spring:url value="/categorie/${categorie.idCategorie}/affichFormAjout" var="addUrl" />
<button class="btn btn-danger" onclick="location.href='${addUrl}'">Add</button>
                                          
</body>
</html>