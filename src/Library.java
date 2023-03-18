import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

// Library class that contains details of member, employee, author and books
public class Library {
	
	// Immutable Name
	final String libraryName;
	
	// Hash Map to save the Member and retrieve using Member ID
	final HashMap<String,Member> memberList = new HashMap<String,Member>();
	// Hash Map to save the Employee and retrieve using Employee ID
	final HashMap<String,Employee> employeeList = new HashMap<String,Employee>();
	// Hash Map to save the Author and retrieve using Author Name
	final HashMap<String,Author> authorList = new HashMap<String,Author>();
	// Hash Map to save the Book and retrieve using Book Name
	final HashMap<String,Book> bookList = new HashMap<String,Book>();
	
	Scanner sc = new Scanner(System.in);
	
	// Constructor 
	public Library() {
		this.libraryName = "University";
		
		readAuthor();
		readBook();
		readEmployee();
		readMember();
				
	}
	
	//Functions that saves details of every element
	public void savePoint()  
	{  
		saveAuthor();
		saveBook();
		saveEmployee();
		saveMember();
		
		System.out.println("Data saved Successfully");
	} 
	
	// Function that calls and saves details of all Author
	
	public void readAuthor()
	{
		try {
		      File myObj = new File("libraryData/author.txt");
		      Scanner myReader = new Scanner(myObj);
		      
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        Author author = new Author(null, null, null, null);
		        author.setAllValues(data);
		        addAuthor(author);
		      }
		      myReader.close();
		    }
		
