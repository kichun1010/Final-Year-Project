<?php
	$db = "fyp";
	
	$host = "localhost";
	$username = $_POST["username"];
	
	$conn = mysqli_connect($host,"root","",$db);
	if($conn){
			$q = "Select * from booking where username = '$username'";
			$result = mysqli_query($conn,$q);
			if(mysqli_num_rows($result)>0){
				while($rc = mysqli_fetch_assoc($result)){
					$data[] = $rc;
				}
				
				print(json_encode($data));
			}
	}
?>