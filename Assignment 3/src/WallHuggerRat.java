/**
 * Name: Gregory Mierzwinski
 * Date: February 13, 2016
 * This class finish's a maze by hugging the right wall and moving along it until it finds the exit.
 * This implementation is based on the instructions given in the assignment. It will not work when there
 * are four squares in a square formation. There is no way around this given the specifications.  
 */


public class WallHuggerRat extends Rat {
	
	//Used to determine which way the rat is facing.
	int orientation = 1;
	
	
	/**
	 * Constructs a rat with a new name.
	 */
	public WallHuggerRat(){
		name = "Wally";
	}
	
	
	/**
	 * This move function will have the rat hug the right side of the maze to find the end.
	 * It uses orientation to determine what is it's right side.
	 */
	public void move(Maze maz) {
		boolean noMoveFound = true;
	    while (noMoveFound){
	    	//If we are facing up
	    	if(orientation == 1){
	    		//Move to it's relative right
		    	if(maz.canMove(currentRow, currentCol+1)){
		    		currentCol++;
		    		orientation = 2;			//Face right
		    		noMoveFound = false;
		    	}
		    	//Move to it's relative forward
		    	else if(maz.canMove(currentRow-1, currentCol)){
		    		currentRow--;
		    		orientation = 1;		   //Face up	
		    		noMoveFound = false;
		    	}
		    	//Move to it's relative left
		    	else if(maz.canMove(currentRow, currentCol-1)){
		    		currentCol--;
		    		orientation = 3;		  //Face left
		    		noMoveFound = false;
		    	}
		    	//Move to it's relative backwards
		    	else if(maz.canMove(currentRow+1, currentCol)){
		    		currentRow++;
		    		orientation = 4;		  //Face down
		    		noMoveFound = false;
		    	}
	    	}
	    	//Facing right
	    	else if(orientation == 2){
	    		//Move to it's relative right
		    	if(maz.canMove(currentRow+1, currentCol)){
		    		currentRow++;
		    		orientation = 4;			//Face down
		    		noMoveFound = false;
		    	}
		    	//Move to it's relative forward
		    	else if(maz.canMove(currentRow, currentCol+1)){
		    		currentCol++;
		    		orientation = 2;		   //Face right	
		    		noMoveFound = false;
		    	}
		    	//Move to it's relative left
		    	else if(maz.canMove(currentRow-1, currentCol)){
		    		currentRow--;
		    		orientation = 1;		  //Face up
		    		noMoveFound = false;
		    	}
		    	//Move to it's relative backwards
		    	else if(maz.canMove(currentRow, currentCol-1)){
		    		currentCol--;
		    		orientation = 3;		  //Face left
		    		noMoveFound = false;
		    	}
	    	}	
	    	//Facing left
	    	else if(orientation == 3){		
	    		//Move to it's relative right
		    	if(maz.canMove(currentRow-1, currentCol)){
		    		currentRow--;
		    		orientation = 1;			//Face up
		    		noMoveFound = false;
		    	}
		    	//Move to it's relative forward
		    	else if(maz.canMove(currentRow, currentCol-1)){
		    		currentCol--;
		    		orientation = 3;		   //Face left	
		    		noMoveFound = false;
		    	}
		    	//Move to it's relative left
		    	else if(maz.canMove(currentRow+1, currentCol)){
		    		currentRow++;
		    		orientation = 4;		  //Face down
		    		noMoveFound = false;
		    	}
		    	//Move to it's relative backwards
		    	else if(maz.canMove(currentRow, currentCol+1)){
		    		currentCol++;
		    		orientation = 2;		  //Face right
		    		noMoveFound = false;
		    	}
	    	}
	    	//Facing down
	    	else if(orientation == 4){			
		    	if(maz.canMove(currentRow, currentCol-1)){
		    		currentCol--;
		    		orientation = 3;			//Face left
		    		noMoveFound = false;
		    	}
		    	//Move to it's relative forward
		    	else if(maz.canMove(currentRow+1, currentCol)){
		    		currentRow++;
		    		orientation = 4;		   //Face down
		    		noMoveFound = false;
		    	}
		    	//Move to it's relative left
		    	else if(maz.canMove(currentRow, currentCol+1)){
		    		currentCol++;
		    		orientation = 2;		  //Face right
		    		noMoveFound = false;
		    	}
		    	//Move to it's relative backwards
		    	else if(maz.canMove(currentRow-1, currentCol)){
		    		currentRow--;
		    		orientation = 1;		  //Face up
		    		noMoveFound = false;
		    	}
	    	}
	    }
	    numMoves++;
	}
}
