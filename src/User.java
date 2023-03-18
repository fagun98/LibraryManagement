// This is base class to person with additional functionality of ID and Password
public abstract class User extends Person{
	String id;
	String password;
	
	public User(String name, String dOB, String phoneNumber, String emailID, String id, String password) {
		
		super(name, dOB, phoneNumber, emailID);
		this.id = id;
		this.password = password;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean comparePassword(String password)
	{
		if(password.equals(this.password))
		{
			return true;
		}
		
		return false;
	}
	
	void showAllAvailableBooks(Library library)
	{
		library.allAvailableBooks();
	}
	
	void showAllAuthors(Library library)
	{
		library.allAuthors();
	}
	
	public String getAllValues()
	{
		String allDetails; 
		
		allDetails = getName() + "," + getdOB()+ "," +getEmailID()+ "," +getPhoneNumber() + "," + getId() + "," + getPassword();

		return allDetails;
	}
	
	public boolean setAllValues(String data)
	{
		String[] allValues = data.split(",");
		
		setName(allValues[0]);
		setdOB(allValues[1]);
		setEmailID(allValues[2]);
		setPhoneNumber(allValues[3]);
		setId(allValues[4]);
		setPassword(allValues[5]);
		
		return true; 
	}
}
