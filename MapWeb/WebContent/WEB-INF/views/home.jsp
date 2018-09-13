<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="CSS/result.css">
	<title>Route Planner</title>
</head>
<body>
	<div id=header><h1>FINAL DESTINATION.......</h1></div><br>
	<!-- <div class=header>FINAL DESTINATION</div> -->
		<div id=left>
			<form class=station name="route" action="RoutePlanning" method="post">
				<p>START</p><input type="text" name="startpos" value=""><br/>
				<p>END</p><input type="text" name="endpos" value=""><br/>
				<input id=submit type="submit" value="GO!">
			</form>
		</div>
</body>
</html>