<%@page import="com.gradschool.model.Application"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
  <link rel="stylesheet" href="/css/login.css">
  <link rel="stylesheet" href="/css/index.css">  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/applicationList.css">
</head>

<body>


<div class="header">
    <div class="header-section-1">
        <div class="site-logo">
            <a href="index" class="header-logo">
    <img src = "https://en.iyte.edu.tr/wp-content/themes/IYTE/assets/img/logo-white-full-v-en.png"/>
  </a>
        </div>
    </div>

    <div class="header-section-2">
        <p>Grad School Application</p>
    </div>
</div>


<div class="container" >

<%
	ArrayList<Application> apps = (ArrayList<Application>) request.getAttribute("list");

	double size = apps.size();
	double np = size / 5;
	double numberOfPages = Math.ceil(np);
	int counter = 0;
	for(int i = 0; i < numberOfPages; i++){
		
		out.print("<div name='myDiv' style='background-color:red; width:600px;margin-left:30%;'>");
		for(int j = 0; j < 5 ; j++){
			if(counter == size)break;
			long id = apps.get(counter).getId();
			String fileId = apps.get(counter).getFile().getId();
			String divBegin = "<div id = '" + id + "'>"; 
			out.print(divBegin+ id + "  " + apps.get(counter).getUser().getName());
			
			out.print("<button class='collapsible'> Check </button>");
			out.print("<div class='content'>"
					+"<form action=\"/downloadFile/"+fileId+"\" method=\"GET\" id='form'>"
						+"<button  type='submit'> download app file </button>"
					+"</form>"				
					+"<div style='text-align:center;'>Confirm</div>"
					+"<input type='radio' name='isConfirm' id='confirm"+id+"' /> "
					+"<div style='text-align:center;'>Reject</div>"
					+"<input type='radio' name='isConfirm' id='reject"+id+"' /> "
					+"<button  onclick='deneme("+id+")'>Save</button>"
				+ "</div>");

			out.print("</div>");		
			counter++;
		}
		out.print("</div>");		
	}
	
	out.print("<button id='prev' onClick='prevPage()' style='width:200px; margin-left:30%;'> Prev </button>");
	
	out.print("<button  id='next' onClick='nextPage()'style='width:200px; margin-left:35px;' > Next </button>");

%>
<div  id="currentPage" style='display:inline;'>Current Page is: 0  </div>

</div>

<script>
	var myDivs = document.getElementsByName("myDiv");
	var currentPage = 0;
	
	window.onload = function(){
		for(var i = 1; i < myDivs.length; i++){
			myDivs[i].style.display = "none";
		}
	}
	
	function deneme(id){
		var check = document.getElementById("confirm"+id);
		var check1 = document.getElementById("reject"+id);

		if(check.checked == false  && check1.checked== false){
			console.log("select at least one")
		}
		else if(check.checked == true){
			setIsConfirmed(id,true)
		}
		else{
			setIsConfirmed(id,false)
		}
	}
	function setIsConfirmed(id,isConfirm) {
		  var xmlHttp = new XMLHttpRequest();
		  xmlHttp.open( "GET","/application/"+id+"/"+isConfirm, false ); // false for synchronous request
		  xmlHttp.send();
	}
	function prevPage(){
		if(currentPage != 0){
			currentPage--;
		}
		loadCurrentPage();
	}
	
	function nextPage(){
		if(currentPage != myDivs.length - 1){
			currentPage++;
		}
		loadCurrentPage();
	}
	
	function loadCurrentPage(){
		for(var i = 0; i < myDivs.length; i++){
			if(i == currentPage){
				myDivs[i].style.display="block";
			}
			else{
				myDivs[i].style.display = "none";
			}			
		}
		document.getElementById('currentPage').innerHTML = "Current Page is: "+currentPage;
	}
	
	var coll = document.getElementsByClassName("collapsible");
	var i;

	for (i = 0; i < coll.length; i++) {
	  coll[i].addEventListener("click", function() {
	    this.classList.toggle("active");
	    var content = this.nextElementSibling;
	    if (content.style.maxHeight){
	      content.style.maxHeight = null;
	    } else {
	      content.style.maxHeight = content.scrollHeight + "px";
	    } 
	  });
	}
	
</script>
   <script type="text/javascript" src="js/applicationList.js"></script>


</body>
</html>