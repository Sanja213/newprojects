<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "education.worker.ListWorkers" %>
<%@ page import = "education.worker.Worker" %>
<%@ page import = "education.departament.ListDepartament" %>
<%@ page import = "education.departament.Departament" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Отдел кадров:отделы</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
<h1>Список отделов</h1>

<div>
<table >
<caption><b><i>Список отделов</i></b></caption>
<thead>
<tr>
<th>№ Отдела</th>
<th>Название отдела</th>
<th>Руководитель</th>
</tr>
</thead>
<tbody>
<c:forEach var="item" items="${ListDepartament.dep}" >
<tr>
<td>${item.getId()}</td>
<td>${item.getName()}</td>
<td>${item.getManager()}</td>
</tr>
</c:forEach>
</tbody>

</table></div>
<form action="<c:url value="/departaments"/>"method="post">
<div>
<table>
<caption><b><i>Параметры выборки по отделам</i></b></caption>
<thead>
<tr>
<th>№ Отдела</th>
<th>Название отдела</th>
<th>Руководитель</th>
</tr>
<tr>
<td><input name="number"></td>
<td><input name="name"></td>
<td><input name="manager"></td>
</tr>
<tr>
<td><input type="submit" name="changedep" value="Добавить/Удалить отдел"></td>
<td><input type="submit" name="changeman" value="Сменить руководителя"></td>
<td><input type="submit" name="workers" value="Рабочие отдела"></td>
</tr>
</thead>
</table></div></form>

<table >
<caption><b><i>Рабочие по выбранным параметрам</i></b></caption>
<thead>
<tr>
<th>№ рабочего</th>
<th>Имя</th>
<th>Отчество</th>
<th>Фамилия</th>
<th>Дата рождения</th>
<th>Должность</th>
<th>№ отдела</th><br>
</tr>
</thead>
<tbody>
<c:forEach var="item" items="${form}" >
<tr>
<td>${item.getId()}</td>
<td>${item.getName()}</td>
<td>${item.getPatronomicName()}</td>
<td>${item.getLastName()}</td>
<td>${item.getBirthDay()}</td>
<td>${item.getPosition()}</td>
<td>${item.getDepartamentId()}</td>
</tr>
</c:forEach>
</tbody>
</table></div>





<a href="${pageContext.request.contextPath}/index.jsp"> На главную страницу</a>
</body>
</html>