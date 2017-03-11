<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	 <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1
		style="background-color: lightgreen; color: darkgreen; text-align: center;">
		${nomApp}</h1>

	<h1
		style="background-color: lightblue; color: darkgreen; text-align: center; font-size: 16pt">
	  ${salutation}	
	</h1>
	
	<spring:url value="/produit/listeProduit" var="produitUrl" />
<button class="btn btn-danger" onclick="location.href='${produitUrl}'">Gestion des produits</button>
<spring:url value="/categorie/listeCategorie" var="categorieUrl" />
<button class="btn btn-danger" onclick="location.href='${categorieUrl}'">Gestion des catégories</button>
	
</body>
</html>