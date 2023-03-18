import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// This class represents User Interface that shows the Menus and interacts with user
public class UserInterface {
	
	Scanner sc = new Scanner(System.in);
	
	// Generalize Menu 
	int menu(String main, List<String> items,boolean flag)
	{
		int choice=0;
		
		System.out.println("***********************************************************");
		System.out.println("\t\t*****" + main + "*****");
		
		int counter=1;
		
		for(String i:items)
		{
			System.out.println(counter + " " + i);
			counter++;
		}
		
		System.out.print("\n Your Input: ");
		if(flag)
		{
			choice=sc.nextInt();
		}
		
		return choice; 
	}
	
	// Index Menu
	int indexMenu()
	{	
		List<String> items = new ArrayList<String>();
		
		items.add("Library Member");
		items.add("Library Employee");
		items.add("Exit");
		
		return menu("Index",items,true); 
	}
	// Login Menu that gets the Login ID
	String LoginMenu()
	{	
		List<String> items = new ArrayList<String>();
		
		items.add("Library Id");
		
		menu("Login Menu",items, false); 
		
		String id = sc.next();
		
		return id;
	}
	
	// Password Menu that gets the password
	String PasswordMenu()
	{	
		List<String> items = new ArrayList<String>();
		
		items.add("Library Password");
		
		menu("Login Menu",items, false); 
		
		String pass = sc.next();
		
		return pass;
	}
	
	// User menu that interacts with members 
	int userMenu()
	{
		List<String> items = new ArrayList<String>();
		
		items.add("Show Available Books");
		items.add("Show All Authors");
		items.add("Upgrade Membership");
		items.add("Downgrade Membership");
		items.add("Check Membership");
		items.add("Issue a Book");
		items.add("Return a Book");
		items.add("Show all Issued Book");
		items.add("Exit");
		
		int choice = menu("User Menu",items,true);
		
		if(choice == items.size())
		{	
			return -1;
		}
		
		return choice;
	}
	
	// Employee menu that interacts with Employee
	int employeeMenu()
	{
		List<String> items = new ArrayList<String>();
		
		items.add("Show Available Books");
		items.add("Show All Authors");
		items.add("Show All Members");
		
		
		items.add("Add Member");
		items.add("Delete Member");
		
		items.add("Add Employee");
		
		items.add("Add Book");
		items.add("Delete Book");
		
		items.add("Add Author");
		
		items.add("Exit");
		
		
		int choice = menu("Employee Menu",items,true);;
		
		if(choice == items.size())
		{	
			return -1;
		}
		
		return choice;
	}
	
	// Book Menu that shows the functionality of reserving and issuing book
	String bookMenu()
	{
		List<String> items = new ArrayList<String>();
		
		items.add("Book Name");
		
		menu("Reserve a Book",items,false);
		sc.nextLine();
		String bookName = sc.nextLine();
		
		return bookName;
	}
}
