<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
<link rel="stylesheet" href="/Kupybaton/style/style.css">
</head>
<body>
	<h1>
		List of products
	</h1>
<p>
<c:out value="${warningMessage}"/>
</p>
<form method="post" action="PurchasePage.do">
	<p><input type="text" name="listname" placeholder="name of the list" class = "textfield">  Name of the list</p>
	<input type="SUBMIT" class="b2" value="Save">
</form>
</body>
</html>
