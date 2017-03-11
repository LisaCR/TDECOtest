<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Liste Produit KW</title>
</head>
<body>
	<h1>Produits par mot clé</h1>

	<form:form method="POST" action="soumettreFormKW" commandName="prodKW">
		<table>

			<tr>
				<td>Mot Clé :</td>
				<td><form:input path="designation" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Rechercher" /></td>
			</tr>

		</table>
	</form:form>


</body>
</html>