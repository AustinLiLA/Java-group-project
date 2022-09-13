<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
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
<br>
<center><label><h1><b>${stock.stockName} Trading StockChart</b></h1></label></center>
<center><label><h1><b>${stock.stockRegion}</b></h1></label></center>
<center><label><h1><b>${stock.stockQuantity}</b></h1></label></center>
<div id="chartContainer" style="height: 450px; width: 100%;"></div>
  <br><br>
<form action="http://localhost:8080/stocks/orderbook/{price}/{quantity}/{order}" method="GET">
  <label for="price">Stock Price:</label>
  <input type="text" id="price" name="price" value="price"><br><br>
  <label for="quantity">Quantity:</label>
  <input type="text" id="quantity" name="quantity" value="quantity"><br><br>
  <label for="order">Order Type:</label>
  <select name="order" id="order" value="order">
    <option value="buy">Buy</option>
    <option value="sell">Sell</option>
  </select>
  <br><br>
  <input type="submit" value="Place Order">
</form>
 </body>
</html>