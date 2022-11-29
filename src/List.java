import java.util.Iterator;
import java.util.LinkedList;

public class List {
	private LinkedList<Bug> bugList;
	private LinkedList<User> userList;
	
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
	public synchronized void addUser(String name,int tempNum, String email, String dept) 
	{
		tempNum = userList.size() + 1;
		User temp = new User(name, tempNum, email, dept);
		userList.add(temp);
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
	
}
