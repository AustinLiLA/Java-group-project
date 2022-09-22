<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.ab.models.Customer" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://unpkg.com/tailwindcss@^1.0/dist/tailwind.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>My page</title>
</head>
<body>
<!-- NAVBAR -->
	<nav
		class="bg-white border-gray-200 px-2 sm:px-4 py-2.5 rounded dark:bg-gray-800">
		<div
			class="container flex flex-wrap justify-between items-center mx-auto">
			<a href="http://localhost:8080/stocks" class="flex"> <span
				class="self-center text-2xl font-semibold whitespace-nowrap dark:text-white">Trading Platform</span>
			</a>
			 <%if (session.getAttribute("session_customer") != null) {%>
			 <a  class="flex" href="http://localhost:8080/stocks"> <span
				class="flex justify-center text-1xl font-semibold whitespace-nowrap dark:text-white">
				Balance: <%Customer customer1 = (Customer)session.getAttribute("session_customer");
							out.print(customer1.getBalance());
									%>
				</span>
			</a>
			<% } else {%>
				<a  class="flex" href="http://localhost:8080/stocks"> <span
				class="flex justify-center text-1xl font-semibold whitespace-nowrap dark:text-white">
				Balance: ------
				</span>
			</a>
			<% } %>
			<div class="hidden w-full md:block md:w-auto" id="mobile-menu">
				<ul
					class="flex flex-col mt-4 md:flex-row md:space-x-8 md:mt-0 md:text-sm md:font-medium">
					<%if (session.getAttribute("session_customer") == null) {%>
					<li><a href="http://localhost:8080/login"
						class="block py-2 pr-4 pl-3 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white"
						aria-current="page">Login</a></li>
					<li><a href="http://localhost:8080/register" class="block py-2 pr-4 pl-3 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white"
						aria-current="page"
						>Register</a>
					</li>
					<% } else {%>
					<li><a href="http://localhost:8080/logout" class="block py-2 pr-4 pl-3 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white"
						aria-current="page"
						>Logout</a></li>
					<li><a href="http://localhost:8080/stocks/orderbookCustomerId" class="block py-2 pr-4 pl-3 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white"
						aria-current="page"
						><%Customer customer = (Customer)session.getAttribute("session_customer");
							String email =(String)customer.getEmail();
							out.print(customer.getEmail());
									%>
					</a></li>
							<% } %>
				</ul>
				
			</div>
		</div>
	</nav>
<%Customer customer = (Customer)session.getAttribute("session_customer");
							String email =(String)customer.getEmail();
							
									%>
<h1>Welcome <%out.print(customer.getFirstName()); %></h1>


<div class="p-20">
	<table border="1"
		class="flex justify-center table-auto border-separate border-spacing-2 border border-slate-500 ">
		
		<tr>
     <th class="border border-slate-700">ID</th>
     <th class="border border-slate-700">STOCK ID</th>
     <th class="border border-slate-700">REGION</th>
     <th class="border border-slate-700">TYPE</th>
     <th class="border border-slate-700">PRICE</th>
     <th class="border border-slate-700">QUANTITY</th>
<!--      <th class="border border-slate-700">TIMESTAMP</th>
 --> 
     
  </tr>
    <c:forEach items="${orderBookCustomerList}" var="od">
        <tr>
            <td class="border border-slate-800"><c:out value="${od.orderId}" /></td>
            <td class="border border-slate-800"><c:out value="${od.stockId}" /></td>
            <td class="border border-slate-800"><c:out value="${od.stockRegion}" /></td>
            <td class="border border-slate-800"><c:out value="${od.orderType}" /></td>
            <td class="border border-slate-800"><c:out value="${od.orderPrice}" /></td>
            <td class="border border-slate-800"><c:out value="${od.orderQuantity}" /></td>
<%--             <td class="border border-slate-800"><c:out value="${od.orderTimeStamp}" /></td>
 --%>            
        </tr>
    </c:forEach>
    </table>
		</div>

</body>
</html>