<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        	
        
        	<form id="frmInsertActivity" action="/appwebschedule-0.0.1-SNAPSHOT/ServletActivityInsert" method="post">
        		<h2>Register Activity</h2>
        		<label for="txtFirstName" class="label">First name</label>
        		<input type="text" id="txtFirstName" name="txtFirstName" class="text" value="<%=(request.getAttribute("correct")!=null && request.getAttribute("correct").equals("No")) ? request.getParameter("txtFirstName") : ""%>">
        		<br>
        		<label for="txtDescription" class="label">Description</label>
        		<textarea id="txtDescription" name="txtDescription" class="textArea"></textarea>
        		<br>
        		<label for="txtPlace" class="label">Place</label>
        		<input type="text" id="txtPlace" name="txtPlace" class="text" value="<%=(request.getAttribute("correct")!=null && request.getAttribute("correct").equals("No")) ? request.getParameter("txtPlace") : ""%>">
        		<br>
        		<label for="dateStartDate" class="label">Start date</label>
        		<input type="date" id="dateStartDate" name="dateStartDate" class="text" value="<%=(request.getAttribute("correct")!=null && request.getAttribute("correct").equals("No")) ? request.getParameter("dateStartDate") : ""%>">
        		<select id="selectHourStart" class="selectTime">
        			<option value="">Hour</option>
        			<c:forEach var="i" begin="0" end="23">
        				<option value="${i}">${i}</option>
        			</c:forEach>
        		</select>
        		<select id="selectMinuteStart" class="selectTime">
        			<option value="">Minute</option>
        			<c:forEach var="i" begin="0" end="59">
        				<option value="${i}">${i}</option>
        			</c:forEach>
        		</select>        		
        		<br>
        		<label for="dateFinishDate" class="label">Finish date</label>
        		<input type="date" id="dateFinishDate" name="dateFinishDate" class="text" value="<%=(request.getAttribute("correct")!=null && request.getAttribute("correct").equals("No")) ? request.getParameter("dateFinishDate") : ""%>">
        		<select id="selectHourEnd" class="selectTime">
        			<option value="">Hour</option>
        			<c:forEach var="i" begin="0" end="23">
        				<option value="${i}">${i}</option>
        			</c:forEach>
        		</select>
        		<select id="selectMinuteEnd" class="selectTime">
        			<option value="">Minute</option>
        			<c:forEach var="i" begin="0" end="59">
        				<option value="${i}">${i}</option>
        			</c:forEach>
        		</select>    
        		<br>        		
        		<input type="submit" value="Register" class="button">
        	</form>
        </section>
    </body>    
</html>
