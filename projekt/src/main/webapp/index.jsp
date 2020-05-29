<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Kadry</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="web/Style.css">

</head>
<body>
<form action="<c:url value="/index.jsp"/>"method="post">
<input type="submit" name="enter" value="Войти">
</form>
<form action="<c:url value="/index.jsp"/>"method="post">
<input type="submit" name="register" value="Зарегистрироваться">
</form>
<form action="<c:url value="/web/main.jsp"/>" method="post">
<input type="submit" name="start" value="Начать работу">
</form>
</body>
</html>