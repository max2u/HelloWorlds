<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
    "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome ${user}</title>

<!--  adding bootstrap is easy, just include its jsp and css here and voilà -->
</head>
<body>

	<div align="center" style="margin-top: 50px;">
		<h1>hello ${user}</h1>
		<small style="font-color: #aaaaaa">we got your name from the session</small>
	</div>

</body>
</html>