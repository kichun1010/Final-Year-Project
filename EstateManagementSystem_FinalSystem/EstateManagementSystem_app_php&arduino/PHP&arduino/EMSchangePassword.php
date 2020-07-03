<?php
	$db = "fyp";
	$username = $_POST["username"];
	$password = $_POST["password"];
	$host = "localhost";
	
	$conn = mysqli_connect($host,"root","",$db);
	if($conn){
			$sql = "UPDATE `account` SET `password` = '$password' , firstTime = 'N' WHERE `account`.`username` = '$username';";
			$result = mysqli_query($conn,$sql);
			if(($result)){
				echo "Your password has changed successfully!!";
			}
			else{
				echo "The repeat password is not the same";
			}
	}
?>