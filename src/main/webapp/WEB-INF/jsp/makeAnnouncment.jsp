<!DOCTYPE html>
<html>
<body>

<h2>Using the XMLHttpRequest Object</h2>

<div id="demo">
<button type="button" onclick="loadXMLDoc()">Change Content</button>
</div>
	<form action="/announcement/add" method="POST" id="addAnnoun" >
		<input type="text" id="title" name="title" placeholder="Title"/>
		<input type="text" id="text" name="text" placeholder="Text"/>
		
		<button type = "submit">Make Announcment</button>
        <input type="hidden" id= "csrf" name="${_csrf.parameterName}" value="${_csrf.token}"/>		
	  </form>
	  
	  
<script>
function loadXMLDoc() {
  var xmlHttp = new XMLHttpRequest()
  var title = document.getElementById("title").value
  var text = document.getElementById("text").value
  var csrfName =  document.getElementById("csrf").name
  var csrfToken = document.getElementById("csrf").value
  
  var value = JSON.stringify({
      title: title,
      text: text,
      csrfName: csrfToken
  });
  
  console.log(csrfName)
    console.log(csrfToken)

  xmlHttp.open( "POST","/announcement/add", true ); // false for synchronous request

  xmlHttp.setRequestHeader('Content-Type', 'application/json; charset=utf-8');
  xmlHttp.send(value);
}
</script>

</body>
</html>