<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">

    <title>Hello World!</title>
</head>
<body>
<h1>Hello User : ${auth_user}</h1>
<input type="hidden" th:name="_csrf" th:content="${_csrf.token}" />
<input type="hidden" th:name="_csrf_header" th:content="${_csrf.headerName}"/>
<a href="logout">Logout</a>
</body>
</html>