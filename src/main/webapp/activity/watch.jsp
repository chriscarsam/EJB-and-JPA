<%@page import="com.sambcode.app.jb.JbActivity"%>
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
    <jsp:useBean id="listActivity" class="java.util.ArrayList<com.sambcode.app.jb.JbActivity>" scope="request"></jsp:useBean>
        <%@include file="/partial/header.jsp"%>
        <section>
        <div>
        	<a href="/appwebschedule-0.0.1-SNAPSHOT/ServletActivityGetByUser">All the activities</a>
        	-
        	<a href="/appwebschedule-0.0.1-SNAPSHOT/ServletActivityGetByUserAndState?state=true">Completed activities</a>
        	-
        	<a href="/appwebschedule-0.0.1-SNAPSHOT/ServletActivityGetByUserAndState?state=false">Pending activities</a>
        	-
        	<a href="/appwebschedule-0.0.1-SNAPSHOT/ServletActivityGenerateReport" target="_blank">Generate Report</a>
        </div>
        	<table class="table">
        		<thead>
        			<tr>
        				<th>First Name</th>
        				<th>Description</th>
        				<th>Place</th>
        				<th>State</th>
        				<th>Start date</th>
        				<th>End date</th>
        				<th>Registration date</th>
        				<th></th>
        			</tr>
        		</thead>
        		<tbody>
        			<c:forEach items="${listActivity}" var="item">
        				<tr>
        					<td>${item.getFirstName()}</td>
        					<td>${item.getDescription()}</td>
        					<td>${item.getPlace()}</td>
        					<td>${item.isState() ? "Finalized" : "Pending"}</td>
        					<td>${item.getFirstName()}</td>
        					<td>${item.getDateStartTime()}</td>
        					<td>${item.getEndTimeDate()}</td>
        					<td>${item.getRegistrationDate()}</td>
        					<td>
        					<c:if test="${item.isState()==false}">
        						<input type="button" value="End activity" onclick="endActivity(${item.getIdActivity()});">
        					</c:if>
        					<c:if test="${item.isState()==true}">
        						<input type="button" value="Restore activity" onclick="restoreActivity(${item.getIdActivity()});">
        					</c:if>        						        						
        					</td>
        				</tr>
        			</c:forEach>
        		</tbody>
        	</table>      	
        </section>
    </body>  
    <script>
		function endActivity(idActivity){
				window.location.href='/appwebschedule-0.0.1-SNAPSHOT/ServletActivityChangeStatus?idActivity='+idActivity+'&state=true';
			}
		function restoreActivity(idActivity){
			window.location.href='/appwebschedule-0.0.1-SNAPSHOT/ServletActivityChangeStatus?idActivity='+idActivity+'&state=false';
		}
    </script>  
</html>
