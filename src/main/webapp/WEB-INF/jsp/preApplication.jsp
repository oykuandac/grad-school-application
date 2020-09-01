<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Pre Application Form</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="/css/preapp .css">
<link rel="stylesheet" type="text/css" href="/css/index.css">

</head>
<body>
<div class="header">
    <div class="header-section-1">
        <div class="site-logo">
            <a href="/index" class="header-logo">
    <img src = "https://en.iyte.edu.tr/wp-content/themes/IYTE/assets/img/logo-white-full-v-en.png"  style="width: 
              80%;"/>
  </a>
        </div>
    </div>

</div>

<div class="topnav" id="myTopnav">
  <a href="/index" class="active">Home</a>
  <a href="/news">Announcements</a>
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
<br>
<div class="container" >
  <h1 style="text-align: center">Pre Application Form</h1>
  <form action="/preApplication"  method="POST" id="form"  > 
            <div class="col">  
            <input type="text" id="name" name="name" placeholder="Name" th:field="*{name}">
            <br><br>
            <input type="text" id="gender" name="gender" placeholder="Gender" th:field="*{gender}">
            <br><br>
            <input type="text" id="number" name="number" placeholder="number"  th:field="*{number}">
            <br><br>
          </div>

          <div class="col">  
            <input type="text" id="surname" name="surName" placeholder="Surname" th:field="*{sur_name}">
            <br><br>
            <input type="date" id="date" name="birthDate" placeholder="BirthDate" th:field="*{birth_date}">
            <br><br>
            <input type="text" id="nationality" name="nationality" placeholder="Nationality">
            <br><br>
          </div>
          
          <div>
            <label for="citizen" id="citizen"> </label>
              <select style="visibility: hidden;">
              </select>
              <br><br>
           <label for="citizen" id="citizen">Are you citizen of Repuclic of Turkey?</label>

              <select name = "citizen">
                <option value="yes">Yes</option>
                <option value="no">No</option>
              </select>
                         <br><br>

           <label for="working" id="work">Are you working?</label>

              <select name ="working">
                <option value="yes">Yes</option>
                <option value="no">No</option>
              </select><br><br>

           <label for="degree"id="degree">Which degree to Apply?</label>

              <select name = "degree"">
                <option value="phd">PhD</option>
                <option value="master">Masters</option>
                <option value="pmaster">PhD Without Masters</option>
              </select><br><br>
              </div>
            <input type="text" id="tcno" name="tcno" placeholder="TC No/Passport No" th:field="*{tcno}">
            <br><br>
            <input type="text" id="address" name="address" placeholder="address"  th:field="*{address}">
            <br><br>
            <input type="text" id="university" name="university" placeholder="university"  th:field="*{university}">
            <br><br>
            
            <label for="dept"id="dept">Which department to Apply?</label>

              <select name = "dept">
                <option value="Computer Engineering">Computer Engineering</option>
                <option value="Physics">Physics</option>
                <option value="Machine Engineering">Machine Engineering</option>
              </select><br><br>
            <br><br>
            <input type="text" id="gpa" name="gpa" placeholder="GPA" th:field="*{gpa}">
            <br><br>
            <input type="text" id="ales" name="ales" placeholder="ALES Result">
            <br><br>           
                
            <input type = "submit" value = "Save Changes"  id="sbmt" style="background-color:#91080F">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
  
  
  </form>
</div>
<br>
  
  
</div>
   <script type="text/javascript" src="js/registerAndLoginFunctions.js"></script>
  
</body>

</html>