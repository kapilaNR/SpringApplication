<%--
  Created by IntelliJ IDEA.
  User: kapila
  Date: 9/10/15
  Time: 9:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search and Delete</title>
</head>
<body>
<a href="helloWorld"><button type="button">Home</button></a>
<a href="searchUser"><button type="button">search User</button></a>
<a href="viewUsers"><button type="button">view all Users</button></a>
<a href="deleteUser"><button type="button">delete User</button></a>
</body>
<table>
  <c:forEach items="${list}" var="user">
    <tr>
      <td>${user.userId}</td>
      <td>${user.firstName}</td>
      <td>${user.middleName}</td>
      <td>${user.age}</td>
    </tr>
  </c:forEach>

</table>

</body>
</html>
