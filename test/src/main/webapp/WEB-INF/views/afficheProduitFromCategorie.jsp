<%@page import="fr.adaming.model.Produit"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Produits par Cat�gorie</title>
</head>
<body>

	<h1>Liste des Produits de la Cat�gorie :
		${selectedCat.nomCategorie}</h1>

	<table>

		<tr>
			<th>ID</th>
			<th>Produit</th>
			<th>D�scription</th>
			<th>Prix</th>
			<th></th>
		</tr>

		<c:forEach var="prod" items="${prodListe}">

			<tr>
				<td>${prod.idProduit}</td>
				<td>${prod.designation}</td>
				<td>${prod.description}</td>
				<td>${prod.prix}</td>
				<td><a href="${pageContext.request.contextPath}/magasin/ajouterPanier/${prod.idProduit}">Ajouter au
						panier</a></td>
			</tr>

		</c:forEach>

	</table>

</body>
</html>