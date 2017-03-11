<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste des Categories</title>
</head>
<body>
	<h1>Liste des Catégories</h1>

	<table>
		<tr>
			<th>ID</th>
			<th>Catégorie</th>
			<th>Déscription</th>
			<th></th>
		</tr>
		<c:forEach var="cat" items="${catListe}">
			<tr>
				<td>${cat.idCategorie}</td>
				<td>${cat.nomCategorie}</td>
				<td>${cat.description}</td>
				<td><a href="afficheProduitFromCategorie/${cat.idCategorie}">Afficher
						les produits</a></td>
			</tr>

		</c:forEach>




	</table>

</body>
</html>