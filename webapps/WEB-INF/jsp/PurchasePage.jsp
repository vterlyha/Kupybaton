<%@ page import="com.kupybaton.model.Product"%>
<%@ page import="java.util.List"%>
<%@ page import="com.kupybaton.model.ProductList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
<link rel="stylesheet" href="/Kupybaton/style/Style.css">
</head>
<body>
	<h1>
		<c:out value="${listname}"/>
	</h1>
<form method="post" action="SelectList.do">
	<p><input type="text" name="listname" placeholder="name of the list">  Name of the list</p>
	<input type="SUBMIT" class="b2" value="Save">
</form>
</body>
</html>