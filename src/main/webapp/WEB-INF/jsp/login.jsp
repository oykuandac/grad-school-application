<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="/css/login.css">
  <link rel="stylesheet" href="/css/index.css">
  
</head>


<body>
	</head>
<body>
<div class="header">
    <div class="header-section-1">
        <div class="site-logo">
            <a href="/index" class="header-logo">
    <img src = "https://en.iyte.edu.tr/wp-content/themes/IYTE/assets/img/logo-white-full-v-en.png"/>
  </a>
        </div>
    </div>

<div class="header-section-2">
    </div>
</div>

<div class="topnav" id="myTopnav">
  <a href="/index" >Home</a>
  <a href="/news">News</a>
  <div class="dropdown">
    <button class="dropbtn" style="margin-right: 100px;"> 
      <i class="fa fa-user"></i>
    </button>
    <div class="dropdown-content">
      <button onclick="window.location.href = '/login';">Login</button>
      <button onclick="window.location.href = '/register';">Create Account</button>
    </div>
  </div> 
  <a href="javascript:void(0);" style="font-size:15px;" class="icon" onclick="myFunction()">&#9776;</a>
</div>

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
<div class="container" style="height: 100%;">
<h1 style="text-align: center;">Login</h1>
  <form action="/login"  method="POST" id="form"> 
    <input type="text" id="e_mail" name="username" id="e_mail" placeholder="Email" required style="width: 30%; margin-left:35%;margin-right:50%;">
    <input type="password" id="password" name="password" id="password" placeholder="Password" style="width: 30%; margin-left:35%;margin-right:50%;">
    <input type = "button" value = "Login" onclick="checkBoth();" id="sbmt" style="width: 30%;color: white;background-color:#91080F">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

        <p id="message" style="width: 30%; margin-left:35%;margin-right:50%;text-align:center;color:red;"></p>
        <p id="message2" style="width: 30%; margin-left:35%;margin-right:50%;text-align:center;color:red;"> </p>
  </form>
  <form action="/signin/facebook" method="POST">
    <input type="hidden" name="scope" value="public_profile" />
    <input  type="submit" value="Login using Facebook" style="width: 30%;background-color:#073CE3"/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>  
  </form>

</div>

<div class="footer">
</div>



   <script type="text/javascript" src="js/registerAndLoginFunctions.js"></script>

    <script type="text/javascript"> 
            function goRegister(){
                window.open("/register","_self");
            }
            
            
            
            function validateEmail() {
            	var email = document.getElementById("e_mail").value;
                const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
           		
                if(re.test(String(email).toLowerCase())){   
                	document.getElementById("message").innerHTML = "";
                	return true;                }
                else{
                	document.getElementById("message").innerHTML = "***Wrong Email Format!";
                	return false;
                }
            }
            
            function checkPassword() 
            { 
            	var password = document.getElementById("password").value;

            	if(password.length == 0){
            		document.getElementById("message2").innerHTML = "***Password Cannot Be Empty!";
            		return false;
            	}
            	else{
            		document.getElementById("message2").innerHTML = "";
            		return true;
            	}
	          }  
            
             
            function checkBoth(){
            	var em = validateEmail();
            	var pas = checkPassword();
            	if(em && pas == true){
            		console.log("a");
            		var sbmt = document.getElementById("form");
            		sbmt.submit();
            	}
            }
            
            
    </script>


</body>

</html>