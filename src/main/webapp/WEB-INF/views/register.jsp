<%--
  Created by IntelliJ IDEA.
  User: ishari
  Date: 23.03.18
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <%@include file="jspf/head.jspf"%>
    <title>Home</title>
</head>
<body>
<%@include file="jspf/header.jspf"%>

<%--@elvariable id="user" type="pl.coderslab.warsztat6krk2.entity.User"--%>
<form:form modelAttribute="user" method="post">
    <div>
        <form:label path="username">Pseudonim</form:label>
        <form:input path="username"/>
        <form:errors path="username"/>
    </div>
    <div>
        <form:label path="password">Hasło</form:label>
        <form:password path="password"/>
        <form:errors path="password"/>
    </div>
    <div>
        <form:label path="email">Email</form:label>
        <form:input type="email" path="email"/>
        <form:errors path="email"/>
    </div>
    <div>
        <input type="submit" class=""/>
    </div>
</form:form>

<%@include file="jspf/footer.jspf"%>
</body>
</html>
