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
   <li><a href="<c:url value="/worker"/>">Список сотрудников</a></li>
  <li><a href="<c:url value="/changeworker"/>">Редактировать сотрудника</a></li>
  <li><a href="<c:url value="/addworker"/>">Новый сотрудник</a></li>
  <li><a href="<c:url value="/delworker"/>">Удалить сотрудника</a></li>
 </ul> 
 </nav>
 <div class="maincontent">
<h1>Добавление новых сотрудников на предприятии</h1>

    <form action="<c:url value="/addworker"/>"method="post">
      <label for="name">Имя сотрудника</label>
      <input name="name"><br>
      <label for="lastname">Фамилия сотрудника</label>
      <input name="lastname"><br>
      <label for="dateofbirth">Дата рождения</label>
      <input name="dateofbirth" type="date"><br>
      <label for="namepos">Название должности</label>
      <select name="namepos"><option></option><c:forEach var="item" items="${positions}">
        <option>${item.getName()}</option></c:forEach></select><br>
      
      <label for="depname">Название отдела</label>
       <select name="depname"><option></option><c:forEach var="item" items="${departaments}">
        <option>${item.getNameDep()}</option></c:forEach></select><br>
      <input type="reset" name="clear" value="Очистить форму">
      <input type="submit" name="enter" value="Добавить">
      
    </form>
    
    
<c:if test="${not empty outwork}">
<div>
<table >
<caption><b><i>Вы добавили нового сотрудника на предприятие</i></b></caption>
<thead>
<tr>
<th>id сотрудника</th>
<th>Имя</th>
<th>Фамилия</th>
<th>Дата Рождения</th>
<th>Должность</th>
<th>Отдел</th>
</tr>
</thead>
<tbody><c:forEach items="${outwork}" var = "w">
<tr>
<td>${w.getId()}</td>
<td>${w.getName()}</td>
<td>${w.getLastName()}</td>
<td>${w.getBirth()}</td>
<td>${w.getPosition().getName()}</td>
<td>${w.getDepartament().getNameDep()}</td>
</tr>
</c:forEach>
</tbody>
</table></div></c:if>
</div>
</body>
</html>