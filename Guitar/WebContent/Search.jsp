<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
<title>吉他查询系统</title>
</head>
<body>
<form action="myServlet/TestServlet" method="post">
请输入吉他的相关信息<br/>

<!--编号<input type="text" name="serialNumber"><br/>
价格<input type="text" name="price"><br/>  -->
厂商<input type="text" name="builder"><br/>
<!--型号<input type="text" name="model"><br/>  -->
类型<input type="text" name="type"><br/>
背板<input type="text" name="backWood"><br/>
面板<input type="text" name="topWood"><br/>
<input type="submit" value="查询">
</form>
</body>
</html>