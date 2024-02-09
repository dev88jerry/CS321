package Assignment;

import java.util.Vector;

/**
 * This is the Library class which contains a collection of Book objects. Official 
 * description of the program is in the main.
 * @author Gregory
 *
 */



public class Library {
	
	/**Used to hold the books*/
	private Vector<Book> bookCollection;
	
	/**Used to hold the address of the library*/
	private String address;
	
	
	/**
	 * The constructor which initializes a Library object to the given address and
	 * also initializes the book collection.
	 * @param address	The address of the library.
	 */
	public Library (String address) {
		this.address = address;
		bookCollection = new Vector<Book>();
	}
	
	
	/**
	 * Used to print the opening hours.
	 */
	public static void printOpeningHours () {
		System.out.println("Libraries are open daily from 9am to 5pm.");
	}
	
	
	/**
	 * Used to print the Library's address.
	 */
	public void printAddress () {
		System.out.println(address);
	}
	
	
	/**
	 * Used to add a book into the book collection.
	 * @param b The book to add.
	 */
	public void addBook (Book b) {
		bookCollection.addElement(b);
	}
	
	
	/**
	 * This function is used to help other functions that need to find
	 * a book's position within the book collection.
	 * @param bookName The title of the book to search for.
	 * @return int The position of the book or -1 if it is not found.
	 */
	private int getBookPosition (String bookName) {
		for (int i = 0; i < bookCollection.size(); i++) {	
			if (bookCollection.elementAt(i).getTitle() == bookName) { ///If we find it return the position
				return i;
			}
		}
		System.out.println("Sorry, this book is not in our catalog.");///Otherwise, return -1
		return -1;
	}
	
	
	/**
	 * Used to borrow a book by the given name. It will determine if it exists and whether
	 * or not it has been borrowed.
	 * @param bookName The name of the book borrowed.
	 */
	public void borrowBook (String bookName) {
		int position = getBookPosition(bookName); ///Look for the book
		
		if (position != -1) {
			if (!bookCollection.elementAt(position).isBorrowed()) { ///If it is not borrowed
				bookCollection.elementAt(position).borrowed();     ///borrow it
				System.out.println("You successfully borrowed " + bookName); 
			}
			else{
				System.out.println("Sorry, this book is already borrowed."); ///Otherwise, its rented
			}
		}
	}
	
	
	/**
	 * Used to return a book of the given name. It will determine if it exists and whether or
	 * not it has already been returned.
	 * @param bookName The name of the book returned.
	 */
	public void returnBook (String bookName) {
		int position = getBookPosition(bookName); ///Look for the book
		
		if (position != -1){
			if (bookCollection.elementAt(position).isBorrowed()) {	///If it has not been returned 
				bookCollection.elementAt(position).returned();	    ///return it
				System.out.println("You successfully returned " + bookName);
			}
			else{
				System.out.println("Sorry, this book was all ready returned."); ///Otherwise, it's already been returned
			}
		}
	}
	
	
	/**
	 * Used to print all the books in the book collection.
	 */
	public void printAvailableBooks () {
		if (bookCollection.size() == 0) {				///If there are no books, print message
			System.out.println("No book in catalog.");
		}
		
		for (int i = 0; i < bookCollection.size(); i++) {					///For each book
			if (!bookCollection.elementAt(i).isBorrowed()) {				///If it hasn't been borrowed
				System.out.println(bookCollection.elementAt(i).getTitle()); ///Print the name
			}
		}
	}
	
}
