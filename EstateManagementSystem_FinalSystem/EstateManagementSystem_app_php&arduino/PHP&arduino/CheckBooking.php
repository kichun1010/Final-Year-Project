<?php
	$db = "fyp";
	$username = $_POST["username"];
	$type = $_POST["type"];
	$date = $_POST["date"];
	$time = $_POST["time"];
	$host = "localhost";
	
	$conn = mysqli_connect($host,"root","",$db);
	if($conn){
		$q = "Select count(*) AS num from booking where type = '$type' and date = '$date' and period = '$time' and status = 'Paid'";
		$result = mysqli_query($conn,$q);
			if($result['num']>=40){
				return "false";
			}else{
				return "true";
			}
		}
?>