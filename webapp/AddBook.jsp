<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<script text="text/javascript" src="jquery-3.3.1.min.js"></script>
<script text="text/javascript" src="BookValidaion.js"></script>
<link href="Style.css" rel="stylesheet" type="text/css">

<meta name="keywords"
	content="Book Store Template, Free CSS Template, CSS Website Layout, CSS, HTML" />
<meta name="description"
	content="Book Store Template, Free CSS Template, Download CSS Website" />
<link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />
<meta charset="UTF-8">
<title>Add Book</title>
</head>
<body>
	<div id="templatemo_container">
		<jsp:include page="Header.jsp"></jsp:include>

		<div id="templatemo_content">

			<jsp:include page="SideBar.jsp"></jsp:include>
			<div align="center">
				<form action="bookcontroller" method="post">
					<input type="hidden" name="action" value="addBook">
					<table>
						<tr>
							<td>BookName</td>
							<td><input Type="text" name="bookName" id="bookName">
							<td><span id="spBookName"> </span></td>
						</tr>
						<tr>
							<td>BookAuthor</td>
							<td><input Type="text" name="bookAuthor" id="bookAuthor">
							<td><span id="spBookAuthor"> </span></td>
						</tr>
						<tr>
							<td>BookPrice</td>
							<td><input Type="text" name="bookPrice" id="bookPrice">
							<td><span id="spBookPrice"> </span></td>
						</tr>
						<tr>
							<td>BookPublisher</td>
							<td><select id="bookPublisher" name="bookPublisher">
									<option values="-1">select</option>
									<option value="Squad">Squad</option>
									<option value="CT">CT</option>
							</select>
							<td><span id="spBookPublisher"> </span></td>
						</tr>
 						<tr> 
 							<td>BookQuantity</td> 
 							<td><input Type="text" name="bookQuantity" id="bookQuantity"> 
 							<td><span id="spBookQuantity"> </span></td> 
 						</tr> 
						<tr>
							<td>BookCategory</td>
							<td><input Type="text" name="bookCategory" id="bookCategory">
							<td><span id="spBookCategory"> </span></td>
						</tr>
						<tr>
							<td>BookDesc</td>
							<td><input Type="text" name="bookDesc" id="bookDesc">
							<td><span id="spBookDesc"> </span></td>
						</tr>
					</table>
					<tr>
						<td></td>
						<td><input Type="submit" name="submit" id="bookSubmit">
						<td></td>
					</tr>
				</form>
				<form action="bookcontroller" method="get">
					<input type="hidden" name="action" value="fromUpdateBook">
					<table>
						<tr>
							<td></td>
							<td><input type="submit" value="Update Book" id="UpdateBook"></td>
							<td></td>
						</tr>
					</table>
				</form>

			</div>
			<div class="cleaner_with_height">&nbsp;</div>
		</div>
		<!-- end of content -->
		<jsp:include page="Footer.jsp"></jsp:include>
	</div>

</body>
</html>