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
   <li><a href="<c:url value="/departaments"/>">Список отделов</a></li>
  <li><a href="<c:url value="/changedep"/>">Редактировать отдел</a></li>
  <li><a href="<c:url value="/web/AddDep.jsp"/>">Новый отдел</a></li>
  <li><a href="<c:url value="/web/DelDep.jsp"/>">Удалить отдел</a></li>
 </ul> 
</nav>
<div class="maincontent">
<h1>Просмотр данных по отделам на предприятиии</h1>

    <form  action="<c:url value="/departaments"/>"method="post">
      <select name="iddep"><option></option><c:forEach var="item" items="${departaments}">
        <option>${item.getIdDep()}</option></c:forEach></select>
      <select name="namedep"><option></option><c:forEach var="item" items="${departaments}">
        <option>${item.getNameDep()}</option></c:forEach></select>
        <input name="rad" type="radio" value="equally" checked>
        <label for="rad">Равно</label>
       <input name="rad" type="radio" value="more">
         <label for="rad">Больше</label>
         <input name="rad" type="radio" value="less">
        <label for="rad">Меньше</label>
        <input type="reset" name="clear" value="Очистить форму">
      <input type="submit" name="enter" value="Вывод по параметрам">
      
    </form>
<c:if test="${not empty depout}">
<div>
<table >
<caption><b><i>Список отделов на предприятии</i></b></caption>
<thead>
<tr>
<th>id отдела</th>
<th>Название отдела</th>
</tr>
</thead>
<tbody>
<c:forEach var="item" items="${depout}" >
<tr>
<td>${item.getIdDep()}</td>
<td>${item.getNameDep()}</td>
</tr>
</c:forEach>
</tbody>
</table></div></c:if>
</div>
</body>
</html>