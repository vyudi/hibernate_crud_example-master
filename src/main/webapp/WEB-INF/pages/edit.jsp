<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>

<head>
    <meta content="text/html" charset="utf-8" http-equiv="content-type" />
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
</head>

<body>

<h3>Edit author</h3>

<c:url var="addAction" value="/author/add" ></c:url>

<form:form action="${addAction}" commandName="author">

    <c:if test="${!empty author.name}">
        <form:label path="id"><spring:message text="ID"/></form:label>
        <form:input path="id" readonly="true" size="8"  disabled="true" />
        <form:hidden path="id" />
    </c:if>
    <br/>

    <form:label path="name"><spring:message text="Name"/></form:label>
    <form:input path="name" />

    <br/>

    <form:label path="country"><spring:message text="Country"/></form:label>
    <form:input path="country" />

    <br/>

    <form:label path="dateOfBirth"><spring:message text="Birth date"/></form:label>
    <form:input path="dateOfBirth" class="java.util.Date" />

    <br/>

    <c:if test="${!empty author.name}">
        <input type="submit" value="<spring:message text="Edit author"/>" />
    </c:if>

    <c:if test="${empty author.name}">
        <input type="submit"
               value="<spring:message text="Add author"/>" />
    </c:if>

            
        
    
</form:form>

</body>
</html>