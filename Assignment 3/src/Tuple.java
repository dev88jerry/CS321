/**
 * This class is used to hold a tuple of the form (x, y) which are
 * coordinates in an xy-plane that describe the position of a node.
 * @author Gregory
 *
*/
	

public class Tuple {
	//Row position
	private int posRow;
			
	//Col position
	private int posCol;

	/**
	 * Constructs a new tuple at position (posCol, posRow).
	 * @param posRow
	 * @param posCol
	 */
	public Tuple(int posRow, int posCol){
		this.posRow = posRow;
		this.posCol = posCol;
	}
	
	/**
	 * Getter for row position.
	 * @return Row position.
	 */
	public int getPosRow() {
		return posRow;
	}

	
	/**
	 * Set the row position.
	 * @param posRow Row position.
	 */
	public void setPosRow(int posRow) {
		this.posRow = posRow;
	}

	
	/**
	 * Getter for column position.
	 * @return Column position.
	 */
	public int getPosCol() {
		return posCol;
	}

	
	/**
	 * Set the column position.
	 * @param posCol Column position.
	 */
	public void setPosCol(int posCol) {
		this.posCol = posCol;
	}


	/**
	 * Return true if this instance of tuple is equal to another instance of a tuple and
	 * false otherwise.
	 * @param t	The tuple to check against.
	 * @return True/False
	 */
	public boolean equals(Tuple t){
		return t.posRow == this.posRow && t.posCol == this.posCol;
	}		
}
