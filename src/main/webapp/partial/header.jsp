<header>
	<nav class="menu">
		<ul>
			<li><a href="/appwebschedule-0.0.1-SNAPSHOT/ServletActivityInsert">Insert Activities</a></li>
			<li><a href="/appwebschedule-0.0.1-SNAPSHOT/ServletActivityGetByUser">See Activities</a></li>			
			<li><a href="/appwebschedule-0.0.1-SNAPSHOT/ServletUserInsert">Insert User</a></li>
			<li><a href="/appwebschedule-0.0.1-SNAPSHOT/ServletUserEdit">Edit User</a></li>
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
