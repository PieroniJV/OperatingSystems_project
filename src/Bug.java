
public class Bug {
	
	enum Platform{
		WINDOWS,
		UNIX,
		MAC;
	}
	
	private String appName;
	private String dateNTime;
	Platform platform;
	private String description;
	private char status;
	
	public Bug(String appName, String dateNTime, Bug.Platform platform, String description, char status) {
		super();
		this.appName = appName;
		this.dateNTime = dateNTime;
		this.platform = platform;
		this.description = description;
		this.status = status;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}

	public String getAppName() {
		return appName;
	}

	public String getDateNTime() {
		return dateNTime;
	}

	public Platform getPlatform() {
		return platform;
	}

	public String getDescription() {
		return description;
	}
	
	
	
}
