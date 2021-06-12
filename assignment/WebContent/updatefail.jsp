<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="net.assignment.database.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Assignment 4 - SQL injection</title>
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
</head>
<body>
<form action="login.jsp">
    <div class="container" method="post">
    	<p style="font-size:25px; text-align:center; font-weight:bold;">Database update failed! Please try again.</p>
    	<button type="submit" class="backtologin">Go back to login</button>
  	
  	<div class="btm">
  	    	<p>VU Informationssicherheit SS 2021</p>
  	    	<p>Johannes Breit, Sofya Koliverda, Moritz Stöckl</p>
  	    	<img src="images/Uni_Logo_2016.gif" width="200px">
  	</div>
  	  	</div>
 </form>
</body>
</html>