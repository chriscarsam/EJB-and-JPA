<!DOCTYPE html>

<%@page import="com.sambcode.app.entity.Tuser"%>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>In the web of SambCode</title>
              
        <link rel="stylesheet" href="resources/css/cssComponent.css"  >  
        <link rel="stylesheet" href="resources/css/jquery-ui.min.css"  >
        <style type="text/css">
        .divAlertCorrect{
			background-color: blue;
			color: white;
			margin: 4px;
			padding: 7px;
		}
		
		.divAlertError{
			background-color: red;
			color: white;
			margin: 4px;
			padding: 7px;
		}
        </style> 
        
        <script src="resources/js/jquery-3.4.1.min.js"></script>
        <script src="resources/js/jquery-ui.min.js"></script>
             
    </head>
    
    <body>
    
<%
	if (request.getAttribute("correct") != null && request.getAttribute("correct").equals("Yes")) {
%>
<div class="divAlertCorrect"><%=request.getAttribute("generalMessage")%></div>
<%
	}
	if (request.getAttribute("correct") != null && request.getAttribute("correct").equals("No")) {
%>
<div class="divAlertError"><%=request.getAttribute("generalMessage")%></div>
<%
	}
%>
	      
        <section>
                  
        	<form id="frmLogin" action="/appwebschedule-0.0.1-SNAPSHOT/ServletUserLogin" method="post">
        		<h2>Log in</h2>
        		<label for="txtEmail" class="label">Email</label>
        		<input type="text" id="txtEmail" name="txtEmail" class="text" >
        		<br>        		
        		<label for="passPassword" class="label">Password</label>
	        	<input type="password" id="passPassword" name="passPassword" class="password">
	        	<br>	        	    		        		
        		<input type="submit" value="Enter" class="button" >
        	</form>
        </section>
        
    </body>    
</html>
