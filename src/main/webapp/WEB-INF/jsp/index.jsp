<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="/css/index.css">
</head>
<title>Home</title>
<body>
<div class="header">
    <div class="header-section-1">
        <div class="site-logo">
            <a href="/index" class="header-logo">
     <img src = "https://en.iyte.edu.tr/wp-content/themes/IYTE/assets/img/logo-white-full-v-en.png" style="width: 80%;">
  </a>
        </div>
    </div>

</div>
</div>
<div class="topnav" id="myTopnav" >
  <a href="/index" class="active">Home</a>
  <a href="/news">Announcements</a>
  <div class="dropdown">
    <button class="dropbtn" style="margin-right: 100px;"> 
      <i class="fa fa-user"></i>
    </button>
    <div class="dropdown-content">
      <button id="login" value="Login" onclick="goLogin();">Login</button>
      <button type="button" value="Register" id="register" onclick="goRegister();">Create Account</button>
            
      <form action="logout" method="post" id="logoutform">
		<input style="width: 100%; padding: 12px 16px; background-color: #424242; color: white;" type="submit" value="Logout"/>
		<input type="hidden" name="${_csrf.parameterName}" value= "${_csrf.token}"/>
		<input id="sa" style="width: 100%; padding: 12px 16px; background-color: #424242; color: white;" type="button" onclick="window.location.href = '/account' " />
	  </form>
    </div>
  </div> 
    <a href="javascript:void(0);" style="font-size:15px;" class="icon" onclick="myFunction()">&#9776;</a>

</div>


<img src="http://aday.iyte.edu.tr/wp-content/uploads/2015/06/doga-ile-icice-2.jpg" style="width:100%; height: 360px;">



<div >

 <h1 style="margin-left: 40%;">General Information</h1>
    <h3 style="margin-left: 34%;">Application Requirements for Turkish Citizen Students:</h3>
      <ul style="margin-left: 34%;">
        <li>Transcript</li>
        <li>ALES Result</li>
        <li>Reference Letters</li>
        <li>Statement of Purpose</li>
        <li>Photo</li>
        <li>Certificate for English level</li>
        <li>Interview or entrance exam – Varies according to department</li>
      </ul>
    <h3 style="margin-left: 35%">*For international students, passport copy is necessary.</h3>
    <h3 style="margin-left: 35%;">*Permission letter is necessary if you are working.</h3>
    <input type = "submit"  value="APPLY NOW" onclick="goPreApp();" id="sbmt" style="width: 30%; height:50px; margin-left: 35%;background-color:#91080F; color: white;">
<br><br>
</div>

<div class="footer" style="text-align: center; background-color: gray;">
        <div class="col">
            <br>
                    <h4>IZTECH The Graduate School of Engineering & Sciences</h4>
                    <p><span class="icon-location"></span>  IZTECH Administrative Building 1st floor 35430 Urla / İzmir</p>
                    <p><span class="icon-phone"></span> +90 232 750 6350</p>
                    <p><span class="icon-mail"></span> <a href="mailto:muhfenbe@iyte.edu.tr">muhfenbe@iyte.edu.tr</a></p>
        </div>
        <div class="col">
            
                <div>
                    © Copyright İzmir Institute of Technology - 2020               
                </div>
            
        </div>
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
	    function goPreApp(){
	        window.open("/application","_self");
	    }
        function goRegister(){
            window.open("/register","_self");
        }

        function goLogin(){
            window.open("/login","_self");    
        }   
        
			console.log("${username}"=="");
        	if("${username}" == ""){
        		document.getElementById('logoutform').style.display = 'none';
        	}else{
        		//document.getElementById('login').style.visibility = 'hidden';
        		//document.getElementById('register').style.visibility = 'hidden';
        		document.getElementById('sa').value = "${username}";
        		
        		document.getElementById("login").style.display="none";
        		document.getElementById("register").style.display="none";

        		
        	}
        	
</script>
</body>
</html>