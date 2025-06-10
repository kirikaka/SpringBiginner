<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2025-06-09
  Time: 오전 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="login.title" /></title>
</head>
<body>
<form:form modelAttribute="loginCommand">
    <form:errors />
    <p>
        <label><spring:message code="email" />:<br>
            <form:input path="email" />
            <form:errors path="email"/>
        </label>
    </p>
    <p>
        <label><spring:message code="password" />:<br>
            <form:password path="password" />
            <form:errors path="password"/>
        </label>
    </p>
    <p>
        <label><spring:message code="rememberEmail" />:
            <form:checkbox path="rememberEmail"/>
        </label>
    </p>
    <input type="submit" value="<spring:message code="login.btn" />">
</form:form>
</body>
</html>