<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table style="border:1px solid #CFCFCF;"> 
	 		<tr> 
	 			<th>serialNumber</th>
	 			<th>price</th>
 	 			<th>builder</th>
 	 			<th>model</th>
 	 			<th>type</th>  
 	 			<th>backWood</th> 
 	 			<th>topWood</th> 
 	 			 
 	 			 
 	 			 
 	 		</tr> 
 	 		 
 	 	<c:forEach var="guitar" items="${requestScope.guitars}">  
 	 		<tr> 
 	 			<td>${guitar.serialNumber}</td> 
	 			<td>${guitar.price}</td> 
 	 			<td>${guitar.builder}</td> 
	 			<td>${guitar.model}</td> 
 	 			<td>${guitar.type}</td> 
 	 			<td>${guitar.backWood}</td> 
 	 			<td>${guitar.topWood}</td> 
 	 			
 	 		</tr>	 
 	 		 
 	 	</c:forEach> 

 
 	</table> 

</body>
</html>