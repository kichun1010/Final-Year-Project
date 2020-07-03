<?php
		$db = "fyp";
	
	$host = "localhost";
	$username = $_POST['username'];
	$password = $_POST['password'];	
	//$username = $_POST["username"];
	//$password = $_POST["password"];
	
	$conn = mysqli_connect($host,"root","",$db);
	if($conn){
			$q = "Select * from account where username = '$username' and password = '$password'";
			$result = mysqli_query($conn,$q);
			$rs = mysqli_fetch_assoc($result);
			if(mysqli_num_rows($result)>0){
				
				if($rs['firstTime']=='Y'){
					echo "Welcome to Estate Management System! Please change your password first.";
				}else{
					echo "Welcome to Estate Management System!";
				}
			}
			else
				echo "Your username or password is incorrect, please try again!";
	}
?>