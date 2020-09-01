<!DOCTYPE html>
<html>
<body>

<h2>Using the XMLHttpRequest Object</h2>

<div id="demo">
<button type="button" onclick="loadXMLDoc()">Change Content</button>
</div>
	<form action="/downloadFile/13de9847-3127-48e9-9872-5fe52ea42606" method="GET" id="addApp">
		<button type = "submit">download</button>
	  </form>
	  
<script>
function loadXMLDoc() {
  var xmlHttp = new XMLHttpRequest();
  xmlHttp.open( "GET","/application/5", false ); // false for synchronous request
  xmlHttp.send();
}
</script>

</body>
</html>