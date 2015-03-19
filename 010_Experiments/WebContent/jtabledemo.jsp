<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Jtable Demo</title>
	<link href="resources/css/images/metro/darkorange/jtable.css" type="text/css" rel="stylesheet"/>
	<link href="resources/css/jquery-ui.css" type="text/css" rel="stylesheet"/>
	
		<script src="resources/js/jquery-2.1.3.js" ></script>
		<script src="resources/js/jquery-ui.js" ></script>
		<script src="resources/js/jquery.jtable.js"></script>
	

	
	 <script type="text/javascript">
	
			$(document).ready(function(){
				
				$('#CustomerTable').jtable({
					title:'Table of Customer',
					paging:'true',
					editinline:{enable:true},
					actions:{
						listAction:'rest/Crud/list',
						createAction:'rest/Crud/create',
						updateAction:'rest/Crud/update',
						deleteAction:'rest/Crud/delete',
						},

					fields:{
						customerId:{
							title:'Customer ID',
							key:true,
							width: '20%'
						},
						customerName:{
							title:'Customer Name',
							width: '20%'
						},

						customerEmail:{
							title:'Customer email',
							width: '40%'
							},
					}
				});

			$('#CustomerTable').jtable('load');
		});
</script>

</head>

<body>
	<div>
		<h1>My First Jtable</h1>
		<div id="CustomerTable"></div>
		
	</div>
</body>

</html>