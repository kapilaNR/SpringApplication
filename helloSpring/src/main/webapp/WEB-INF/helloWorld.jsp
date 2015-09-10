<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<body>
<h2>Registration Form!</h2>
<form:form commandName="userBean" modelAttribute="userBean" method="post">
  <table>
    <tr>
      <td><label >first Name </label></td>
      <td><form:input path="firstName" placeholder="first Name"/></td>
      <td><form:errors path="firstName" cssClass="error"></form:errors></td>
    </tr>

    <tr>
    <td><label >Second name</label></td>
    <td><form:input path="middleName" placeholder="middl eName"/></td>
      <td><form:errors path="middleName" cssClass="error"></form:errors></td>
    </tr>

    <tr>
    <td><label >Age</label></td>
      <td><form:input path="age" placeholder="age"/></td>
      <td><form:errors path="age" cssClass="error"></form:errors></td>
    </tr>
    <tr>
    <td><input type="submit" value="Submit"></td>
    </tr>

  </table>
</form:form>
<a href="helloWorld"><button type="button">Home</button></a>
<a href="searchUser"><button type="button">search User</button></a>
<a href="viewUsers"><button type="button">view all Users</button></a>
<a href="deleteUser"><button type="button">delete User</button></a>
</body>
</body>
</html>
