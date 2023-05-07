$(document).ready(function() {
	$("#customerSubmit").click(function() {
		var customerName = $("#customerName").val();
		if (customerName == null || customerName == "") {
			$("#spCustomerName").text("Error");
			$("#customerName").addClass("InputError");
			return (false);
		}

		var customerAddress = $("#customerAddress").val();
		if (customerAddress == null || customerAddress == "") {
			$("#spCustomerAddress").text("Error");
			$("#customerAddress").addClass("InputError");
			$("#spCustomerName").text("");
			$("#customerName").removeClass("InputError");
			return (false);
		}

		var customerEmailid = $("#customerEmailid").val();
		if (customerEmailid == null || customerEmailid == "") {
			$("#spCustomerEmailid").text("Error");
			$("#customerEmailid").addClass("InputError");
			$("#spCustomerAddress").text("");
			$("#customerAddress").removeClass("InputError");
			return (false);
		}

		var customerContactno = $("#customerContactno").val();
		if (customerContactno == null || customerContactno == "") {
			$("#spCustomerContactno").text("Error");
			$("#customerContactno").addClass("InputError");
			$("#spCustomerEmailid").text("");
			$("#customerEmailid").removeClass("InputError");
			return (false);
		}

		var customerPassword = $("#customerPassword").val();
		if (customerPassword == null || customerPassword == "") {
			$("#spCustomerPassword").text("Error");
			$("#customerPassword").addClass("InputError");
			$("#spCustomerContactno").text("");
			$("#customerContactno").removeClass("InputError");
			return (false);
		}


	});
});

$(document).ready(function() {
		$("#userPass").keyup(function() {
			var len = $("#userPass").val().length;	
			if(len==0){
				$("#spUserPass").text("");
				$("#spUserPass").removeClass("red");
			}else if(len<4){
				$("#spUserPass").text("WEAK");
				$("#spUserPass").addClass("red");
				$("#spUserPass").removeClass("orange");
			}else if(len < 8){
				$("#spUserPass").text("MEDIUM");
				$("#spUserPass").addClass("orange");
				$("#spUserPass").removeClass("green");
			}else{
				$("#spUserPass").text("STRONG");
				$("#spUserPass").addClass("green");
			}
			return (false);
		
	});
	
});