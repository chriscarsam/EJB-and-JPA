<!DOCTYPE html>

<%@page import="com.sambcode.app.entity.Tuser"%>
<html lang="es">
    <head>
        <meta charset="UTF-8">
        <title>In the web of SambCode</title>
        
        <link rel="stylesheet" href="resources/css/cssLayout.css"  >
        <link rel="stylesheet" href="resources/css/cssComponent.css"  >  
        <link rel="stylesheet" href="resources/css/jquery-ui.min.css"  > 
        
        <script src="resources/js/jquery-3.4.1.min.js"></script>
        <script src="resources/js/jquery-ui.min.js"></script>
             
    </head>
    
    <body>
        <header>
        <nav class="menu">
        	<ul>
        		<li><a href="#">Start</a></li>
        		<li><a href="#">Register data in the system</a></li>
        		<li><a href="#">See registered data</a></li>
        		
        	</ul>
        </nav>        
        </header>
        <section>
        	<%
        		if(request.getAttribute("correct")!=null && request.getAttribute("correct").equals("Yes"))
        		{
        			%>
        			<div class="divAlertCorrect"><%=request.getAttribute("generalMessage") %></div>
        			<%
        		}
        	    if(request.getAttribute("correct")!=null && request.getAttribute("correct").equals("No"))
        		{
        			%>
        			<div class="divAlertError"><%=request.getAttribute("generalMessage") %></div>
        			<%
        		}
        	%>
        	<%
        		Tuser user = (Tuser)request.getAttribute("user");
        	%>
        
        	<form id="frmEditUser" action="/appwebschedule-0.0.1-SNAPSHOT/ServletUserEdit" method="post">
        		<h2>My personal information</h2>
        		<label for="txtFirstName" class="label">First name</label>
        		<input type="text" id="txtFirstName" name="txtFirstName" class="text" value="<%=user.getFirstName()%>">
        		<br>
        		<label for="txtLastName" class="label">Last name</label>
        		<input type="text" id="txtLastName" name="txtLastName" class="text" value="<%=user.getLastName()%>">
        		<br>
        		<label for="dateBirthdate" class="label">Date of birth</label>
        		<input type="date" id="dateBirthdate" name="dateBirthdate" class="text" value="<%=user.getBirthdate()%>">
        		<br>
        		<label for="txtEmail" class="label">Email</label>
        		<input type="text" id="txtEmail" name="txtEmail" class="text" value="<%=user.getEmail()%>">
        		<br>        		        		
        		<input type="submit" value="Save data" class="button">
        	</form>
        </section>
    </body>    
</html>
