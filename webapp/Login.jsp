<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript" src="jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="LoginValidation.js"></script>
<link href="Style.css" rel="stylesheet" type="text/css">

<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<div id="templatemo_container">
	<jsp:include page="Header.jsp"></jsp:include>
	
    <div id="templatemo_content">
    <jsp:include page="SideBar.jsp"></jsp:include>
    <div align="center">
    
<form action="logincontroller" method="post">
   <input type ="hidden" name="action"  value="fromlogin">
		<table>
		<tr>
			<td>UserName</td>
			<td><input type="text" name="userName" id="userName"></td>
			<td><span id="spUserName"> </span></td>
		</tr>
	
		<tr>
			<td>UserPass</td>
			<td><input type="password" name="userPass" id="userPass"></td>
			<td><span id="spUserPass"> </span></td>
		</tr>
	
		<tr>
			<td></td>
			<td><input type="submit" value="Login" id="loginSubmit"></td>
			<td></td>
		</tr>
		</table>
		</form>
		<form action="logincontroller" method="get">
            <input type ="hidden" name="action"  value="Forgot">
		    <tr>
			<td></td>
			<td><input type="submit" value="Forgot Password" id="ForgotPassword"></td>
			<td></td>
		</tr>
		</form>
		
		<form action="logincontroller" method="get">
            <input type ="hidden" name="action"  value="fromSignUp">
		    <tr>
			<td></td>
			<td><input type="submit" value="Sign Up" id="SignUp"></td>
			<td></td>
		</tr>
		</form>
		</div>
		  <div class="cleaner_with_height">&nbsp;</div>
    </div> <!-- end of content -->
    	<jsp:include page="Footer.jsp"></jsp:include>
 </div>
		
</body>
</html>