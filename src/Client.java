import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	Socket requestSocket;
	ObjectOutputStream out;
 	ObjectInputStream in;
 	String message;
 	Scanner input;
 	
 	Client()
 	{
 		input = new Scanner(System.in);
 	}
 	
 	void run() 
 	{
 		try 
 		{
 			//Create a socket to connect to the server
			requestSocket = new Socket("127.0.0.1", 2004);
			System.out.println("Connected to localhost in port 2004");
			//2. get Input and Output streams
			out = new ObjectOutputStream(requestSocket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(requestSocket.getInputStream());
 		
	 		//Communicating with server
	 		do 
	 		{
	 			/*user prompt...
	 			1 - User Registration
	 				Name, Email, Department(Employee id is generated automatically by the system)
	 			
	 			
	 			*/
	 		}while(message.equalsIgnoreCase("1"));
 		
 		}//try
 		
 		//catch (ClassNotFoundException e) {}
 		catch (UnknownHostException unknownHost) {
			System.err.println("You are trying to connect to an unknown host!");
		}
 		catch (IOException ioException) {
			ioException.printStackTrace();
		}
 	}//run
	
}