		catch (FileNotFoundException e)
		    {
		    }
	}
	
	public void readBook()
	{
		try {
		      File myObj = new File("libraryData/book.txt");
		      Scanner myReader = new Scanner(myObj);
		      
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        Book book = new Book(null, null);
		        book.setAllValues(data, this);
		        addBook(book);
		      }
		      myReader.close();
		    }
		
		catch (FileNotFoundException e)
		    {
		    }
	}
	
	public void readMember()
	{
		try {
		      File myObj = new File("libraryData/member.txt");
		      Scanner myReader = new Scanner(myObj);
		      
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        Member member = new Member(null, null, null, null, null, null);
		        member.setAllValues(data, this);
		        memberList.put(member.getId(),member);
		      }
		      myReader.close();
		    }
		
		catch (FileNotFoundException e)
		    {
		    }
	}
	
	public void readEmployee()
	{
		try {
		      File myObj = new File("libraryData/employee.txt");
		      Scanner myReader = new Scanner(myObj);
		      
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        Employee emp = new Employee(null, null, null, null, null, null);
		        emp.setAllValues(data);
		        employeeList.put(emp.getId(), emp);
		      }
		      myReader.close();
		    }
		
		catch (FileNotFoundException e)
		    {
		    }
	}
	
	public void saveAuthor()
	{
		try {
			
			File myFile = new File("libraryData/author.txt");
		    
			if(!myFile.exists())
		    {
		    	myFile.createNewFile();
		    }
		
		    FileWriter file = new FileWriter("libraryData/author.txt");
		   
		    int counter = authorList.size()-1;
		    
		    for(Author author:authorList.values())
		    {
		    	file.write(author.getAllValues());
		    	if(counter>0)
		    	{
		    		file.write("\n");
		    	}
		    	counter--;
		    	
		    }
		    
		    file.close();
		    
		   } 
		catch (IOException e) 
		   {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		   }
		
	}
	// Function that calls and saves details of all Book
	
	public void saveBook()
	{
		try {
			
			File myFile = new File("libraryData/book.txt");
		    
			if(!myFile.exists())
		    {
		    	myFile.createNewFile();
		    }
		
		    FileWriter file = new FileWriter("libraryData/book.txt");
		   
		    int counter = bookList.size()-1;
		    
		    for(Book book:bookList.values())
		    {
		    	file.write(book.getAllValues());
		    	if(counter>0)
		    	{
		    		file.write("\n");
		    	}
		    	counter--;
		    	
		    }
		    
		    file.close();
		    
		   } 
		catch (IOException e) 
		   {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		   }
		
	}
	
	// Function that calls and saves details of all Members
	
	public void saveMember()
	{
		try {
			
			File myFile = new File("libraryData/member.txt");
		    
			if(!myFile.exists())
		    {
		    	myFile.createNewFile();
		    }
		
		    FileWriter file = new FileWriter("libraryData/member.txt");
		   
		    int counter = memberList.size()-1;
		    
		    for(Member member:memberList.values())
		    {
		    	file.write(member.getAllValues());
		    	if(counter>0)
		    	{
		    		file.write("\n");
		    	}
		    	counter--;
		    	
		    }
		    
		    file.close();
		    
		   } 
		catch (IOException e) 
		   {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		   }
		
	}
	
	
	// Function that calls and saves details of all Employee
	public void saveEmployee()
	{
		try {
			
			File myFile = new File("libraryData/employee.txt");
		    
			if(!myFile.exists())
		    {
		    	myFile.createNewFile();
		    }
		
		    FileWriter file = new FileWriter("libraryData/employee.txt");
		   
		    int counter = employeeList.size()-1;
		    
		    for(Employee emp:employeeList.values())
		    {
		    	file.write(emp.getAllValues());
		    	if(counter>0)
		    	{
		    		file.write("\n");
		    	}
		    	counter--;
		    	
		    }
		    
		    file.close();
		    
		   } 
		catch (IOException e) 
		   {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		   }
		
	}
	
	// Function that add a new Members
	public void addMember()
	{
		System.out.print("Name: ");
		String name = sc.nextLine();
		
		System.out.print("Date of Birth: ");
		String dOB = sc.nextLine();
		
		System.out.print("Phone Number: ");
		String phNumber = sc.nextLine();
		
		System.out.print("Email Id: ");
		String emailId = sc.nextLine();
		
		System.out.print("User Id: ");
		String uId = sc.nextLine();
		
		System.out.print("Password: ");
		String pass = sc.nextLine();
		
		Member member = new Member(name, dOB, phNumber, emailId, uId, pass);
		
		memberList.put(uId, member);
	}
	// Function that add a new employee
	public void addEmployee()
	{
		sc.nextLine();
		System.out.print("Name: ");
		String name = sc.nextLine();
		
		System.out.print("Date of Birth: ");
		String dOB = sc.nextLine();
		
		System.out.print("Phone Number: ");
		String phNumber = sc.nextLine();
		
		System.out.print("Email Id: ");
		String emailId = sc.nextLine();
		
		System.out.print("Employee Id: ");
		String eId = sc.nextLine();
		
		System.out.print("Password: ");
		String pass = sc.nextLine();
		
		Employee emp = new Employee(name, dOB, phNumber, emailId, eId, pass);
		
		employeeList.put(eId, emp);
	}
	
	// Function that removes member
	public boolean removeMember()
	{
		System.out.print("Enter User Id to be removed: ");
		String id = sc.next();
		
		if(memberList.containsKey(id))
		{
			Member member = memberList.get(id);
			if(!member.issuedBookIsEmpty())
			{
				System.out.println("Cannot Delete User with Issued Book more than 0");
				return false;
			}
			memberList.remove(id);
			return true;
		}
		
		System.out.println("No such member exist");
		return false;
	}
	
	// Function that shows all Member present
	public void allMembers()
	{
		for(Member member:memberList.values())
		{
			member.showDetails();
		}
	}
	
	// Function that add Author to author list
	public boolean addAuthor(Author author)
	{
		String authorName = author.getName().toLowerCase();
		
		if(!authorList.containsKey(authorName))
		{
			authorList.put(authorName, author);
		}
		
		return true;
	}
	
	// Function that checks if the author is present using authorName
	public boolean checkAuthor(String authorName)
	{
		authorName = authorName.toLowerCase();
		
		if(authorList.containsKey(authorName))
		{
			return true;
		}
		
		return false;
	}
	
	// Function that returns author using author name if present in the list
	public Author getAuthor(String authorName)
	{
		authorName = authorName.toLowerCase();
		return authorList.get(authorName);
	}
	
	// Function the adds new author
	public boolean addAuthorWithDetails()
	{
		System.out.print("Name: ");
		String name = sc.nextLine();
		
		System.out.print("Date of Birth: ");
		String dOB = sc.nextLine();
		
		System.out.print("Phone Number: ");
		String phNumber = sc.nextLine();
		
		System.out.print("Email Id: ");
		String emailId = sc.nextLine();
		
		Author author = new Author(name, dOB, phNumber, emailId);
		
		addAuthor(author);
		
		return true;
	}
	
	// Function that adds new book
	public boolean addBookWithDetails()
	{
		System.out.print("Book Name: ");
		String bookName = sc.nextLine();
		
		System.out.print("Enter Author Name: ");
		String AuthorName = sc.nextLine();
		
		if(!checkAuthor(AuthorName))
		{
			System.out.println("Author Doesnt Exist");
			System.out.println("Unable to add book");
			
			return false;
		}
		
		Author author = getAuthor(AuthorName);	
		Book book = new Book(bookName, author);
		
		addBook(book);
		
		return true;
	}
	
	// Function that adds book using book object
	public boolean addBook(Book book)
	{
		String bookName = book.getBookName().toLowerCase();
		
		if(!bookList.containsKey(bookName))
		{
			bookList.put(bookName, book);
			return true;
		}
		
		System.out.println("Already Exist");
		
		return false;
	}
	
	// Function that check if the book exist using bookname or not
	public boolean checkBook(String bookName)
	{
		bookName = bookName.toLowerCase();
		
		return bookList.containsKey(bookName);
	}
	
	// Function returns a book if exist using book name
	public Book getBook(String bookName)
	{
		bookName = bookName.toLowerCase();
		
		return bookList.get(bookName);
	}
	
	// Function that removes books
	public boolean removeBook()
	{
		sc.nextLine();
		System.out.print("Enter Book Name: ");
		String bookName = sc.nextLine();
		
		if(checkBook(bookName))
		{
			bookName = bookName.toLowerCase();
			Book book = bookList.get(bookName);
			
			if(!book.isAvailable())
			{
				System.out.println("Cannot Delete an Issued Book");
				return false;
			}
				
			bookList.remove(bookName);
			return true;
		}
		
		System.out.println("Book Doesnt Exist");
		return false;
	}
	
	// Function that set availability of a book 
	public boolean setBookAvailability(String bookName, boolean status)
	{
		bookName = bookName.toLowerCase();
		
		bookList.get(bookName).setAvailable(status);
		
		return true;
	}
	
	// Function showing all the book that exist and not issued
	public void allAvailableBooks()
	{
		if(!bookList.isEmpty())
		{
			for(Book book:bookList.values())
			{
				if(book.isAvailable())
				{
					book.getBookDetails();
				}
			}
		}
		else
		{
			System.out.println("No available book");
		}
	}
	
	// Function that shows all author present
	public void allAuthors()
	{	
		if(!authorList.isEmpty())
		{
			for(Author author:authorList.values())
			{
				author.showDetails();
			}
		}
		else
		{
			System.out.println("No author exist");
		}
	}
	
	
	// Main function
	public static void main(String args[])
	{
		Library library = new Library();
		
		UserInterface ui = new UserInterface();
		
		int choice=0;
		
		while(choice<=2)
		{
			choice = ui.indexMenu();
			switch(choice)
			{
				case 1:
				{
					String id = ui.LoginMenu();
					
					if(library.memberList.containsKey(id))
					{
						Member member= library.memberList.get(id);
						String pass = ui.PasswordMenu();
						
						if(member.comparePassword(pass))
						{
							int userChoice=1;
							while(userChoice>0)
							{
								userChoice = ui.userMenu();
								
								switch(userChoice)
								{
									case 1: member.showAllAvailableBooks(library);break;
									case 2: member.showAllAuthors(library);break;
									case 3: {
										if(member.upgradeMembership())
										{
											System.out.println("Your membership has been upgraded Sucessfully");
										}
									}break;
									
									case 4: 
										{ 
											if(member.downgradeMembership())
											{
												System.out.println("Your membership has been downgraded Sucessfully");
											}
										}break;
									case 5: member.checkMembership();break;
									
									case 6: 
										 {
											String bookname = ui.bookMenu();
											
											if(library.checkBook(bookname))
											{
												Book book = library.getBook(bookname);
												
												if(book.isAvailable())
												{
													if(member.addIssuedBook(book))
													{
														library.setBookAvailability(bookname, false);
														System.out.println("Book Issued Successfully");
													}
													else
													{
														System.out.println("Error has occured (Probable Reason: Days are more than suggested)");
													}
												}
												else
												{
													System.out.println("Sorry, Book is not available at this time.");
												}
											}
											else
											{
												System.out.println("No such book exist");
											}
									
										}break;
									
									case 7: {
									
										String bookname = ui.bookMenu();
										
										if(member.checkIssuedBook(bookname))
										{
											member.returnIssuedBook(bookname);
											
											library.setBookAvailability(bookname, true);
											
											System.out.println("Book Returned Successfully");
										}
										else
										{
											System.out.println("No such book exist");
										}
								
									}break;
									case 8: member.showAllIssuedBook();break;
									case 9: System.out.println("Thank you");break;
									default:
								}
							}
							
						}
						else
						{
							System.out.println("Invalid password");
						}
					}
					
					else
					{
						System.out.println("Invalid Id");					
					}
				}
				break;
					
				case 2:
				{
					String id = ui.LoginMenu();
					
					if(library.employeeList.containsKey(id))
					{
						Employee employee = library.employeeList.get(id);
						String pass = ui.PasswordMenu();
						
						if(employee.comparePassword(pass))
						{
							int empChoice = 1;
							
							while(empChoice>0)
							{
								empChoice = ui.employeeMenu();
								
								switch(empChoice)
								{
								case 1: employee.showAllAvailableBooks(library); break;
								case 2: employee.showAllAuthors(library); break;
								case 3: employee.showAllMembers(library); break;
								case 4: employee.addMember(library); break;
								case 5: employee.removeMember(library); break;
								case 6: employee.addEmployee(library);break;
								case 7: employee.addBook(library); break;
								case 8: employee.removeBook(library); break;
								case 9: employee.addAuthor(library); break;
								case 10: System.out.println("Thank you"); break;
								default:
								}
							}
						}
						else
						{
							System.out.println("Invalid Password");
						}
				
					}
					
					else
					{
						System.out.println("Invalid Id");					
					}
				}
				break;	
				case 3: System.out.println("Thank You"); break;
				default: System.out.println("Invalid Selection");
			
			}
		}
	
		library.savePoint();
	}
}
