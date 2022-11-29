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

	Client() {
		input = new Scanner(System.in);
	}

	void run() {
		try {
			// Create a socket to connect to the server
			requestSocket = new Socket("127.0.0.1", 2004);
			System.out.println("Connected to localhost in port 2004");
			// Get Input and Output streams
			out = new ObjectOutputStream(requestSocket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(requestSocket.getInputStream());

			// Communicating with server
			do {
				/*
				 * user prompt... 1 - Ask for login or register(1 or 2) If successful, then menu
				 * is prompted
				 *
				 * Login checks file for information already stored
				 * 
				 * User Registration Name, Email, Department(Employee id is generated
				 * automatically by the system)
				 * 
				 * 
				 */
				// Prompt for Login or Registration
				message = (String) in.readObject();
				System.out.println(message);
				message = input.nextLine();
				sendMessage(message);
				// If user enters 1 for login
				if (message.equalsIgnoreCase("1")) {
					// Enter Employee ID
					message = (String) in.readObject();
					System.out.println(message);
					message = input.nextLine();
					sendMessage(message);

					// Enter Email
					message = (String) in.readObject();
					System.out.println(message);
					message = input.nextLine();
					sendMessage(message);
				}
				// If user enters 2 for Registration
				else if (message.equalsIgnoreCase("2")) {
					// Enter name
					message = (String) in.readObject();
					System.out.println(message);
					message = input.nextLine();
					sendMessage(message);
					// Enter Email
					message = (String) in.readObject();
					System.out.println(message);
					message = input.nextLine();
					sendMessage(message);
					// Enter Department
					message = (String) in.readObject();
					System.out.println(message);
					message = input.nextLine();
					sendMessage(message);

				}

				// Continue using application?
				message = (String) in.readObject();
				System.out.println(message);
				message = input.nextLine();
				sendMessage(message);

			} while (message.equalsIgnoreCase("1"));

		} // try

		// catch (ClassNotFoundException e) {}
		catch (UnknownHostException unknownHost) {
			System.err.println("You are trying to connect to an unknown host!");
		} catch (IOException ioException) {
			ioException.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		} finally {
			// Closing connection
			try {
				in.close();
				out.close();
				requestSocket.close();
			} catch (IOException ioException) {
				ioException.printStackTrace();
			}
		} // finally
	}// run

	void sendMessage(String msg) {
		try {
			out.writeObject(msg);
			out.flush();
			System.out.println("client>" + msg);
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}// sendMessage

	public static void main(String args[]) {
		Client client = new Client();
		client.run();
	}

}// Class
