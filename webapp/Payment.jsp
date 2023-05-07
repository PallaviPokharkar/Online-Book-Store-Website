<%@page import="com.OnlineBookStore.Models.Payment"%>
<%@page import="java.util.List"%>
<%@page import="com.OnlineBookStore.Models.Order"%>
<%@page import="com.OnlineBookStore.Models.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta name="keywords" content="Book Store Template, Free CSS Template, CSS Website Layout, CSS, HTML" />
<meta name="description" content="Book Store Template, Free CSS Template, Download CSS Website" />
<link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
 <div id="templatemo_container">
	<jsp:include page="Header.jsp"></jsp:include>

    <div id="templatemo_content">
    		<jsp:include page="SideBar.jsp"></jsp:include>


	<%Customer customer =(Customer)request.getAttribute("customer");  %>
	
<%-- 	<%List<Order> allOrders =(List<Order>) request.getAttribute("allOrders"); %> --%>
<%--  	<%Order order=(Order)request.getAttribute("order"); %>  --%>


    <%
    HttpSession httpSession = request.getSession();
	String username = (String) httpSession.getAttribute("loggedInUser");
	%> 

   <%Payment payment=(Payment)request.getAttribute("payment1"); %>

	
	<form action="paymentcontroller" method="get">
		<input type="hidden" name="action" value="payment">
<%-- 		<input type="hidden" name="orderId" value="<%=order.getOrderId() %>"> --%>
		
		<table>
			<tr>

				<td>Payment Details</td>
				<td><select id="paymentType" name="paymentType">
						<option values="-1">Select Payment Mode</option>
						<option value="COD">COD</option>
						<option value="CreditCard">Credit Card</option>
						<option value="DebitCard">Debit Card</option>
<!-- 						<option value="UPI">UPI</option> -->
				</select>
			 </td>
			 
			<tr>
			<td></td>
			<td><input type="submit" value="Make Payment" id="payment"></td>
			<td></td>
			</tr>
		</tr>
		</table>
		</form>
			

<!--    <a href="index.html"><img src="images/templatemo_ads.jpg" alt="css template ad" /></a> -->
           
          <!-- end of content right -->
   
        </div> 
        <!-- end of content left --> 
        
        
    	<div class="cleaner_with_height">&nbsp;</div>

    <!-- end of content -->
    	<jsp:include page="Footer.jsp"></jsp:include>
 </div>
</body>
</html>