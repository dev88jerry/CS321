import java.util.ArrayList;
import java.util.Arrays;

/**
 * Name: Gregory Mierzwinski
 * Date: February 13, 2016
 * This class is used as a superclass for all other rats to enhance code reuse as most methods
 * have the exact same implementation. The only one that does not is the move function.
 * @author Gregory
 *
 */

abstract class Rat implements Animal {
	//Variables used by all rats to move through the maze
	int        startCol   = 0;
	int        startRow   = 0;
	int        currentCol = 0;
	int        currentRow = 0;
	String     name       = "NoName";
	int        numMoves   = 0;
	protected ArrayList<ArrayList<Integer>> directions = new ArrayList<ArrayList<Integer>>();
	
	/**
	 * Constructor for all rats.
	 */
	protected Rat() {
		this.directions = new ArrayList<ArrayList<Integer>>();
	}

	public void fillDirections() {
		// Cardinal directions
		this.directions.add(new ArrayList<Integer>(Arrays.asList(0, 1)));
		this.directions.add(new ArrayList<Integer>(Arrays.asList(-1, 0)));
		this.directions.add(new ArrayList<Integer>(Arrays.asList(0, -1)));
		this.directions.add(new ArrayList<Integer>(Arrays.asList(1, 0)));

		// Diagonals
		// this.directions.add(new ArrayList<Integer>(Arrays.asList(1, 1)));
		// this.directions.add(new ArrayList<Integer>(Arrays.asList(-1, 1)));
		// this.directions.add(new ArrayList<Integer>(Arrays.asList(1, -1)));
		// this.directions.add(new ArrayList<Integer>(Arrays.asList(-1, -1)));
	}
	
	/**
	 * Get the current column postion of the rat.
	 */
	public int getColumn() {
		return currentCol;
	}

	
	/**
	 * Get the first letter of the name.
	 */
	public char getLetter() {
		return name.charAt(0);
	}


	/**
	 * Get the full name of the rat.
	 */
	public String getName() {
		return name;
	}

	
	/**
	 * Get the total number of moves made so far.
	 */
	public int getNumMoves() {
		return numMoves;
	}


	/**
	 * Get the current row position.
	 */
	public int getRow() {
		return currentRow;
	}

	
	/**
	 * Get the start column position.
	 */
	public int getStartColumn() {
		return startCol;
	}


	/**
	 * Get the start row position.
	 */
	public int getStartRow() {
		return startRow;
	}

	
	/**
	 * Reset all attributes of the rat.
	 */
	 public void reset() {
	    currentRow = startRow;
	    currentCol = startCol;
	    numMoves = 0;
	}
	
	
	/**
	 * Set the start column.
	 */
	public void setStartColumn(int col) {
		startCol = col;
	}

	
	/**
	 * Set the start row.
	 */
	public void setStartRow(int row) {
		startRow = row;
	}
}
