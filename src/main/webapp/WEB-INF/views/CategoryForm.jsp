<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="pl">

<%@ include file="header.jsp" %>

<form method="post" action="/category/add">
    Enter your name : <input type="text" name="name"><br>
    <input type="submit">
</form>

</body>
</html>