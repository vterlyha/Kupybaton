<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<jsp:include page="pageContext.jsp"/>

<html>
<head>
<link rel="stylesheet" href="/Kupybaton/style/Style.css">
</head>
    <div class="container">
        <h1 class="aligh-center">
            List of products
        </h1>

        <c:if test="${not empty warningMessage}">
            <p class="alert-danger">${warningMessage}</p>
        </c:if>

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
                <c:forEach items="${activeLists}" var="purchase">
                    <tr>
                        <td class="first">${purchase.name}</td>
                        <td class="second">${purchase.dateCreated}</td>
                        <td class="third aligh-center">
                            <a href="${app}/purchases.html?listId=${purchase.id}">
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
    </div>
</body>
</html>
