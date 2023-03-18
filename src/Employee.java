
// Employee has all the functionality of user with employee functionality
public class Employee extends User{

	public Employee(String name, String dOB, String phoneNumber, String emailID, String id, String password) {
		super(name, dOB, phoneNumber, emailID, id, password);
	}
	
	// Shows all member exist
	void showAllMembers(Library library)
	{
		library.allMembers();
	}
	
	//  Add a new member
	void addMember(Library library)
	{
		library.addMember();
	}
	
	// Remove an existing member
	void removeMember(Library library)
	{
		library.removeMember();
	}
	
	// Add a new Employee
	void addEmployee(Library library)
	{
		library.addEmployee();
	}
	
	// Add a new book
	void addBook(Library library)
	{
		library.addBookWithDetails();
	}
	
	// Remove a Book
	void removeBook(Library library)
	{
		library.removeBook();
	}
	
	// Add a new author
	void addAuthor(Library library)
	{
		library.addAuthorWithDetails();
	}
}
