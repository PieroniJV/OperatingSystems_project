import java.util.Iterator;
import java.io.*;
import java.util.LinkedList;

public class List {
	private LinkedList<Bug> bugList;
	private LinkedList<User> userList;
	private File usersFile = new File("users.txt");
	//private File bugsFile = new File("bugs.txt");To do
	
	public List() 
	{
		bugList = new LinkedList<Bug>();
		userList = new LinkedList<User>();
		//User user1 = new User("John", "John@atu.ie", "Developer");//default user for testing
		//User user2 = new User("Max", "Max@atu.ie", "Tester");//default user for testing
		//userList.add(user1);
		//userList.add(user2);
	}
	
	//Adding new bugs or users to the lists
	public synchronized void addBug(String appName, String dateNTime, Bug.Platform platform, String description, char status) 
	{
		Bug temp = new Bug(appName, dateNTime, platform, description, status);
		bugList.add(temp);
	}
	public synchronized void addUser(String name, String email, String dept) 
	{
		int tempNum = userList.size() + 1;
		User temp = new User(name, tempNum, email, dept);
		userList.add(temp);
		System.out.println(getUserList());//for testing
		writeToFile(getUserList(), usersFile);
	}
	
	//Return lists
	public synchronized String getBugList() 
	{
		Iterator<Bug> iter = bugList.iterator();
		Bug temp;
		String list = "";
		while (iter.hasNext()) 
		{
			temp = iter.next();
			list = list + "Name of Application: "+ temp.getAppName() + "\nDate-Time: " + temp.getDateNTime() + "\nPlatform: " + temp.getPlatform() + "\nDescription: " + temp.getDescription() + "\nStatus: " + temp.getStatus() + "\n";
		}
		
		return list;
	}
	
	public synchronized String getUserList() 
	{
		Iterator<User> iter = userList.iterator();
		User temp;
		String list = "";
		while (iter.hasNext()) 
		{
			temp = iter.next();
			list = list + "Name: "+ temp.getName() + "\nEmployee ID: " + temp.getEmployeeId() + "\nEmail: " + temp.getEmail() + "\nDepartment: " + temp.getDept() + "\n";
		}
		
		return list;
	}
	
	public synchronized Boolean checkUser(int id) 
	{
		Boolean isIdValid = false;
		User temp;
		Iterator<User> iter = userList.iterator();
		while(iter.hasNext()) 
		{
			temp = iter.next();
			if (temp.getEmployeeId() == id) {
				isIdValid = true;
			}
		}		
		
		return isIdValid;
	}
	
	public void writeToFile(String text, File f) 
	{
		String message;
		try {
			 
            // Create a FileWriter object to write in the file
            FileWriter fWriter = new FileWriter(f);
 
            // Writing into file
            // Note: The content taken above inside the
            // string
            fWriter.write(text);
 
            // Printing the contents of a file
            System.out.println(text);
 
            // Closing the file writing connection
            fWriter.close();
 
            // Display message for successful execution of
            // program on the console            
            message =  "File is created successfully with the content.";
        }
 
        // Catch block to handle if exception occurs
        catch (IOException e) {
 
            // Print the exception
            message = e.getMessage();
        }
		System.out.println(message);	
	}
	
}
