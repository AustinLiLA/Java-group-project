<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="4">
  <tr>
     <th>name</th>
     <th>price</th>
     <th>quantity</th>
      <th>region</th>
  </tr>
    <c:forEach items="${stockList}" var="s">
        <tr>
            <td><c:out value="${s.stockName}" /></td>
            <td><c:out value="${s.stockPrice}" /></td>
            <td><c:out value="${s.stockQuantity}" /></td>
            <td><c:out value="${s.stockRegion}" /></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
