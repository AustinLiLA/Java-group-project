<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.ab.models.Customer" %>
        <%@ page import="com.ab.models.Stock" %>
    <%@ page import="java.util.List" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://unpkg.com/tailwindcss@^1.0/dist/tailwind.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Portfolio</title>


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
				class="flex justify-center text-1xl font-semibold whitespace-nowrap dark:text-white bg-blue-300">
				Balance: <%Customer customer1 = (Customer)session.getAttribute("session_customer");
				   
							out.print(customer1.getBalance());
										
							/* if(customer1.getBalance() < (stk.getStockPrice()*stk.getStockQuantity())){
								
								out.print("Balance is insufficient to place an order!!!!");
							
							} */
									%>
				</span>
			</a>
			<% } else {%>
				<a  class="flex" href="http://localhost:8080/stocks"> <span
				class="flex justify-center text-1xl font-semibold whitespace-nowrap dark:text-white bg-blue-300">
				Balance: ------
				</span>
			</a>
			<% } %>
			<div class="hidden w-full md:block md:w-auto" id="mobile-menu">
				<ul
					class="flex flex-col mt-4 md:flex-row md:space-x-8 md:mt-0 md:text-sm md:font-medium">
					<%if (session.getAttribute("session_customer") == null) {%>
					<li><a href="http://localhost:8080/stocks"
						class="block py-2 pr-4 pl-3 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white"
						aria-current="page">Stocks</a></li>
					<li><a href="http://localhost:8080/login"
						class="block py-2 pr-4 pl-3 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white"
						aria-current="page">Login</a></li>
					<li><a href="http://localhost:8080/register" class="block py-2 pr-4 pl-3 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white"
						aria-current="page"
						>Register</a>
					</li>
					<% } else {%>
					<li><a href="http://localhost:8080/stocks"
						class="block py-2 pr-4 pl-3 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white"
						aria-current="page">Stocks</a></li>
						<li><a href="http://localhost:8080/portfolio"
						class="block py-2 pr-4 pl-3 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white"
						aria-current="page">Portfolio</a></li>
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




<div class="overflow-x-auto relative shadow-md sm:rounded-lg  min-h-screen bg-blue-500">
    <table class="w-full text-sm text-left text-black-500 dark:text-black-400">
        <thead class="text-xs text-black-700 uppercase dark:text-black-500">
            <tr>
                <th scope="col" class="py-3 px-6 bg-black-50 dark:bg-black-800">
                    ID
                </th>
                <th scope="col" class="py-3 px-6">
                    STOCK ID
                </th>
                <th scope="col" class="py-3 px-6 bg-gray-50 dark:bg-gray-800">
                    REGION
                </th>
                <th scope="col" class="py-3 px-6 bg-gray-50 dark:bg-gray-800">
                    PRICE
                </th>
                <th scope="col" class="py-3 px-6 bg-gray-50 dark:bg-gray-800">
                    QUANTITY
                </th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${orderBookCustomerList}" var="od">
            <tr class="border-b border-gray-200 dark:border-gray-700">
                <th scope="row" class="py-4 px-6 font-medium text-gray-900 whitespace-nowrap bg-gray-50 dark:text-white dark:bg-gray-800">
                    <c:out value="${od.orderId}" />
                </th>
                <td class="py-4 px-6 font-medium text-gray-900 whitespace-nowrap bg-gray-50 dark:text-white dark:bg-gray-800">
                    <c:out value="${od.stockId}" />
                </td>
                <td class="py-4 px-6 font-medium text-gray-900 whitespace-nowrap bg-gray-50 dark:text-white dark:bg-gray-800">
                    <c:out value="${od.stockRegion}" />
                </td>
                <td class="py-4 px-6 font-medium text-gray-900 whitespace-nowrap bg-gray-50 dark:text-white dark:bg-gray-800">
                    <c:out value="${od.orderPrice}" />
                </td>
                <td class="py-4 px-6 font-medium text-gray-900 whitespace-nowrap bg-gray-50 dark:text-white dark:bg-gray-800">
                    <c:out value="${od.orderQuantity}" />
                </td>
            </tr>
           </c:forEach>
        </tbody>
    </table>
</div> 
</body>
</html>