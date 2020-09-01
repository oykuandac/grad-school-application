<%@page import="com.gradschool.model.Announcement"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" type="text/css" href="/css/index.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="text-align:center;">
<div class="header">
    <div class="header-section-1" >
        <div class="site-logo" >
            <a href="index" class="header-logo" >
              <img src = "https://en.iyte.edu.tr/wp-content/themes/IYTE/assets/img/logo-white-full-v-en.png" style="width: 
              80%;">
           </a>
        </div>
    </div>
</div>


<%

ArrayList<Announcement> anns = (ArrayList<Announcement>)request.getAttribute("list");
	for(Announcement announcement: anns){
	out.print("<div style='background-color:grey;'>");		
		out.print("<h1>"+announcement.getTitle()+"</h1>");
		out.print("<p>"+announcement.getText()+"</p>");
	out.print("</div>");
	}

%>




</body>
</html>