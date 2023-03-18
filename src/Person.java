// This is parent class that saves all the basic details of a person 
public abstract class Person {
	private String name;
	private String dOB;
	private String phoneNumber;
	private String emailID; 
	
	// Constructor
	public Person(String name, String dOB, String phoneNumber, String emailID) {
		super();
		this.name = name;
		this.dOB = dOB;
		this.phoneNumber = phoneNumber;
		this.emailID = emailID;
	}
	
	//Getter/Setter DOB
	public String getdOB() {
		return dOB;
	}

	//Getter/Setter DOB
	public void setdOB(String dOB) {
		this.dOB = dOB;
	}

	//Getter/Setter Phone Number
	public String getPhoneNumber() {
		return phoneNumber;
	}

	//Getter/Setter Phone Number
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	//Getter/Setter Email Id
	public String getEmailID() {
		return emailID;
	}

	//Getter/Setter Email Id
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	//Getter/Setter Name
	public String getName() {
		return name;
	}

	//Getter/Setter Name
	public void setName(String name) {
		this.name = name;
	}
	
	// Show all details
	public void showDetails()
	{
		System.out.print("\nName: " + name);
		System.out.print("\t\tDate of Birth: " + dOB);
		System.out.println("\t\tEmail : " + emailID);
	}
	
	// Represents all the entity in string to save in file
	public String getAllValues()
	{
		String allDetails; 
		
		allDetails = getName() + "," + getdOB()+ "," +getEmailID()+ "," +getPhoneNumber();
		
		return allDetails;
	}
	
	// Gets all the entity in string to save in Object
	public boolean setAllValues(String data)
	{
		String[] allValues = data.split(",");
		
		setName(allValues[0]);
		setdOB(allValues[1]);
		setEmailID(allValues[2]);
		setPhoneNumber(allValues[3]);
		
		return true; 
	}
}
