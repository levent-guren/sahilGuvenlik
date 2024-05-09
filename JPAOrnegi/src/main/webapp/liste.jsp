<%@page import="entity.Personel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-9" pageEncoding="ISO-8859-9"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-9">
<title>Personel Listesi</title>
</head>
<body>
<font color="red"><b>${mesaj}</b></font><br/>
Personeller:
<table border="1">
	<tr>
	   <th>Sicil</th>
	   <th>Adı</th>
	   <th>Soyadı</th>
	   <th>&nbsp;</th>
	</tr>
	<%
	List<Personel> liste = (List<Personel>) request.getAttribute("personeller");
	for(int i = 0; i< liste.size(); i++) { %>
	<tr>
	   <td><%= liste.get(i).getId() %></td>
	   <td><%= liste.get(i).getAdi() %></td>
	   <td><%= liste.get(i).getLastName() %></td>
	   <td><a href="/JPAOrnegi/duzenle?id=<%= liste.get(i).getId() %>">Düzenle</a></td>
	</tr>
	<% } %>
</table>
</body>
</html>