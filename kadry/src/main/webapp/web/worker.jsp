<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import = "education.worker.ListWorkers" %>
<%@ page import = "education.worker.Worker" %>
<%@ page import = "education.worker.ListPosition" %>
<%@ page import = "education.departament.ListDepartament" %>
<%@ page import = "education.departament.Departament" %>
<%@ page import = "java.text.SimpleDateFormat" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Отдел кадров:рабочие</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
<form action="<c:url value="/workers"/>"method="post">
<div>
<table>
<caption><b><i>Параметры выборки по рабочим</i></b></caption>
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
<tr>
<td><input name="number" type="number"></td>
<td><input name="name"></td>
<td><input name="patronomic"></td>
<td><input name="lastname"></td>
<td><input name="dateofbirth" type="date"></td>
<td><select name="position"><c:forEach var="item" items="${ListPosition.positions}">
<option>${item}</option></c:forEach></select></td>
<td><select name="departament"><c:forEach var="item" items="${ListDepartament.dep}">
<option>${item.getName()}</option></c:forEach></select></td>
</tr>
<tr>
<td><input type="submit" name="addworker" value="Добавить рабочего"></td>
<td><input type="submit" name="delworker" value="Удалить рабочего"></td>
<td><input type="submit" name="chengedepartament" value="Сменить отдел"></td>
<td><input type="submit" name="chengeposition" value="Сменить должность"></td>
</tr>
</thead>
</table></div></form>
<h1>Списочный состав рабочих</h1>
<table >
<caption><b><i>Список рабочих</i></b></caption>
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
<c:forEach var="item" items="${ListWorkers.workers}" >
<tr>
<td>${item.getId()}</td>
<td>${item.getName()}</td>
<td>${item.getPatronomicName()}</td>
<td>${item.getLastName()}</td>
<td>${item.getBirth()}</td>
<td>${item.getPosition()}</td>
<td>${item.getDepartamentId()}</td>
</tr>
</c:forEach>
</tbody>
</table></div>
<a href="${pageContext.request.contextPath}/index.jsp">На главную страницу</a>
</body>
</html>