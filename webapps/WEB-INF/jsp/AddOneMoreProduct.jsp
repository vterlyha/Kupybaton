<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
    <link rel="stylesheet" href="/Kupybaton/style/Style.css">
    <script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.12.0.min.js"></script>

	<script>
		$(document).ready(function(){
	    	$("#myTableChoosedProducts tbody tr").click(function(){
	        	$(this).css({'text-decoration': 'line-through'});
			});
		});
	</script>

	<script>
			window.onload = function sortTable() {
				var rows = $('#myTableChoosedProducts tbody  tr').get();
				rows.sort(function(a, b) {
					var A = $(a).children('td').eq(0).text().toUpperCase();
					var B = $(b).children('td').eq(0).text().toUpperCase();

					if (A < B) {
						return -1;
					}

					if (A > B) {
						return 1;
					}

					return 0;

				});

				$.each(rows, function(index, row) {
					$('#myTableChoosedProducts').children('tbody').append(row);
				});
			};

	</script>
	
	<script>
	$(document).ready(function() {
		$("#myTableChoosedProducts tbody tr").click(function() {
        	var row = $(this).remove().clone();
        	$('#myTableUnchoosedProducts').children('tbody').append(row);
        	
        	
		});
	});	

    </script>

	<script>
		$('#myTableUnchoosedProducts tbody  tr').sortable("update"){
			var rows = $('#myTableUnchoosedProducts tbody  tr').get();
			rows.sort(function(a, b) {
				var A = $(a).children('td').eq(0).text().toUpperCase();
				var B = $(b).children('td').eq(0).text().toUpperCase();

				if (A < B) {
					return -1;
				}

				if (A > B) {
					return 1;
				}

				return 0;

			});

			$.each(rows, function(index, row) {
				$('#myTableUnchoosedProducts').children('tbody').append(row);
			});
		};
</script>

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
		        
		<table id="myTableChoosedProducts">
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
		
		<table id="myTableUnchoosedProducts">
			<tbody>
			</tbody>
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
		<input type="SUBMIT" class="b3" value="Create new Product">
	</form>
    
</body>
</html>

