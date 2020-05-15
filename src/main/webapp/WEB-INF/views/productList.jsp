<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
  table{width: 800px; border:5px rgb(236,108,084) solid; }
  td,th{text-align: center; border: 1px gray solid;}
  a{text-decoration: none; color:rgb(236,108,084)}
  button{cursor: pointer;}
</style>

${pageContext.request.contextPath}
<script  src="https://code.jquery.com/jquery-2.2.4.js"></script>

<script type="text/javascript">
	$(function(){
		$(document).on("click", "button", function() {
			
			var code= $(this).parent().parent().find("#code").text();
			// this.td.tr
			alert(code);
			location.href = "${pageContext.request.contextPath}/del/"+code;	
			// http://localhost:8000/controller/del/A01
		});
	})
</script>
</head>
<body>
<table>
<caption>
  <h1>[ Product List Page ]</h1>
</caption>
 <tr>
   <th>번호</th>
   <th>상품코드</th>
   <th>상품이름</th>
   <th>상품가격</th>
   <th>상품설명</th>
   <th>삭제하기</th>
 </tr>
 <!-- ${empty list}도 가능 -->
<c:choose>
 <c:when test="${list.size()==0}"><tr><th colspan="6">등록된상품이없습니다.</th><tr></c:when>
 <c:otherwise>
 	<c:forEach items="${list}" var="dto" varStatus="a">
  		<tr>
  			<td>${a.count}</td>
  			<td id="code">${dto.code}</td>
    		<td><a href="read.kosta?code=${dto.code}">${dto.name}</a></td>
   			<td><fmt:formatNumber value="${dto.price}"/></td>
    		<td>${dto.detail}</td>
    		<td><button type="button">Delete</button></td>
  		</tr>
 	</c:forEach>
  </c:otherwise>
 </c:choose>
  <tr>
    <th colspan="6"><a href="insertForm.kosta">상품등록하기</a></th>
   </tr>
</table>
</body>
</html>