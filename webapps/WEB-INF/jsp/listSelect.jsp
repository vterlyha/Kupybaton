<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<jsp:include page="pageContext.jsp"/>

<html>
<head>
    <link rel="stylesheet" href="${app}/style/style.css">
    <script type="application/javascript" src="${app}/js/listOverview.js"></script>
</head>

<body>
    <div class="container">
        <h1 class="aligh-center">
            Lists of products
        </h1>

        <c:if test="${not empty warningMessage}">
            <p class="alert-danger">${warningMessage}</p>
        </c:if>

        <button class="button button-center" id="addNewList">New list</button>

        <table class="table">
            <thead>
            <tr>
                <th>Name</th>
                <th>Create date</th>
                <th>Edit List</th>
                <th>Delete list</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${activeLists}" var="list">
                <tr>
                    <td class="first">${list.name}</td>
                    <td class="second">${list.dateCreated}</td>
                    <td class="third aligh-center">
                        <a href="${app}/purchases.html?productlistId=${list.id}">
                            <img class="fit-image" src="${app}/images/edit_list.ico">
                        </a>
                    </td>
                    <td class="fourth aligh-center">
                        <a>
                            <img class="fit-image" src="${app}/images/delete_list.png">
                        </a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>

        <%--<c:if test="${show}"--%>
            <%--<c:if test="${not empty}"--%>
            <%--<p class="alert alert-info"></p>--%>
    </div>
</body>
</html>
