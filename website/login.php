<?php
session_start();
require "init.php";

if(isset($_POST["username"]))
{
  $username=$_POST["username"];
  
}
if(isset($_POST["password"]))
{
  $password=$_POST["password"];
}

$sql="select username,passwrd from login;";
$result=mysqli_query($con,$sql);
if(!$result)
{
	echo "Error in connection";
}
else
{
	$obj=mysqli_fetch_object($result);
	$user=$obj->username;
	$pass=$obj->passwrd;
}

if($user==$username && $pass==$password)
{
	$_SESSION['login']=$username;
	header("Location:welcome.php");
	mysqli_close($con);
	exit();
}
?>
<html>
<head>
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="common.css">
</head>
<body>
<h2>College Login</h2>
<form name="form" action="<?php echo $_SERVER['PHP_SELF']?>" method="POST">
<table>
<tr><td>Username:</td><td><input type="text" name="username" required /></td></tr>
<tr><td>Password:</td><td><input type="password" name="password" required /></td></tr>
<tr><td></td><td><input type="submit" name="submit" value="Submit"/></td></tr>
<tr><td><a href="registeration.php">New Registration</a></td></tr>
</table>
</form>
</body>
</html>