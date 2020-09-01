<%@page import="com.gradschool.model.Application"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<%
	ArrayList<Application> apps = (ArrayList<Application>) request.getAttribute("list");

	double size = apps.size();
	double np = size / 5;
	double numberOfPages = Math.ceil(np);
	
	int counter = 0;
	for(int i = 0; i < numberOfPages; i++){
		
		out.print("<div name='myDiv' style='background-color:red; width:600px;'>");
		for(int j = 0; j < 5 ; j++){
			if(counter == size)break;
			out.print("<p>"+ apps.get(counter).getId() + "</p>" );
			counter++;
		}
		out.print("</div>");		
	}
	
	out.print("<button id='prev' onClick='prevPage()'> Prev </button>");
	out.print("<button  id='next' onClick='nextPage()'> Next </button>");
	
%>



<script>
	var myDivs = document.getElementsByName("myDiv");
	var currentPage = 0;
	
	window.onload = function(){
		for(var i = 1; i < myDivs.length; i++){
			myDivs[i].style.display = "none";
		}
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
	}

</script>

</body>
</html>