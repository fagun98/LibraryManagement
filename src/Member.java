import java.util.HashMap;
import java.util.Scanner;

// Member have all the functionality of an User with Member functionality
public class Member extends User{
	
	// To store the membership of an user
	Membership membership;
	// Saves details of the book issued to an user
	HashMap<String,Book> issuedBooks = new HashMap<String,Book>();
	Scanner sc = new Scanner(System.in);
	
	// Constructor
	public Member(String name, String dOB, String phoneNumber, String emailID, String id, String password) {
		super(name, dOB, phoneNumber, emailID, id, password);
		// By default membership is standard
		membership = new StandardMembership();
	}
	
	// Function to upgrade membership to premium
	boolean upgradeMembership()
	{
		membership = new PremiumMembership();
		 
		return true;
	}
	
	// Function to downgrade membership to standard
	boolean downgradeMembership()
	{
		membership = new StandardMembership();
		
		return true;
	}
	
	// shows what is member current membership
	void checkMembership()
	{
		System.out.println("Premium Membership " + membership.isPremium());
		System.out.println("Maximum Days of Issuing: " + membership.returnDayLimit());
	}
	
	// Function that issue book to member
	boolean addIssuedBook(Book book)
	{
		System.out.print("Days of Issue: ");
		int Days = sc.nextInt();
		
		if(membership.returnDayLimit()>=Days)
		{
			issuedBooks.put(book.getBookName().toLowerCase(), book);
			return true;
		}
		
		return false;
	}
	
	// Checks if the book is been issued by this member or not
	boolean checkIssuedBook(String bookName)
	{
		bookName = bookName.toLowerCase();
		
		if(issuedBooks.containsKey(bookName))
		{
			return true;
		}
		
		return false;
	}
	
	// Returns an Issued book 
	boolean returnIssuedBook(String bookName)
	{
		bookName = bookName.toLowerCase();
		
		issuedBooks.remove(bookName);
		return true;
	}
	
	// Shows all the issued book to this member
	void showAllIssuedBook()
	{
		if(!issuedBooks.isEmpty())
		{
			for(Book book:issuedBooks.values())
			{
				book.getBookDetails();
			}
		}
		else
		{
			System.out.println("No Issued Book exist");
		}
	}
	
	// Checks if there is any book issued to member or not
	boolean issuedBookIsEmpty()
	{
		return issuedBooks.isEmpty();
	}
	
	// Represents all the issued book in string to save in file
	public String getAllBooks()
	{
		String allBooks = "#";
		
		for(Book i:issuedBooks.values())
		{
			allBooks = allBooks.concat(i.getBookName().concat(","));
		}
		
		if(allBooks.length()>1)
		{
			allBooks = allBooks.substring(0,allBooks.length() - 1);
		}
		return allBooks;
	}
	
	// Represents all the entity of member in string to save in file
	public String getAllValues()
	{
		String allDetails = getName() + "," + getdOB()+ "," +getEmailID()+ "," +getPhoneNumber() + "," + getId() + "," + getPassword() + "," + String.valueOf(membership.isPremium());; 
		
		String allBooks = getAllBooks();
		
		allDetails =  allDetails.concat(allBooks);
		
		return allDetails;
	}
	
	// Gets all the issued book in string to save in object
	public boolean setAllValues(String data, Library library)
	{
		String[] data2 =  data.split("#");
		String[] allValues = data2[0].split(",");
		
		setName(allValues[0]);
		setdOB(allValues[1]);
		setEmailID(allValues[2]);
		setPhoneNumber(allValues[3]);
		setId(allValues[4]);
		setPassword(allValues[5]);
		
		if(allValues[6].equals("true"))
		{
			upgradeMembership();
		}
				
		try
		{
			if(data2[1].contains(","))
			{	
				String[] allBooks = data2[1].split(",");
			
				for(String s:allBooks)
				{
					issuedBooks.put(s,library.bookList.get(s));
				}
			}
			else
			{
				issuedBooks.put(data2[1].toLowerCase(),library.getBook(data2[1]));
			}
			
		}
		catch(ArrayIndexOutOfBoundsException a)
		{
			//System.out.println("Hello I am here - Member");
		}
		
			
		return true; 
	}
}
