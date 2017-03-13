<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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
<%-- 		<li><a class="active" href="${pageContext.request.contextPath}/admin/accueilGeneral">Accueil général</a></li> --%>
		<li><a href="${pageContext.request.contextPath}/admin/listeAdmin">Gestion des administrateurs</a></li>
		<li><a href="${pageContext.request.contextPath}/produit/listeProduit">Gestion des produits</a></li>
		<li><a href="${pageContext.request.contextPath}/categorie/listeCategorie">Gestion des catégories</a></li>
	</ul>
	<h1 align="center">liste Produit</h1>

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
			<th>Désignation</th>
			<th>Prix</th>
			<th>Quantité</th>
 			<th>Catégorie id</th> 
 			<th>Action</th> 
<!-- 			<th>Supp/Edit</th> -->
		</tr>
		<c:forEach var="produit" items="${produitListe}">
			<tr bgcolor="lightyellow">
				<td>${produit.idProduit}</td>
				<td>${produit.description}</td>
				<td>${produit.designation}</td>
				<td>${produit.prix}</td>
				<td>${produit.quantite}</td>
 				<td>${produit.categorie}</td>


		<td>
				  <spring:url value="/produit/${produit.idProduit}" var="produitUrl" />
				  <spring:url value="/produit/${produit.idProduit}/delete" var="deleteUrl" />
<%-- 				  <spring:url value="/produit/${produit.idProduit}/update" var="updateUrl" /> --%>

<%-- 				  <button class="btn btn-info" onclick="location.href='${produitUrl}'">Query</button>
				  <button class="btn btn-primary" onclick="location.href='${updateUrl}'">Update</button> --%>
				  <button class="btn btn-danger" onclick="location.href='${deleteUrl}'">Delete</button>
                  </td>
                  <tr>
              
		</c:forEach>

	</table>
	
	<spring:url value="/produit/${produit.idProduit}/affichFormAjout" var="addUrl" />
<button class="btn btn-danger" onclick="location.href='${addUrl}'">Add</button>
                                          
</body>
</html>