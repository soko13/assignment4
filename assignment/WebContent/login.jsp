<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assignment 4 - SQL injections</title>
<style type="text/css">
	body {font-family: Tahoma, sans-serif; padding: 40px 0;}
	.container {padding: 10px 16px;}
	form {border: 3px solid #f1f1f1; margin:auto; width:38%; padding: 12px; box-shadow: 0 0 15px;}
	input[type=text], input[type=password] {width:100%; padding: 12px 20px; margin: 8px 0; display: inline-block; box-sizing: border-box;}
	button {background-color:#05326D; 
	color:white; 
	padding:14px 20px; 
	margin: 5px 0; 
	border:none; 
	width: 100%;
	font-family: Tahoma, sans-serif;
	font-weight:bold;
	cursor:pointer;}
	button:hover {background-color:#4282D3;}
	.showdb, .filldb {background-color:#6997D3;color:white;width:40%;margin-top:3px;}
	.btm {font-size:13px; text-align: center; padding-top:8px; padding-bottom:5px; line-heigt:80%;}
</style>
<script type="text/javascript">
            function callUnsafeLoginServlet() {
                document.forms[0].action = "unsafelogin";
                document.forms[0].submit();
            }
            
            function callSafeLoginServlet() {
            	document.forms[0].action = "safelogin";
            	document.forms[0].submit();
            }
            
            function callFillDbServlet() {
            	document.forms[0].action = "filldatabase";
            	document.forms[0].submit();
            }
        </script>
</head>
<body>
<form method="post">
	<div class="container">
		<p style="font-weight: bold; text-align: center; font-size:20px;">Assignment 4 - SQL Injections</p>
    	<label for="username"><b>Username</b></label>
    	<input type="text" placeholder="Enter Username" name="username" required>

    	<label for="password"><b>Password</b></label>
    	<input type="text" placeholder="Enter Password" name="password" required>

    	<button type="submit" onclick="callUnsafeLoginServlet()" name="unsafelogin">Unsafe Login</button>
    	<button type="submit" onclick="callSafeLoginServlet()" name="safelogin">Safe Login</button>
    </div>
    
    <div class="container">
    	<button type="button" class="showdb">Show data</button>
    	<button type="button" class="filldb" style="float:right;" onclick="callFillDbServlet()">Fill database</button>
  	</div>
  	
  	<div class="container btm">
  	    	<p>VU Informationssicherheit SS 2021</p>
  	    	<p>Johannes Breit, Sofya Koliverda, Moritz Stöckl</p>
  	    	<img src="images/Uni_Logo_2016.gif" width="200px">
  	</div>
 </form>
</body>
</html>