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
		$row = mysqli_fetch_array($result);
		if($row[0]<40){
			$sql = "INSERT INTO `booking` (`username`, `Type`, `Date`, `Period`, `Status`) VALUES ('$username', '$type', '$date', '$time', 'Paid')";
			mysqli_query($conn,$sql) or die(mysqli_error($conn));
			$q = "Select * from booking where username = '$username' and type = '$type' and date = '$date' and period = '$time' and status = 'Paid'";
			$result = mysqli_query($conn,$q);
			if(mysqli_num_rows($result)>0){
				echo "Booking Successful";
			}else{
				echo "Booking failed...!";
			}
		}else{
			echo "This period has been full booking, please select another one";
			
		}
	}
?>