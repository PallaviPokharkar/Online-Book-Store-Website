<%@page import="com.OnlineBookStore.Models.Book"%>
<%@page import="com.OnlineBookStore.Models.Cart"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Book List</title>
<meta name="keywords" content="Book Store Template, Free CSS Template, CSS Website Layout, CSS, HTML" />
<meta name="description" content="Book Store Template, Free CSS Template, Download CSS Website" />
<link href="css/templatemo_style.css" rel="stylesheet" type="text/css" />
</head>
<body>
    <div id="templatemo_container">
	<jsp:include page="Header.jsp"></jsp:include>
	
    <div id="templatemo_content">
    <jsp:include page="SideBar.jsp"></jsp:include>
    
    <%
			List<Book> allBooks = (List<Book>) request.getAttribute("allBooks");
			%>
			<table>
				<tr>
					<td>Book Name</td>
					<td>Book Price</td>
					<td>Book Author</td>
					<td>Book Publisher</td>
					<td>Book Quantity</td>
					<td>Book Category</td>
					<td>Book Description</td>
					<td>Delete Action</td>
					<td>Update Action</td>
					
			       
				</tr>
				<%
				for (int i = 0; i < allBooks.size(); i++) 
				{
				   Book book = allBooks.get(i);
				%>
				<tr>
					<td><%=book.getBookName()%></td>
					<td><%=book.getBookPrice()%></td>
					<td><%=book.getBookAuthor()%></td>
					<td><%=book.getBookPublisher()%></td>
					<td><%=book.getBookQuantity()%></td>
					<td><%=book.getBookCategory()%></td>
					<td><%=book.getBookDesc()%></td>
					<td><a href="bookcontroller?action=deleteBookList&bookId=<%=book.getBookId()%>">Delete</a></td>
					<td><a href="bookcontroller?action=updateBookList&bookId=<%=book.getBookId()%>">Update</a></td>
				</tr>
				
				<%
				}
				%>
			</table>
    
    <div class="cleaner_with_height">&nbsp;</div>
    </div> <!-- end of content -->
    	<jsp:include page="Footer.jsp"></jsp:include>
 </div>
</body>
</html>