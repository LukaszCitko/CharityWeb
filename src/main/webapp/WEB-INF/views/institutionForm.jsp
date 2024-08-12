<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="pl">

<%--<%@ include file="header.jsp" %>--%>
<body>
<br>


    <form:form action="/institution/add" method="post" modelAttribute="donation" >


        <div> <form:label path = "categories">  </form:label></div>
<%--        <input type="hidden" id="name" name="name" value="${name}"/>--%>
        <div><td><form:checkboxes path="categories"  itemValue="id" itemLabel="name" items="${categories}" delimiter="<br>" /></td></div>

        <input type="submit">
    </form:form><br>


</body>
</html>