<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
    <link rel="stylesheet" href="/Kupybaton/style/Style.css">
</head>

<body>
	<form method="post" action="AddOneMoreProduct.do">
        <h1>
            <c:forEach items="${productlist}" var="list">
                <c:set var="listId" scope="request" value="${list.getId()}"/>
                <c:out value="${list.getName()}" />
                <input type="hidden" name="oneproductlist" value="${listId}" />
            </c:forEach>
        </h1>
        
		<table>
			<c:forEach items="${chosenProducts}" var="purchase">
			<tr>
				<td><c:out value="${purchase.getProduct().getName()}" /></td>
				<td><c:out value="${purchase.getQuantity()}" /></td>
				<c:set var="chosenProductId" scope="request" value="${purchase.getProduct().getId()}"/>
				<c:set var="chosenQuantity" scope="request" value="${purchase.getQuantity()}"/>
			</tr>
			</c:forEach>
		</table>
		        
        <select name="productId" id="mySelect">
            <c:forEach items="${products}" var="oneProduct">
                <option value="${oneProduct.id}">${oneProduct.name}</option>
            </c:forEach>
        </select>
        <input type = text name="quantity" placeholder="quantity">
        
        <input type="hidden" name="chosenProduct" value="${chosenProductId}" />
        <input type="hidden" name="chosenQuantity" value="${chosenQuantity}" />
		<input type="hidden" name="product" value="${productId}" />
        <input type="submit" class="b2" value="Save">
    </form>
    
	<form method="get" action="CreateNewProduct.do">
		<input type="hidden" name="oneproductlist" value="${listId}" />
		<input type="hidden" name="chosenProduct" value="${chosenProductId}" />
        <input type="hidden" name="chosenQuantity" value="${chosenQuantity}" />
		<input type="hidden" name="product" value="${productId}" />
		<input type="SUBMIT" class="b3" value="Create new Product">
	</form>
    
</body>
</html>

