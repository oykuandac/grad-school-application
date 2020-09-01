<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Page Title</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="/css/index.css">
</head>
<body>
<div class="header">
    <div class="header-section-1" >
        <div class="site-logo" >
            <a href="/index" class="header-logo" >
              <img src = "https://en.iyte.edu.tr/wp-content/themes/IYTE/assets/img/logo-white-full-v-en.png" style="width: 
              80%;">
           </a>
        </div>
    </div>
</div>

<div class="topnav" id="myTopnav">
  <a href="/index" class="active">Home</a>
  <a href="/news">Announcements</a>

  <a href="javascript:void(0);" style="font-size:15px;" class="icon" onclick="myFunction()">&#9776;</a>
</div>


<div >
  <button id="goPre" onclick="window.location.href = 'preApplication'; " style="width: 30%; height:50px; margin-left: 35%;margin-top: 5%;background-color:#91080F; color: white;">Go to Pre-Application Form!</button>

</div>

<h1 id="msg" style="text-align:center;">Applications have not started yet!!!</h1>

<br>
<script>
var msg = document.getElementById("msg");
var button = document.getElementById("goPre");

console.log('${isStart}');

if('${isStart}' == "false"){
	console.log("sa");
	msg.style.display = "block";
	button.style.display = "none";
}else{
	msg.style.display = "none";
	button.style.display = "block";
}

function myFunction() {
  var x = document.getElementById("myTopnav");
  if (x.className === "topnav") {
    x.className += " responsive";
  } else {
    x.className = "topnav";
  }

}
</script>
</body>
</html>