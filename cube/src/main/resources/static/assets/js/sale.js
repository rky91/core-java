/**
 * 
 */

function addToCart() {
	
	var prodId;
	prodId = $("#productId").val();
	//alert("Ajax called" + prodId);
		
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "/restHome/updateCart",
		data : prodId,
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			//alert("Added to the cart."+data)
			$("#cartNotification").html(data);
			$("#addToCart").addClass('disabled');
			$('#addToCart').prop('disabled', true);
			$('#addToCart').text("Added To Cart")
		},
		error : function(e) {
			alert("Could not able to add to the cart !!")
		},
		done : function(e) {
			console.log("DONE");
		}
	});
	
}

function deleteFromCart(prodId) {
	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "/restHome/deleteFromCart",
		data : prodId,
		dataType : 'json',
		timeout : 100000,
		success : function(data) {
			$("#cartNotification").html(data);
			location.reload();
		},
		error : function(e) {
			alert("Could not able to delete from the cart !!")
		},
		done : function(e) {
			console.log("DONE");
		}
	});
}

























