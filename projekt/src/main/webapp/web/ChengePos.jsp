<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>kadry</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="<c:url value="/web/Style.css"/>">
</head>
<header>
  <a href="<c:url value="/web/main.jsp"/>"  class="logo">Предприятие</a>
 <nav>
    <ul class="topmenu">
      <li><a href="<c:url value="/web/main.jsp"/>">Главная</a></li>
      <li><a href="<c:url value="/departaments"/>">Отделы</a>
        <ul class="submenu">
          <li><a href="<c:url value="/changedep"/>">Редактировать отдел</a></li>
  <li><a href="<c:url value="/web/AddDep.jsp"/>">Новый отдел</a></li>
  <li><a href="<c:url value="/web/DelDep.jsp"/>">Удалить отдел</a></li>
    </ul>
      </li>
       <li><a href="<c:url value="/worker"/>" >Сотрудники</a>
      <ul class="submenu">
     <li><a href="<c:url value="/changeworker"/>">Редактировать сотрудника</a></li>
  <li><a href="<c:url value="/addworker"/>">Новый сотрудник</a></li>
  <li><a href="<c:url value="/delworker"/>">Удалить сотрудника</a></li>
        </ul>
      </li>
      <li><a href="<c:url value="/position"/>" >Должность</a>
      <ul class="submenu">
          <li><a href="<c:url value="/changepos"/>">Редактировать должность</a></li>
  <li><a href="<c:url value="/web/AddPos.jsp"/>">Новая должность</a></li>
  <li><a href="<c:url value="/web/DelPos.jsp"/>">Удалить должность</a></li>
        </ul>
      </li>
      <li><a href="<c:url value="/web/Contacts.jsp"/>">Контакты</a></li>
     </ul>
  </nav>
</header>
<body>
<nav class="sidemenu">
 <ul>
   <li><a href="<c:url value="/position"/>">Список должностей</a></li>
  <li><a href="<c:url value="/changepos"/>">Редактировать должность</a></li>
  <li><a href="<c:url value="/web/AddPos.jsp"/>">Новая должность</a></li>
  <li><a href="<c:url value="/web/DelPos.jsp"/>">Удалить должность</a></li>
 </ul> 
 </nav>
 <div class="maincontent">
<h1>Изменение должностей на предприятии</h1>

    <form action="<c:url value="/changepos"/>"method="post">
     <label for="iddep">№ должности</label>
    <select name="iddep"><option></option><c:forEach var="item" items="${positions}">
        <option>${item.getId()}</option></c:forEach></select><br>
       <label for="namedep">Название должности</label>
      <input name="namedep"><br>
      <label for="tarif">Тарифная ставка</label>
      <input name="tarif" ><br>
      <input type="reset" name="clear" value="Очистить форму">
      <input type="submit" name="enter" value="Изменение по параметрам">
      
    </form>
<c:if test="${not empty changepos}">
<div>
<table >
<caption><b><i>Изменена должность на предприятии</i></b></caption>
<thead>
<tr>
<th>id должности</th>
<th>Название должности</th>
<th>Часовая ставка</th>
</tr>
</thead>
<tbody>
<c:forEach var="item" items="${changepos}" >
<tr>
<td>${item.getId()}</td>
<td>${item.getName()}</td>
<td>${item.getTarif()}</td>
</tr>
</c:forEach>
</tbody>
</table></div></c:if>
</div>
</body>
</html>