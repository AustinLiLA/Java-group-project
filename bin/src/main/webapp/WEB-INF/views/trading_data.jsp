<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://unpkg.com/tailwindcss@^1.0/dist/tailwind.min.css" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<center><label><h1><b>${marketOrder.price}</b></h1></label></center>
<center><label><h1><b>${marketOrder.quantity}</b></h1></label></center>
<center><label><h1><b>${marketOrder.order}</b></h1></label></center>
<!-- NAVBAR -->
	<nav
		class="bg-white border-gray-200 px-2 sm:px-4 py-2.5 rounded dark:bg-gray-800">
		<div
			class="container flex flex-wrap justify-between items-center mx-auto">
			<a href="http://localhost:8080/stocks" class="flex"> <span
				class="self-center text-2xl font-semibold whitespace-nowrap dark:text-white">Trading Platform</span>
			</a>
			<!-- <button data-collapse-toggle="mobile-menu" type="button"
				class="inline-flex items-center p-2 ml-3 text-sm text-gray-500 rounded-lg md:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600"
				aria-controls="mobile-menu-2" aria-expanded="false">
				</button> -->
			<div class="hidden w-full md:block md:w-auto" id="mobile-menu">
				<ul
					class="flex flex-col mt-4 md:flex-row md:space-x-8 md:mt-0 md:text-sm md:font-medium">
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
						<li><a href="http://localhost:8080/logout" class="block py-2 pr-4 pl-3 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white"
						aria-current="page"
						>Logout</a>
					</li>
				</ul>
				
			</div>
		</div>
	</nav>


OrderBook

<div class="p-20">
	<table border="1"
		class="flex justify-center table-auto border-separate border-spacing-2 border border-slate-500 ">
		
		<tr>
     <th class="border border-slate-700">ID</th>
     <th class="border border-slate-700">STOCK ID</th>
     <th class="border border-slate-700">CUSTOMER ID</th>
     <th class="border border-slate-700">TYPE</th>
     <th class="border border-slate-700">PRICE</th>
     <th class="border border-slate-700">QUANTITY</th>
 
     
  </tr>
    <c:forEach items="${marketOrderList}" var="mkt">
        <tr>
            <td class="border border-slate-800"><c:out value="${mkt.marketOrderId}" /></td>
            <td class="border border-slate-800"><c:out value="${mkt.stockId}" /></td>
            <td class="border border-slate-800"><c:out value="${mkt.customerId}" /></td>
            <td class="border border-slate-800"><c:out value="${mkt.marketOrderType}" /></td>
            <td class="border border-slate-800"><c:out value="${mkt.marketOrderPrice}" /></td>
            <td class="border border-slate-800"><c:out value="${mkt.marketOrderQuantity}" /></td>
            
            
            <td class="border border-slate-800"><button type="button" onclick="location.href='http://localhost:8080/stocks/chart/${s.stockId}/${s.stockName}/${s.stockQuantity}/${s.stockRegion}';">View</button></td>
        </tr>
    </c:forEach>
		</div>

</body>
</html>