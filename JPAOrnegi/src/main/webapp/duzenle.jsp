<%@page import="entity.Personel"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9"
	pageEncoding="ISO-8859-9"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-9">
<title>Personel G�ncelleme</title>
</head>
<body>
	<%
	Personel personel = (Personel) request.getAttribute("personel");
	%>
	<form action="/JPAOrnegi/duzenle" method="post">
		<input name="id" value="<%=personel.getId()%>" type="hidden"/>
		<table>
			<tr>
				<td>Personel Ad�:</td>
				<td><input name="adi" value="<%=personel.getAdi()%>" /></td>
			</tr>
			<tr>
				<td>Personel Soyad�:</td>
				<td><input name="soyadi" value="<%=personel.getLastName()%>" /></td>
			</tr>
		</table>
		<input type="submit" value="G�ncelle" />
	</form>
</body>
</html>