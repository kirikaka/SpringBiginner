<%--
  Created by IntelliJ IDEA.
  User: AnTaeHyun
  Date: 2025-06-06
  Time: 오후 3:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>회원 가입</title>
</head>
<body>
<h2>
    회원 정보 입력
</h2>
    <form:form action="step3" modelAttribute="registerRequest">
    <p>
        <label>
            Email
            <form:input path="email"/>
            <input type="text" name="email" id="email" value="${registerRequest.email}">
        </label>
    </p>
    <p>
        <label>
            Name
            <form:input path="name"/>
            <input type="text" name="name" id="name" value="${registerRequest.name}">
        </label>
    </p>
    <p>
        <label>
            Password
            <form:password path="password"/>
            <input type="password" name="password" id="password">
        </label>
    </p>
    <p>
        <label>
            Password Check
            <form:password path="confirmPassword"/>
            <input type="password" name="confirmPassword" id="confirmPassword">
        </label>
    </p>
    <input type="submit" value="가입 완료">
    </form:form>

</body>
</html>
