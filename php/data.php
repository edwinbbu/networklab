<html>
<body>
<?php
$xml=simplexml_load_file("students.xml") or die("Error: Cannot create object");
$i=0;
echo "<b>Input Details:</b></br>";
foreach ($xml->children() as $student) {
	$names[$i]=$student->name;
	echo $names[$i]." ";
	$company[$i]=$student->company;
	echo $company[$i]." ";
	$marks[$i]=intval($student->totmarks);
	echo $marks[$i]."<br>";
	$i++;
}
echo "<br><b>Rank-list:</b><br>";
rsort($marks);
foreach ($marks as $item) {
//	echo "$item</br>";
	foreach ($xml->children() as $student) {
		$cmark=intval($student->totmarks);
		if($cmark==$item)
		{
			echo $student->name."<br>";
		}
	}

}
echo "<br><b>Students placed</b></br>";
foreach($xml->children() as $student)
{
	$comp=$student->company;
	if($comp!="none")
	{
		echo $student->name."<br>";
	}
}
$topper=null;
$max=$xml->student->totmarks;
foreach($xml->children() as $student)
{
	$t=intval($student->totmarks);
	if($t>$max)
	{
		$max=$t;
		$topper=$student->name;
	}
}
echo "</br><b>Topper:$topper</b></br>";

?>
</body>
</html>