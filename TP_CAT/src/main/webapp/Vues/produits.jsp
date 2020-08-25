<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="controleur.php" method="post">
<table>
<tr><td>Designation</td><td><input type="text" name="designation"></td></tr>
<tr><td>Prix</td><td><input type="text" name="prix"></td></tr>
<tr><td>Quantite</td><td><input type="text" name="quantite"></td></tr>
<tr><td></td><td><input type="submit" name="action" value="Save"></td></tr>
</table>
</form>
<div><table><tr><th>IDProduit</th><th>Designation</th><th>Prix</th><th>Quantité</th></tr>
<c:forEach items="${produits}" var="p">
<tr>
<td>${p.idProduit}</td>
<td>${p.designation}</td>
<td>${p.prix}</td>
<td>${p.quantite}</td>
</tr>
</c:forEach>
</table></div>
</body>
</html>