$(document).ready(function()
{
	$("#bookSubmit").click(function()
	{
		var bookName = $("#bookName").val();
		if(bookName == null || bookName=="")
		{
			$("#spBookName").text("Error");
			$("#bookName").addClass("InputError");
			return (false);
		}
		
		var bookAuthor = $("#bookAuthor").val();
		if(bookAuthor == null || bookAuthor=="")
		{
			$("#spBookAuthor").text("Error");
			$("#bookAuthor").addClass("InputError");
			$("#spBookName").text("");
			$("#bookName").removeClass("InputError");
			return (false);
		}
		
		var bookPrice = $("#bookPrice").val();
		if(bookPrice == null || bookPrice=="")
		{
			$("#spBookPrice").text("Error");
			$("#bookPrice").addClass("InputError");
			$("#spBookAuthor").text("");
			$("#bookAuthor").removeClass("InputError");
			return (false);
		}
		
		var bookPublisher = $("#bookPublisher").val();
		if(bookPublisher == null || bookPublisher=="select")
		{
			$("#spBookPublisher").text("Error");
			$("#bookPublisher").addClass("InputError");
			$("#spBookPrice").text("");
			$("#bookPrice").removeClass("InputError");
			return (false);
		}
		
		var bookQuantity = $("#bookQuantity").val();
		if(bookQuantity == null || bookQuantity=="")
		{
			$("#spBookQuantity").text("Error");
			$("#bookQuantity").addClass("InputError");
			$("#spBookPublisher").text("");
			$("#bookPublisher").removeClass("InputError");
			
			return (false);
		}
		
		var bookCategory = $("#bookCategory").val();
		if(bookCategory == null || bookCategory=="")
		{
			$("#spBookCategory").text("Error");
			$("#bookCategory").addClass("InputError");
			$("#spBookQuantity").text("");
			$("#bookQuantity").removeClass("InputError");
			return (false);
		}
		
		var bookDesc = $("#bookDesc").val();
		if(bookDesc == null || bookDesc=="")
		{
			$("#spBookDesc").text("Error");
			$("#bookDesc").addClass("InputError");
			$("#spBookCategory").text("");
			$("#bookCategory").removeClass("InputError");
			return (false);
		}
	});
});