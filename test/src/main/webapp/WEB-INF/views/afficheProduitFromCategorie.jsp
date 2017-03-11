<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Produits par Catégorie</title>
</head>
<body>

	<h1>Liste des Produits de la Catégorie :
		${selectedCat.nomCategorie}</h1>

	<form:form method="POST" action="soumettreFormAjout"
		commandName="employeForm">
		<table>

			<tr>
				<th>ID</th>
				<th>Produit</th>
				<th>Déscription</th>
				<th>Prix</th>
				<th></th>
			</tr>

			<c:forEach var="prod" items="${prodListe}">
				<tr>
					<td>${cat.idProduit}</td>
					<td>${cat.designation}</td>
					<td>${cat.description}</td>
					<td>${cat.prix}</td>
					<td><a href="ajouterPanier/${d}">Ajouter au panier</a></td>
				</tr>
			</c:forEach>

		</table>
	</form:form>
</body>
</html>