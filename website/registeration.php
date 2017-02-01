<html>
<head>
<title>Login Page</title>
<link rel="stylesheet" type="text/css" href="common.css">
</head>
<body>
<h2>Registration Page</h2>
<form name="form" action="successfull.php" method="POST">
<table>
<tr><td>Name:</td><td><input type="text" name="name" required /></td></tr>
<tr><td>Age:</td><td><input type="number" name="age" required /></td></tr>
<tr><td>Gender:</td><td><input type="radio" name="gender" value="Male"/>Male</td><td><input type="radio" name="gender" value="Female"/>Female</td></tr>
<tr><td>Mobile:</td><td><input type="number" name="mobile"/></td></tr>
<tr><td>Email:</td><td><input type="email" name="email"/></td></tr>
<tr><td>Address:</td><td><textarea name="address" rows="4" cols="22"></textarea></td></tr>
<tr><td>Create Username:</td><td><input type="text" name="username" required /></td></tr>
<tr><td>Create password:</td><td><input type="password" name="password" required /></td></tr>
<tr><td>Enter 10th percentage:</td><td><input type="number" name="tenth" required /></td></tr>
<tr><td>Enter 12th percentage:</td><td><input type="number" name="tweth" required /></td></tr>
<tr><td>Select Department:</td><td><select name="department"><option>CS</option><option>IT</option><option>EC</option><option>EE</option><option>CE</option><option>ME</option></option></option></select></td></tr>
<tr><td></td><td><input type="submit" name="submit" value="Submit"/>&ensp;<input type="reset" name="reset" value="Reset"/></td></tr>
</table>
</form>
</body>
</html>