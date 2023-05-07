<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript" src="jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="CustomerValidation.js"></script>
<link href="Style.css" rel="stylesheet" type="text/css">

<meta charset="UTF-8">
<title>Add Customer</title>
</head>
<body>
<div id="templatemo_container">
	<jsp:include page="Header.jsp"></jsp:include>

    <div id="templatemo_content">
    <jsp:include page="SideBar.jsp"></jsp:include>
    
    <div align="center">
<form action="customercontroller" method="post">
<input type="hidden" name="action" value="addCustomer">
		<table>
		<tr>
			<td>CustomerName</td>
			<td><input Type="text" name="customerName" id="customerName"></td>
			<td><span id="spCustomerName"> </span></td>
		</tr>
		<tr>
			<td>CustomerAddress</td>
			<td><input Type="text" name="customerAddress" id="customerAddress"></td>
			<td><span id="spCustomerAddress"> </span></td>
		</tr>
		<tr>
			<td>CustomerEmailid</td>
			<td><input Type="text" name="customerEmailid" id="customerEmailid"></td>
			<td><span id="spCustomerEmailid"> </span></td>
		</tr>
		<tr>
			<td>CustomerContactno</td>
			<td><input Type="text" name="customerContactno" id="customerContactno"></td>
			<td><span id="spCustomerContactno"> </span></td>
		</tr>
		<tr>
			<td>CustomerPassword</td>
			<td><input Type="password" name="customerPassword" id="customerPassword"></td>
			<td><span id="spCustomerPassword"> </span></td>
		</tr>
		</table>
		<tr>
			<td></td>
			<td><input Type="submit" name="submit" id="customerSubmit">
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