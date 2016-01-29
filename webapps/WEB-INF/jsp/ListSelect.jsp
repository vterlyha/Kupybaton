<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<jsp:include page="pageContext.jsp"/>

<html>
<head>
<<<<<<< HEAD
<link rel="stylesheet" href="/Kupybaton/style/Style.css">

</head>
<body>
	<h1>
		List of products
	</h1>
<ul>
<c:forEach items="${productlist}" var="list">
	<li>
		<a href="/Kupybaton/GetPurchaseProductsByListId.do?listId=${list.getId()}">${list.getName()}</a>
	</li>
	</c:forEach>
</ul>
		
	<form method="get" action="CreateNewList.do">
		<input type="SUBMIT" class="b1" value="Create new Productlist">
	</form>
	
=======
    <title>lists for buy</title>
    <link rel="stylesheet" href="${app}/style/style.css">
</head>
<body>
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
>>>>>>> mkhrun-master
</body>
</html>
