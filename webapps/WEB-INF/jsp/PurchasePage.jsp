<<<<<<< HEAD
<%@ page import="com.kupybaton.model.Product"%>
<%@ page import="java.util.List"%>
<%@ page import="com.kupybaton.model.ProductList"%>
=======
>>>>>>> 8df456e5d132335dfd9edce5c54280765d4351f1
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
<link rel="stylesheet" href="/Kupybaton/style/Style.css">
</head>
<body>
	<form method="post" action="AddFirstProduct.do">
<<<<<<< HEAD
	
	<h1 >
		<c:forEach items="${productlist}" var="list">
			<c:set var="listId" scope="request" value="${list.getId()}"/> 
			<c:out value="${list.getName()}" />
		</c:forEach>
	</h1>

	<select name="productName" id="mySelect">
		<c:forEach items="${products}" var="oneProduct">
			<option value="${oneProduct}" selected="selected">${oneProduct.getName()}</option>
			<c:set var="productId" scope="request" value="${doneProduct.getId()}"/>
		</c:forEach>
	</select>

	
	
	<input type="hidden" name="oneProductList" value="${listId}" />
	<input type="hidden" name="product" value="${x}" />
	<input type="SUBMIT" class="b2" value="Save">
=======
        <h1>
            <c:forEach items="${productlist}" var="list">
                <c:set var="listId" scope="request" value="${list.getId()}"/>
                <c:out value="${list.getName()}" />
            </c:forEach>
        </h1>

        <%--parameter "productName" will be sent to server.--%>
        <%--Now it contains product id, change to whatever you need--%>
        <select name="productName" id="mySelect">
            <c:forEach items="${products}" var="oneProduct">
                <option value="${oneProduct.id}">${oneProduct.name}</option>
            </c:forEach>
        </select>



        <input type="hidden" name="oneProductList" value="${listId}" />
        <input type="hidden" name="product" value="${x}" />
        <input type="SUBMIT" class="b2" value="Save">
>>>>>>> 8df456e5d132335dfd9edce5c54280765d4351f1
	</form>


</body>
<<<<<<< HEAD
</html>
=======
</html>
>>>>>>> 8df456e5d132335dfd9edce5c54280765d4351f1
