import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	ServerSocket providerSocket;
	Socket connection = null;
	ObjectOutputStream out;
	ObjectInputStream in;
	String message;
	ServerThread s;
	List sharedResource;
	Server(){}
	void run()
	{
		try{
			//Creating a server socket
			providerSocket = new ServerSocket(2004, 10);
			sharedResource = new List();
			//Wait for connection
			while(true)
			{
				System.out.println("Waiting for connection");
				connection = providerSocket.accept();
				System.out.println("Connection received from " + connection.getInetAddress().getHostName());
				s = new ServerThread(connection, sharedResource);
				s.start();
			}
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
		finally{
			//Closing connection
			try{
				in.close();
				out.close();
				providerSocket.close();
			}
			catch(IOException ioException){
				ioException.printStackTrace();
			}
		}
	}//Run
	
	void sendMessage(String msg)
	{
		try{
			out.writeObject(msg);
			out.flush();
			System.out.println("server>" + msg);
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
	
	public static void main(String args[])
	{
		Server server = new Server();
		while(true){
			server.run();
		}
	}
	
}//Class
