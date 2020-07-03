
 import processing.serial.*;
 Serial port;

          void setup()  {
                          port  =  new Serial (this, "COM5",  9600); // Set the com port and the baud rate according to the Arduino IDE
                         /* This part must be altered to fit your local settings. The number in brackets after "Serial.list()" is where you declare what COM port your Arduino is connected to.
                          If you get error messages, try a different number starting from 0 (e.g. 0, 1, 2, 3...) . */
                         // port = new Serial(this, Serial.list()[0], 115200);  // Open the port that the Arduino board is connected to, at 9600 baud
 
                          port.bufferUntil ( '\n' );   // Receiving the data from the Arduino IDE
                        } 
 
   void draw() {
  
              String onoroff[] = loadStrings("http://192.168.1.101/test/LEDInput.txt"); // Insert the location of your .txt file
              print(onoroff[0]);  // Prints whatever is in the file ("1" or "0")
           
              if (onoroff[0].equals("1") == true) {
              println(" - SIGNALS THE ARDUINO TO TURN LED ON");
 
              port.write ( '1' ) ;       // send a '1' to the Arduino IDE
 
              } else  {
 
                      println(" - SIGNALS THE ARDUINO TO TURN LED OFF");
                      port.write('0');  // Send "L" over serial to set LED to LOW
                     
                      }
 
              delay(100); // Set your desired interval here, in milliseconds
               }
