
public class User {

	private String name;
	private int employeeId;//unique - to do
	private String email;//unique - to do
	private String dept;
	
	public User(String name, int employeeId, String email, String dept) {
		super();
		this.name = name;
		this.employeeId = employeeId;
		this.email = email;
		this.dept = dept;
	}	
	
	public String getName() {
		return name;
	}

	public int getEmployeeId() {
		
		return employeeId;
	}

	public String getEmail() {
		return email;
	}

	public String getDept() {
		return dept;
	}
	
	
		
}
