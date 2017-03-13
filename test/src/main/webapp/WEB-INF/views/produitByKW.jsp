<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste Produit KW</title>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/w3.css" />"></link>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/CommerceStyle.css" />"></link>

</head>
<body>

	<ul>
		<li><a href="${pageContext.request.contextPath}/magasin/accueilClient">Accueil</a></li>
		<li><a href="${pageContext.request.contextPath}/magasin/listeCategories">Liste des Catégories</a></li>
		<li><a class="active" href="${pageContext.request.contextPath}/magasin/affichFormKW">Trouver un Produit</a></li>
		<li><a href="${pageContext.request.contextPath}/magasin/afficherPanier">Accéder au Panier</a></li>
	</ul>

	<div class="divCorps" style="width: 400px; border: solid gray 1px">
		<div class="w3-container" style="background-color: rgb(230, 230, 0); font-family: Times">
			<h1 style="font-family: Times, serif">Produits par mot clé</h1>
		</div>

		<form:form method="POST" action="soumettreFormKW" commandName="prodKW"
			cssClass="w3-container">
			<p>
				<label>Mot Clé :</label>
			</p>
			<p>
				<form:input path="designation" cssClass="w3-input" />
			</p>
			<p>
				<input class="button buttonSh" type="submit" value="Rechercher" />
			</p>
		</form:form>

	</div>
</body>
</html>