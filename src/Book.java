
public class Book {

	// Name of the book 
	private String bookName;
	// This represents if book is issued or not
	private boolean available; 
	// Saves author of the book 
	private Author author;
	
	// Constructor
	public Book(String bookName, Author author) {
		super();
		this.bookName = bookName;
		this.author = author;
		this.available = true;
	}

	// Getter/Setter for BookName 
	public String getBookName() {
		return bookName;
	}

	// Getter/Setter for BookName 
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	// Getter/Setter for availability 
	public boolean isAvailable() {
		return available;
	}

	// Getter/Setter for availability
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	// shows the details of the book
	public void getBookDetails()
	{
		System.out.print("\nBook Name: " + bookName );
		System.out.println("\t\tBook Author: " + author.getName());
	}
	
	// Represents every element in string to save in a file
	public String getAllValues()
	{
		String allDetails = getBookName()+ "," + String.valueOf(isAvailable()) + "," + author.getName();
		return allDetails;
	}
	
	// Get every element in string to save in a object
	public boolean setAllValues(String data, Library library)
	{
		String[] allValues = data.split(",");
		
		setBookName(allValues[0]);
		setAvailable(allValues[1].equals("true"));	
		author = library.getAuthor(allValues[2]);
		
		return true; 
	}
}
