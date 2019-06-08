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
        
        <section>
        	
        	<%
        		Tuser user = (Tuser)request.getAttribute("user");
        	%>
        	<%@include file="/partial/header.jsp"%>
        
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
        		<label for="radioChangePassword" class="label">Change password</label>
        		<label for="radioChangePasswordYes">Yes</label>
        		<input type="radio" id="radioChangePasswordYes" name="radioChangePassword" value="Yes" onchange="onChangeRadioChangePassword()" >
        		<label for="radioChangePasswordNo">No</label>
        		<input type="radio" id="radioChangePasswordNo" name="radioChangePassword" value="No" checked="checked" onchange="onChangeRadioChangePassword()">
        		<br>
        		<div id="divChangePassword" style="display: none;">
	        		<label for="passOldPassword" class="label">Previous password</label>
	        		<input type="password" id="passOldPassword" name="passOldPassword" class="password">
	        		<br>
	        		<label for="passNewPassword" class="label">New password</label>
	        		<input type="password" id="passNewPassword" name="passNewPassword" class="password">
	        		<br>
	        		<label for="passRepeatNewPassword" class="label">Repeat the new password</label>
	        		<input type="password" id="passRepeatNewPassword" name="passRepeatNewPassword" class="password">
        			<br>
        		</div>        		        		
        		<input type="button" value="Save data" class="button" onclick="submitFrmEditUser();">
        	</form>
        </section>
        <script>
        	function onChangeRadioChangePassword(){
					if($('input[name=radioChangePassword]:checked').val()=='Yes')
						{
							$('#divChangePassword').show();
						}
					else
						{
							$('#divChangePassword').hide();
							$('#passOldPassword').val('');
							$('#passNewPassword').val('');
							$('#passRepeatNewPassword').val('');
						}
            	}
        	
        	function submitFrmEditUser(){
            	
					if($('#passNewPassword').val()===$('#passRepeatNewPassword').val()){
							return $('#frmEditUser').submit();
						}

					alert('Passwords do not match');
            	}
        </script>
    </body>    
</html>
