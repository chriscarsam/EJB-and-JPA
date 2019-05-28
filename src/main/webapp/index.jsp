<!DOCTYPE html>

<html>
    <head>
        <meta charset="UTF-8">
        <title>In the web of SambCode</title>
        
        <link rel="stylesheet" href="resources/css/cssLayaut.css"  >
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
        	<label class="label">This is my label</label>
        	<input type="text" class="text" id="txt1">
        	<br>
        	<label class="label">This is my label</label>
        	<input type="password" class="password">
        	<br>
        	<label class="label">This is my label</label>
        	<textarea class="textArea"></textarea>
        	<br>
        	<label class="label">This is my label</label>
        	<select class="select">
        		<option>Item 1</option>
        	</select>
        	<label class="label">This is my label</label>
        	<table class="table">
	        	<thead>
	        	<tr>
	        		<th>Headboard 1</th>
	        		<th>Headboard 2</th>
	        		<th>Headboard 3</th>
	        	</tr>
	        	</thead>
	        	<tbody>
	        		<tr>
	        			<td>Item 1</td>
	        			<td>Item 2</td>
	        			<td>Item 3</td>
	        		</tr>
	        		<tr>
	        			<td>Item 1</td>
	        			<td>Item 2</td>
	        			<td>Item 3</td>
	        		</tr>
	        	</tbody>
        	</table>
        	<br>
        	<input type="button" class="button" value="Submit" onclick="test();">
        	<div id="divDialog">Dialog</div>
        </section>
    </body>
    <script type="text/javascript">
    	function test(){
        		alert($('#txt1').val());
        		$('#divDialog').dialog();
        	}
    </script>
</html>
