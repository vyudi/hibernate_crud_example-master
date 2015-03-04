<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
    <meta content="text/html" charset="utf-8" http-equiv="content-type" />
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
</head>

<body>

<h3>Author page</h3>
<div> name : <c:out value="${author.name}" /> </div>
<div> country : <c:out value="${author.country}" /> </div>
<div> birth date <c:out value="${author.dateOfBirth}" /> </div>

<c:if test="${not empty author.books}">
    <div class="author_books">
        <c:forEach var="book" items="${author.books}">
            <div class="author_book">
                <div>${book.id}</div>
                <div>${book.title}</div>
                <div>${book.description}</div>
                <div>${book.releaseDate}</div>
            </div>
        </c:forEach>
    </div>
</c:if>
<div><a href="/author/edit/<c:out value="${author.id}"/>">Edit</a> </div>

</body>
</html>