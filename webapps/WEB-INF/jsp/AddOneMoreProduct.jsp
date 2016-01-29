<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
    <link rel="stylesheet" href="/Kupybaton/style/Style.css">
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.12.0.min.js"></script>
	<script src="/Kupybaton/js/CrossProductByLine.js"></script>
	<script src="/Kupybaton/js/SortChoosedProducts.js"></script>
	<script src="/Kupybaton/js/AddUnchoosedProducts.js"></script>

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
		
		<p>
			<c:out value="${warningMessage}"/>
		</p>
		        
		<table id="myTableChoosedProducts" class = "myTableChoosedProducts">
			<tbody>
				<c:forEach items="${chosenProducts}" var="purchase">
					<tr>
						<td><c:out value="${purchase.getProduct().getName()}" /></td>
						<td><c:out value="${purchase.getQuantity()}" /></td>
						<c:set var="chosenProductId" scope="request" value="${purchase.getProduct().getId()}"/>
						<c:set var="chosenQuantity" scope="request" value="${purchase.getQuantity()}"/>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<table id="myTableUnchoosedProducts" class ="myTableUnchoosedProducts">
			<tbody>
			</tbody>
		</table>

		<select name="productId" id="mySelect" class = "select">
            <c:forEach items="${products}" var="oneProduct">
                <option value="${oneProduct.id}">${oneProduct.name}</option>
            </c:forEach>
        </select>
        <input type = text name="quantity" placeholder="quantity" class = "textfield">
        
        <input type="hidden" name="chosenProduct" value="${chosenProductId}" />
        <input type="hidden" name="chosenQuantity" value="${chosenQuantity}" />
		<input type="hidden" name="product" value="${productId}" />
        <input type="submit" class="b2" value="Save">
    </form>
    
	<form method="get" action="CreateNewProduct.do">
		<input type="SUBMIT" class="b3" value="Create new Product">
	</form>
    
</body>
</html>

