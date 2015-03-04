<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>

<head>
    <meta content="text/html" charset="utf-8" http-equiv="content-type" />
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</head>

<body>


<h1>Author list page :</h1>
<p>Authors count : <c:out value="${authorsCount}" /></p>


<form:form action="/author/add" modelAttribute="author">

    <form:label path="name"><spring:message text="Name"/></form:label>
    <form:input path="name" />

    <br/>

    <form:label path="country"><spring:message text="Country"/></form:label>
    <form:input path="country" />

    <br/>

    <form:label path="dateOfBirth"><spring:message text="Birth date"/></form:label>
    <form:input path="dateOfBirth" placeholder="yyyy-MM-dd"/>

    <br/>

    <input type="submit" value="<spring:message text="Add author"/>" />


</form:form>

<c:if test="${not empty authors}">

    <table class="table-bordered">
        <thead>
            <tr>
                <th>id</th>
                <th>Name</th>
                <th>Country</th>
                <th>Date of Birth</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="author" items="${authors}">
                <tr>
                    <td>${author.id}</td>
                    <td>${author.name}</td>
                    <td>${author.country}</td>
                    <td>${author.dateOfBirth}</td>
                    <td>
                        <span><a href="/author/remove/${author.id}">delete</a></span>
                        <span><a href="/author/edit/${author.id}">edit</a></span>
                        <span><a href="/author/view/${author.id}">view</a></span>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>




</c:if>

</body>
</html>