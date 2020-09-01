<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Page Title</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="/css/createaccount.css">
<link rel="stylesheet" type="text/css" href="/css/index.css">

</head>
<body style="background-color:#f4f4f4;">
<div class="header">
    <div class="header-section-1">
        <div class="site-logo">
            <a href="/index" class="header-logo">
    <img src = "https://en.iyte.edu.tr/wp-content/themes/IYTE/assets/img/logo-white-full-v-en.png"  style="width:  80%;"/>          
  </a>
        </div>
    </div>

    <div class="header-section-2">
    </div>
</div>

  
  
</div>

<div class="topnav" id="myTopnav">
  <a href="/index" class="active">Home</a>
  <a href="/news">Announcements</a>
  <div class="dropdown">
    <button class="dropbtn" style="margin-right: 100px;"> 
      <i class="fa fa-user"></i>
    </button>
    <div class="dropdown-content">
      <button onclick="window.location.href = 'login';">Login</button>
      <button onclick="window.location.href = 'createaccount';">Create Account</button>
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

<div class="container" >
  <form action="/register"  method="POST" id="form" > 
    <input type="text" id="name" name="name" placeholder="Name" required>
    <input type="text" id="surname" name="surname" placeholder="Surname" required>
    <input type="email" id="e_mail" name="email" placeholder="Email" required>
    <input type="password" id ="password"name="password" placeholder="Password" required>
    <input type="password"  name="re_password" id="re_password" placeholder="Re-Enter Password" style="width: 30%; margin-left:35%;margin-right:50%;">
    <input type = "button" value = "Submit" onclick="check()" id="sbmt" style="background-color:#91080F; color:white;" >
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  </form>
  <p id="message1" style="width: 30%; margin-left:35%;margin-right:50%;text-align:center;color:red;"></p>
  <p id="message2" style="width: 30%; margin-left:35%;margin-right:50%;text-align:center;color:red;"></p>
  <p id="message3" style="width: 30%; margin-left:35%;margin-right:50%;text-align:center;color:red;"></p>
  <p id="message4" style="width: 30%; margin-left:35%;margin-right:50%;text-align:center;color:red;"></p>
  <p id="message5" style="width: 30%; margin-left:35%;margin-right:50%;text-align:center;color:red;"></p>
  <p id="message6" style="width: 30%; margin-left:35%;margin-right:50%;text-align:center;color:red;"> </p>
</div>

   <script type="text/javascript" src="js/registerAndLoginFunctions.js"></script>
	
	<script>
	

	
		function checkName(){
			var name = document.getElementById("name").value;

			if(name.length == 0){
				document.getElementById("message1").innerHTML = "***Name Cannot Be Empty!";
				return false;
			}
			document.getElementById("message1").innerHTML = "";
			return true;
		}
		
		function checkSurname(){
			var surname = document.getElementById("surname").value;
			if(surname.length == 0){
				document.getElementById("message2").innerHTML = "***Surname Cannot Be Empty!";
				return false;
			}
			document.getElementById("message2").innerHTML = "";
			return true;			
		}
		
        function validateEmail() {
        	var email = document.getElementById("e_mail").value;
            const re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
       		
            if(re.test(String(email).toLowerCase())){   
            	document.getElementById("message3").innerHTML = "";
            	return true;                }
            else{
            	document.getElementById("message3").innerHTML = "***Wrong Email Format!";
            	return false;
            }
        }
        
		function rePassword(){
			var password = document.getElementById("password").value;
			var re_password = document.getElementById("re_password").value;
			if(password == re_password){
				document.getElementById("message6").innerHTML ="";
				return true;
			}
			else{
				document.getElementById("message6").innerHTML="***Passwords don't match!";
				return false;
			}
		}
        
        function checkPassword() 
        { 
        	var password = document.getElementById("password").value;

        	if(password.length == 0){
        		document.getElementById("message4").innerHTML = "***Password Cannot Be Empty!";
        		return false;
        	}
        	else if(password.length < 6){
        		document.getElementById("message4").innerHTML = "***Password Must Be Bigger Than Length 5 or equal!";
        		return false
        	}
        	else{
        		document.getElementById("message4").innerHTML = "";
        		return true;
        	}
          }  
        
        function check(){
        	var re = rePassword();
        	var name = checkName();
        	var surname = checkSurname();
        	var email = validateEmail();
        	var password = checkPassword();
        	if(name && surname && email && password && re){
        		var sbmt = document.getElementById("form");
        		sbmt.submit();
        	}
        }
        

        
        
        
		
			document.getElementById("message5").innerHTML = "${message}";
		
			console.log("${message}")
	
	</script>




</body>
</html>