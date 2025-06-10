<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 2025-06-09
  Time: 오전 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
    <title><spring:message code="login.title" /></title>
</head>
<body>
<p>
    <spring:message code="login.done" />
</p>
<p>
    <a href="<c:url value='/main'/>">
        [<spring:message code="go.main" />]
    </a>
</p>
</body>
</html>