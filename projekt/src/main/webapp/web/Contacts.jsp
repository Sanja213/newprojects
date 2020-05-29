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
      <li><a href="<c:url value="/position"/>" >Должность </a>
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
<div class="maincontent">
<h1>Предприятие</h1>
<p>По всем вопросам обращайтесь на почту:</p>
<p>boicov_av@mail.ru</p>
</div> 
</body>
</html>