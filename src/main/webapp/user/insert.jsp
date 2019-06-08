<!DOCTYPE html>

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
        <%@include file="/partial/header.jsp"%>
        <section>
        	
        
        	<form id="frmInsertUser" action="/appwebschedule-0.0.1-SNAPSHOT/ServletUserInsert" method="post">
        		<h2>Register in the system</h2>
        		<label for="txtFirstName" class="label">First name</label>
        		<input type="text" id="txtFirstName" name="txtFirstName" class="text" value="<%=(request.getAttribute("correct")!=null && request.getAttribute("correct").equals("No")) ? request.getParameter("txtFirstName") : ""%>">
        		<br>
        		<label for="txtLastName" class="label">Last name</label>
        		<input type="text" id="txtLastName" name="txtLastName" class="text" value="<%=(request.getAttribute("correct")!=null && request.getAttribute("correct").equals("No")) ? request.getParameter("txtLastName") : ""%>">
        		<br>
        		<label for="dateBirthdate" class="label">Date of birth</label>
        		<input type="date" id="dateBirthdate" name="dateBirthdate" class="text" value="<%=(request.getAttribute("correct")!=null && request.getAttribute("correct").equals("No")) ? request.getParameter("dateBirthdate") : ""%>">
        		<br>
        		<label for="txtEmail" class="label">Email</label>
        		<input type="text" id="txtEmail" name="txtEmail" class="text" value="<%=(request.getAttribute("correct")!=null && request.getAttribute("correct").equals("No")) ? request.getParameter("txtEmail") : ""%>">
        		<br>
        		<label for="passPassword" class="label">Password</label>
        		<input type="password" id="passPassword" name="passPassword" class="password">
        		<br>
        		<label for="passPasswordRepeat" class="label">Repeat password</label>
        		<input type="password" id="passPasswordRepeat" name="passPasswordRepeat" class="password">
        		<br>
        		
        		<input type="submit" value="Register" class="button">
        	</form>
        </section>
    </body>    
</html>
