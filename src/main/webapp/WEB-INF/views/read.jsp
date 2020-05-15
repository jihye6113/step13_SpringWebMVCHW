<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
table{width: 800px;border:5px rgb(236,108,084) solid; text-align: center;}
</style>
</head>
<body>
<h1>상품 상세보기</h1>
<table border="1">
 <tr>
   <th>상품코드</th>
   <td>${product.code}</td>
 </tr>
  <tr>
   <th>상품이름</th>
   <td>${product.name}</td>
 </tr>
  <tr>
   <th>상품가격</th>
   <td>${product.price}</td>
 </tr>
  <tr>
   <th>상품설명</th>
   <td>${product.detail}</td>
 </tr>
</table>
</body>
</html>