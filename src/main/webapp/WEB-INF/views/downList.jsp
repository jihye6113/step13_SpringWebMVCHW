<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
  a{text-decoration: none; color: rgb(236,108,84);}
</style>
</head>
<body>
<h2>다운로드 LIST </h2>
<ul>
 <c:forEach items="${fileNames}" var="fileName" >
   <li><a href="down.do?fname=${fileName}">${fileName}</a></li>
 </c:forEach>
</ul>

</body>
</html>




