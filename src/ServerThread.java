import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

//Project
public class ServerThread extends Thread {
	private Socket socket;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private String message;
	private List lib;

	public ServerThread(Socket s, List l) {
		socket = s;
		lib = l;
	}

	public void run() {
		// Get input and output streams
		try {
			out = new ObjectOutputStream(socket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Conversation between server and client
		try {
			do {
				sendMessage("Press 1 to Login or 2 to Register");
				message = (String) in.readObject();

				if (message.equalsIgnoreCase("1")) {
					sendMessage("Please enter ID: ");
					message = (String) in.readObject();
					sendMessage(message);

					sendMessage("Please enter Email: ");
					message = (String) in.readObject();
					sendMessage(message);

					// Check if credentials are correct....
					// lib.addBook(message, message2);
					// return boolean...
				} else if (message.equalsIgnoreCase("2")) {
					String tempName, tempEmail, tempDpt;
					
					sendMessage("Please enter name: ");
					message = (String) in.readObject();
					sendMessage(message);
					tempName = message;

					sendMessage("Please enter Email: ");
					message = (String) in.readObject();
					sendMessage(message);
					tempEmail = message;
					// CheckEmail(tempEmail) **To do**

					sendMessage("Please enter Department: ");
					message = (String) in.readObject();
					sendMessage(message);
					tempDpt = message;
					
					lib.addUser(tempName, tempEmail, tempDpt);

				}

				sendMessage("Please enter 1 to repeat or 2 to exit");
				message = (String) in.readObject();
				sendMessage(message);

			} while (message.equalsIgnoreCase("1"));
		} // Try
		catch (IOException e) {

		} catch (ClassNotFoundException e) {

		}

	}// Run

	public void sendMessage(String msg) {
		try {
			out.writeObject(msg);
			out.flush();
			System.out.println("server>" + msg);
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
	}// SendMessage

}// Class
