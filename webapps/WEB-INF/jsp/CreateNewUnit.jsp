<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<html>
<head>
<link rel="stylesheet" href="/Kupybaton/style/style.css">
</head>
<body>
	<h1>
		New Unit
	</h1>

	<form method="post" action="InsertValuesIntoUnit.do">
		<p>
			<input type="text" name="unitName" placeholder="name of the unit">
			Name of the unit
		</p>

		<input type="SUBMIT" class="b1" value="Create new Unit">
	</form>

</body>
</html>
