<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://unpkg.com/tailwindcss@^1.0/dist/tailwind.min.css" rel="stylesheet">
<title>Insert title here</title>
<script type="text/javascript" src="https://canvasjs.com/assets/script/canvasjs.stock.min.js"></script>
<script type="text/javascript">
window.onload = function () {
  var dataPoints = [], currentDate = new Date(), rangeChangedTriggered = false;
   
  var stockChart = new CanvasJS.StockChart("chartContainer",{
    theme: "light2",
    /*title:{
      text:"LSEG StockChart with Stripline"
    },*/
    rangeChanged: function(e) {
        rangeChangedTriggered = true;
    },
    charts: [{
      axisX: {
         crosshair: {
          enabled: true,
          valueFormatString: "MMM DD, YYYY HH:mm:ss"
        }
      },
      axisY: {
        title: "Stock Prices",
        stripLines: [{
          showOnTop: true,
          lineDashType: "dash",
          color: "#ff4949",
          labelFontColor: "#ff4949",
          labelFontSize: 14
        }]
      },
      toolTip: {
        shared: true
      },
      data: [{
        type: "line",
        name: "Pageviews",
        xValueFormatString: "MMM DD, YYYY HH:mm:ss",
        xValueType: "dateTime",
        dataPoints : dataPoints
      }]
    }],
    navigator: {
      slider: {
        minimum: new Date(currentDate.getTime() - (90 * 1000))
      }
    },
    rangeSelector: {
      enabled: false
    }
  });
  var dataCount = 7000, ystart = 100, interval = 1000, xstart = (currentDate.getTime() - (7000 * 1000));
  updateChart(xstart, ystart, dataCount, interval);
   
  
  function updateChart(xstart, ystart, length, interval) {
	const demo = document.getElementById('price');	
    var xVal = xstart, yVal = ystart;
    for(var i = 0; i < length; i++) {
      yVal = yVal +  Math.round(5 + Math.random() *(-5-5));
      yVal = Math.min(Math.max(yVal, 5), 90);
      dataPoints.push({x: xVal,y: yVal});
      xVal += interval;
      
      demo.value =yVal;
    }
    if(!rangeChangedTriggered) {
        stockChart.options.navigator.slider.minimum = new Date(xVal - (90 * 1000));
    }
    stockChart.options.charts[0].axisY.stripLines[0].value =  dataPoints[dataPoints.length - 1].y;
    stockChart.options.charts[0].axisY.stripLines[0].label = stockChart.options.charts[0].axisY.stripLines[0]["value"];
    xstart = xVal;
    dataCount = 1;
    ystart = yVal;
    stockChart.render();
    setTimeout(function() { updateChart(xstart, ystart, dataCount, interval); }, 1000);
  }
}
</script>
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


					<%if (session.getAttribute("session_customer") != null) {%>
						<li><a href="http://localhost:8080/logout" class="block py-2 pr-4 pl-3 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white"
						aria-current="page"
						>Logout</a>
					</li>
					<% } else {%>
					<li><a href="http://localhost:8080/register" class="block py-2 pr-4 pl-3 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white"
						aria-current="page"
						>Register</a>	
					</li>
						</li>
						<li><a href="http://localhost:8080/login" class="block py-2 pr-4 pl-3 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white"
						aria-current="page"
						>Login</a>
					</li>
					<% } %>
				</ul>
				
			</div>
		</div>
	</nav>
	<br>
<h1> You have registered as <%= session.getAttribute("session_customer") %></h1>
<center><label><h1><b>${stock.stockId}</b></h1></label></center>
<center><label><h1><b>${stock.stockName} </b></h1></label></center>
<center><label><h1><b>${stock.stockRegion}</b></h1></label></center>
<center><label><h1><b>${stock.stockQuantity}</b></h1></label></center>

<div id="chartContainer" style="height: 450px; width: 100%;"></div>
  
  <div class="flex items-center justify-center min-h-screen bg-blue-500">
  <div class="px-8 py-6 mx-4 mt-4 text-left bg-white shadow-lg md:w-1/3 lg:w-1/3 sm:w-1/3  rounded-lg">
  
<form action="/stocks/orderbook" 	method="POST">
<div class="mt-4">
  <label for="price"class="block">Stock Name: </label><strong class="flex items-center justify-center">${stock.stockName}</strong>
  <input class="w-full px-2 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600 flex items-center" type="hidden" id="stockId" name="stockId" value="${stock.stockId}"><br>
  <label for="price"class="block">Stock Price:</label>
  <input class="w-full px-2 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600 flex items-center"required type="text" id="price" name="price"><br>
  <label for="quantity"class="block">Quantity:</label>
  <input class="w-full px-2 py-2 mt-2 border rounded-md focus:outline-none focus:ring-1 focus:ring-blue-600"required type="number" id="quantity" name="quantity" max="${stock.stockQuantity}"><br>
  <label for="order"class="block">Order Type:</label>
  <select name="order" id="order">
    <option value="buy" name="buy">Buy</option>
    <option value="sell" name="sell">Sell</option>
  </select>
  <br><br>
  <button class="w-full px-6 py-2 mt-4 text-white bg-blue-600 rounded-lg hover:bg-blue-900"type="submit" >Place Order</button>
  </div>
</form>
</div>
</div>
</body>

</html>