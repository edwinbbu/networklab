<?php
session_start();
?>
<html>
<head>
<title>Homepage</title>
<link rel="stylesheet" type="text/css" href="common.css">
</head>
<body>
<?php
if(isset($_SESSION['login']))
    {
    	$user=$_SESSION['login'];
    	echo "<h2>Welcome $user</h2>";
    	require "init.php";
    	$sql="select * from registration where username='$user';";
    	$result=mysqli_query($con,$sql);
    	if(!$result)
		{
			die("Error in connection " . mysqli_connect_error());
		}
		else	
		{
			while($row = mysqli_fetch_array($result,MYSQLI_ASSOC))
	        {

	        	echo "<b>Name: ".$row['name']."<br>Age: ".$row['age']."<br>Gender: ".$row['gender']."<br>Email: ".$row['email']."<br>Mobile: ".$row['mobile']."<br>Address: ".$row['address']."</b>";
	        }
		}
	}
?>
</body>
</html>