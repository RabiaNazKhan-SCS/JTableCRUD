/**
 * 
 */
$(document).ready(function(){
	
	$("button").click(function(e){
		
		var ee=$("#text2").val();
		alert(ee);
		ee=ee.replace(/(?:^|\s)\w/g, function(match) {
			return match.toUpperCase();
		});
		$("#text2").val(ee);
		alert(ee);
		
	});
});
