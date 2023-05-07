$(document).ready(function()
{
	$("#loginSubmit").click(function()
	{
		var userName = $("#userName").val();
		if(userName == null || userName=="")
		{
			$("#spUserName").text("Error");
			$("#userName").addClass("InputError");
			return(false);
		}
		
		var userPass = $("#userPass").val().length;
		if(userPass == null || userPass=="")
		{
			$("#spUserPass").text("Error");
			$("#userPass").addClass("InputError");
			$("#spUserName").text("");
			$("#userName").removeClass("InputError");
			return (false);
		}
		
		});
		
	});
	
	