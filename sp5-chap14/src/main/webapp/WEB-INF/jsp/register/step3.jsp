<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: AnTaeHyun
  Date: 2025-06-06
  Time: 오후 3:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
    <p><strong>${registerRequest.name}님</strong>회원 가입 완료</p>
    <p><a href="<c:url value='/main'/>">[첫 화면 이동]</a> </p>
</body>
</html>
