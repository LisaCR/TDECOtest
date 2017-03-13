<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Accueil</title>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/w3.css" />"></link>
<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/CommerceStyle.css" />"></link>

</head>
<body>

	<ul>
		<li><a class="active" href="${pageContext.request.contextPath}/magasin/accueilClient">Accueil</a></li>
		<li><a href="${pageContext.request.contextPath}/magasin/listeCategories">Liste des Catégories</a></li>
		<li><a href="${pageContext.request.contextPath}/magasin/affichFormKW">Trouver un Produit</a></li>
		<li><a href="${pageContext.request.contextPath}/magasin/afficherPanier">Accéder au Panier</a></li>
	</ul>

</body>
</html>