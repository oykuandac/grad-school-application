<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Page Title</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="index.css">
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

  <div class="dropdown">
    <button class="dropbtn" style="margin-right: 100px;"> 
      <i class="fa fa-user" ></i>
    </button>
    <div class="dropdown-content" >
      <form action="logout" method="post" id="logoutform">
		<input style="width: 100%; padding: 12px 16px; background-color: #424242; color: white;" type="submit" value="Logout"/>
		<input type="hidden" name="${_csrf.parameterName}" value= "${_csrf.token}"/>
		<h3 id="sa"></h3>
    </div>
  </div> 

  <a href="javascript:void(0);" style="font-size:15px;" class="icon" onclick="myFunction()">&#9776;</a>
</div>


<div >
	<form action="application/add" method="post" id="addApp">
		 <button style="width: 30%; height:50px; margin-left: 35%;margin-top: 5%;background-color:#91080F; color: white;">Go to Pre-Application Form!</button>
	  </form>

</div>



<br>
<script>



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