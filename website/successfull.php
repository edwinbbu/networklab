<?php 
require "init.php";

$username=$_POST["username"];
$password=$_POST["password"];

$name=$_POST["name"];
$age=$_POST["age"];
$email=$_POST["email"];
$mobile=$_POST["mobile"];
$gender=$_POST["gender"];
$address=$_POST["address"];
$tenth=$_POST["tenth"];
$tweth=$_POST["tweth"];
$department=$_POST["department"];

$sql="insert into login values('$username','$password');";
mysqli_query($con,$sql);
$sql2="insert into registration values('$username','$name',$age,'$email',$mobile,'$gender','$address',$tenth,$tweth,'$department');";
mysqli_query($con,$sql2);
mysqli_close($con);

?>
<html>
<head>
<title>Registration Page</title>
<link rel="stylesheet" type="text/css" href="common.css">
</head>
<body>
<h2>Registration successfull</h2>
<a href="login.php">Back to login page</a>
</body>
</html>
