<header>
	<nav class="menu">
		<ul>
			<li><a href="#">Start</a></li>
			<li><a href="#">Register data in the system</a></li>
			<li><a href="#">See registered data</a></li>

		</ul>
	</nav>
	<div id="divLogin">
		<b>User:</b>
		<%
			if(request.getSession().getAttribute("email")!=null){
				%>
				<%=request.getSession().getAttribute("email")%> |
				<a href="/appwebschedule-0.0.1-SNAPSHOT/ServletUserLogout">Sing off</a>				
				<%
			}else{
			%>
				<%="Anonymous"%>
			<%	
			}			
		%>
		
	</div>
</header>
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
