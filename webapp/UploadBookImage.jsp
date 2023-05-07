<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Book Image</title>
</head>
<body>
<div id="templatemo_container">
	<jsp:include page="Header.jsp"></jsp:include>

    <div id="templatemo_content">
    <jsp:include page="SideBar.jsp"></jsp:include>
    
<div  align="center">
	<form action="uploadimagecontroller" method="post"
		enctype="multipart/form-data">
	<table>
		<tr>
			<td>UploadImage</td>
			<td><input type="file" name="uploadBookImage"></td>

		</tr>
		<tr>
			<td><input type="submit"></td>
		</tr>
	</table>
	
	</form>
	</div>
	<div class="cleaner_with_height">&nbsp;</div>
    </div> <!-- end of content -->
    	<jsp:include page="Footer.jsp"></jsp:include>
    </div>
</body>
</html>