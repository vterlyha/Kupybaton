<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: mkhrun
  Date: 1/29/16
  Time: 11:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="pageContext.jsp"/>

<html>
<head>
    <title>purchases of selected list</title>
    <link rel="stylesheet" href="${app}/style/style.css">
</head>
<body>
    <div class="container">
        <h1 class="aligh-center">
            Purchase for list "${productList.name}" created on ${productList.dateCreated}
        </h1>

        <c:if test="${not empty warningMessage}">
            <p class="alert-danger">${warningMessage}</p>
        </c:if>

        <table class="table">
            <thead>
            <tr>
                <th>Name</th>
                <th>Unit</th>
                <th>Edit List</th>
                <th>Delete list</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${purchaseList}" var="purchase">
                <tr>
                    <td class="first">${purchase.product.name}</td>
                    <td class="second">${purchase.product.unit.name}</td>
                    <td class="third">${purchase.quantity}</td>
                    <td class="fourth aligh-center">
                        <input type="checkbox"
                               <c:if test="${purchase.flag}">checked</c:if>
                        >
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
