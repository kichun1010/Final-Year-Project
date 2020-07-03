<?php
	
	//include 'PhpSerial.php';  //under testing 
	//$serial = new PhpSerial;  //under testing 
	//$serial->deviceSet("COM28");under testing (this blinks the led twice and switch off from the PHP code direct)
	//echo "<p>Control Page</p><p>";
	//$port = fopen("COM28","w+"); 
	
		$status = $_POST["status"];   // Input request from index.html as a variable for On/Off buttons On=1 off=0
		if($status == "O")
			$onoroff = 1;
		else
			$onoroff = 0;
		$textfile = "LEDInput.txt";  // Name and location of the text file 
 
		$fileLocation = "$textfile"; // I used Wampserver www/myphpprogram location (you may select your folder location based on Xamp or wamp
		$fh = fopen($fileLocation, 'w') or die("Something went wrong!"); // Opens up the .txt file for writing and replaces any previous content
		$stringToWrite = "$onoroff"; // Input written to textfile 1 or 0 depending on request from index.html On/Off click event
		fwrite($fh, $stringToWrite); // Writes it to the text file 
		fclose($fh); 
		if($onoroff == 1)
			echo "The door has been opened";
		else
			echo "The door has been closed"

	?>