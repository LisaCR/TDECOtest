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
	<h1 align="center">liste Produit</h1>
<%-- 	<a href="${pageContext.request.contextPath}/produit/affichFormAjout">ajouter</a> --%>
<%-- 	<a href="${pageContext.request.contextPath}/produit/affichFormSupp">supprimer</a> --%>
<!-- 	<a href="">getById</a>
	<a href="">ajouter</a> -->

	<table align="center" cellspacing="0" cellpadding="6" border="1" width="60%">
		<tr bgcolor="grey" style="color:white">
			<th>ID</th>
			<th>Description</th>
			<th>Désignation</th>
			<th>Prix</th>
			<th>Quantité</th>
 			<th>Catégorie id</th> 
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
				<%-- <td><a href="soumettreFormSuppr/${produit.id}">Supprimer</a> | <a href="affichFormmodif?id_param=${produit.id}">Editer</a> </td> --%>
			</tr>

		</c:forEach>




	</table>
</body>
</html>