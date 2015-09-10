<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: kapila
  Date: 9/10/15
  Time: 11:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search User</title>
</head>
<body>
<form:form commandName="userBean" modelAttribute="userBean" method="post">
  <label >first Name </label></td>
  <form:input path="firstName" placeholder="first Name"/>
  <form:errors path="firstName" cssClass="error"></form:errors>
  <input type="submit" value="Submit">
</form:form>
<a href="helloWorld"><button type="button">Home</button></a>
<a href="searchUser"><button type="button">search User</button></a>
<a href="viewUsers"><button type="button">view all Users</button></a>
<a href="deleteUser"><button type="button">delete User</button></a>
</body>
</body>
</html>
