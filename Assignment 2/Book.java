package Assignment;

/**
 * This is the Book class which acts as a Book with a given title. Official description
 * of the program is in the main.
 * @author Gregory
 *
 */

public class Book {
	
	/**Title of the book*/
	private String title;

	/**Used to tell if the book has been borrowed*/
	boolean borrowed;

	
	/**
	 * The constructor which initializes a Book object using the given
	 * title.
	 * @param bookTitle
	 */
	public Book (String bookTitle) { 
		this.title = bookTitle;
		borrowed = false;
	}

	
	/**
	 * Used to borrow a book. Sets borrowed to true.
	 */
	public void borrowed () {
		borrowed = true;
	}

	
	/**
	 * Used to return a book. Sets borrowed to false.
	 */
	public void returned () {
		borrowed = false;
	}

	
	/**
	 * Used to determine if the book is borrowed or not.
	 * @return true/false borrowed/available
	 */
	public boolean isBorrowed () {
		return borrowed;
	}

	
	/**
	 * Used to retrieve the books title.
	 * @return String The title of the book.
	 */
	public String getTitle () {
		return title;
	}
}

