<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/bootstrap.css"/>" />

<script type="text/javascript"
	src="<c:url value="/resources/js/bootstrap.js"/>"></script>
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
		<li><a class="active" href="${pageContext.request.contextPath}/admin/accueilGeneral">Accueil général</a></li>
		<li><a href="${pageContext.request.contextPath}/admin/listeAdmin">Gestion des administrateurs</a></li>
		<li><a href="${pageContext.request.contextPath}/produit/listeProduit">Gestion des produits</a></li>
		<li><a href="${pageContext.request.contextPath}/categorie/listeCategorie">Gestion des catégories</a></li>
	</ul>

	<h1>Formulaire ajout/Edit</h1>
	<form:form class="form-horizontal" method="post" modelAttribute="adminForm" action="${adminActionUrl}">
		<table>

<tr>
	<td>${adminForm.idAdmin}</td>
				<td><form:input path="idAdmin" type="hidden" /></td>

			</tr>
			<tr>
				<td><form:label path="nomAdmin">Nom: </form:label></td>
				<td><form:input path="nomAdmin" /></td>
				<td><form:errors path="nomAdmin" cssStyle="color:red"/></td>
			</tr>
			<tr>
				<td><form:label path="passwordAdmin">Password: </form:label></td>
				<td><form:input path="passwordAdmin" /></td>
				<td><form:errors path="passwordAdmin" cssStyle="color:red"/></td>
			</tr>


			<tr>
				<td><input type="submit" value="ajouter" /></td>
			</tr>


		</table>
	</form:form>
</body>
</html>