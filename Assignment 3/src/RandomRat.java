/**
 * Name: Gregory Mierzwinski
 * Date: February 13, 2016
 * This rat will move in a random direction to a cell that is not the previous cell that the rat was at.
 * Also, if we reach a dead end, we move to the previous cell and continue from there.
 */

import java.util.Random;
import java.util.Stack;

public class RandomRat extends Rat {
	//Will hold the next move
	static Random rnd = new Random();
	
	//Orientation of the rat, initially it is pointing up
	private int orientation;
	
	//Stack that is used to determine the previous position
	private Stack<Tuple> prevMoves;
	
	
	/**
	 * Constructor which initializes the name of the rat.
	 */
	public RandomRat() {
		name = "Randy";
		orientation = 1;
		prevMoves = new Stack<Tuple>();
	}
	
	/**
	 * Determine if we are at the end of a path or not, depending on the orientation of the rat.
	 * @param maz The maze that we are moving through.
	 * @return true/false We are at an end of path/We can still move to one of the positions
	 */
	public boolean threeWalls(Maze maz){
		switch(orientation){
			case 1: //Pointing up
				if(!maz.canMove(currentRow-1, currentCol) && !maz.canMove(currentRow, currentCol-1) && !maz.canMove(currentRow, currentCol+1)){
					return true;
				}
				return false;
			
			case 2: //Pointing right
				if(!maz.canMove(currentRow-1, currentCol) && !maz.canMove(currentRow+1, currentCol) && !maz.canMove(currentRow, currentCol+1)){
					return true;
				}
				return false;
				
			case 3: //Pointing down
				if(!maz.canMove(currentRow+1, currentCol) && !maz.canMove(currentRow, currentCol-1) && !maz.canMove(currentRow, currentCol+1)){
					return true;
				}
				return false;
			case 4: //Pointing left
				if(!maz.canMove(currentRow-1, currentCol) && !maz.canMove(currentRow, currentCol-1) && !maz.canMove(currentRow+1, currentCol)){
					return true;
				}
				return false;
		}
		return false;
	}
	
	
	/**
	 * This move function randomly picks a direction and moves there as long as
	 * it is a valid move. It is the same as the move function for IdiotRat.
	 * @param maz The maze to move through.
	 */
	public void move(Maze maz) {
	    boolean noMoveFound = true;
	    if(prevMoves.isEmpty()){		//If the stack is empty, add the current position to it
	    	prevMoves.push(new Tuple(currentRow, currentCol));
	    }
	    while ( noMoveFound)
	    	if(!threeWalls(maz)){		 //If we haven't reached an end of a path 
	    		System.out.println("here");
		        switch ( rnd.nextInt(4)) //For each case, check if we were there before, and don't move there if that's what was chosen
		        {   case 0: if( maz.canMove(currentRow -1, currentCol) && !prevMoves.peek().equals(new Tuple(currentRow-1, currentCol))){   
		        					 prevMoves.push(new Tuple(currentRow, currentCol)); //Push the current position
		        					 currentRow--;                         //UP
		                             noMoveFound = false;
		                             orientation = 1; //Face up 
		                         }
		                         break;
		            case 1: if( maz.canMove(currentRow , currentCol + 1) && !prevMoves.peek().equals(new Tuple(currentRow, currentCol+1))){
		            				 prevMoves.push(new Tuple(currentRow, currentCol)); //Push the current position
		            				 currentCol++;                         //RIGHT
		                             noMoveFound = false;
		                             orientation = 2; //Face right
		                         }
		                         break;
		            case 2: if( maz.canMove(currentRow + 1 , currentCol ) && !prevMoves.peek().equals(new Tuple(currentRow+1, currentCol))){
		            				 prevMoves.push(new Tuple(currentRow, currentCol)); //Push the current position
		            				 currentRow++;                         //DOWN
		                             noMoveFound = false;
		                             orientation = 3; //Face down
		                         }
		                         break;
		            case 3: if( maz.canMove(currentRow  , currentCol - 1) && !prevMoves.peek().equals(new Tuple(currentRow, currentCol-1))){
		            				 prevMoves.push(new Tuple(currentRow, currentCol)); //Push the current position
		            				 currentCol--;                         //LEFT
		                             noMoveFound = false;
		                             orientation = 4; //Face left
		                         }
		                         break;
		        }
	    	}
	    	else{														//Otherwise, we are at the end of a path and have to move the other way
	    		Tuple temp = prevMoves.pop();							//Get the previous position
	    		prevMoves.push(new Tuple(currentRow, currentCol));		//Push the current position
	    		currentRow = temp.getPosRow();							//Set the new position to move to
	    		currentCol = temp.getPosCol();
	    		noMoveFound = false;
	    	}
	    numMoves++;
	}
}
