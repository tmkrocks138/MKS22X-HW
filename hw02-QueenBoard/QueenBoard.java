public class QueenBoard{
    private int[][]board;
    private int solutionCount;

    public QueenBoard(int size){
	board = new int[size][size];
	solutionCount = -1;
    }

    /**
     *precondition: board is filled with 0's only.
     *@return false when the board is not solveable. true otherwise.
     *postcondition: 
     *if false: board is still filled with 0's
     *if true: board is filled with the 
     *final configuration of the board after adding 
     *all n queens. Uses solveH
     */
    public void solve(){
	solveH(0);
	
    }

    private boolean solveH(int col){
        if (col >= board.length){
	    return true;
	}
	/*
	  if no safe{false}
	  for every col, while the row is less than length,
	  if spot is 0
	  add queen
	  if solve next
	  true
	  else
	  remove queen
	*/
	//if ();
	for (int row = 0; row < board.length; row++){ 
		if (board[row][col]==0){
		    addQueen(row, col);
		    if (solveH(col+1)){
			return true;
		    }
		    else{
			removeQueen(row, col);
		    }
		}
	  
	}
	return false;
    }

    /**
     *@return the number of solutions found, or -1 if the board was never solved.
     *The board should be reset after this is run.    
     */
    public int getSolutionCount(){
    	return solutionCount;
    }
    /**toString
     *and all nunbers that represent queens are replaced with 'Q' 
     *all others are displayed as underscores '_'
     */
    public String toString(){
	String stringy = "";
	for(int r = 0; r<board.length; r++){
	    for(int c = 0; c<board.length; c++){
		if(board[r][c]==-1){
		    stringy ="Q ";
		}
		else{
		    stringy="_ ";
		}
	    }
	    stringy = "\n"
	}
    	return stringy;
    }


    private void addQueen(int r,int c){
	board[r][c]=-1;
	//Cross
	for(int i=0; i < board.length; i++){
	    board[i][c] = board[i][c]+1;
	    board[r][i] = board[r][i]+1;
	}
	for(int col = c+1, row = r+1; row < board.length && col < board.length; row++, col++){
	    board[row][col] = board[row][col]+1;
	}
	
	for(int col = c+1,  row = r-1; row < board.length && col < board.length; row--, col++){
	    board[row][col] = board[row][col]+1;
	}
	for(int col = c-1, row = r+1; row < board.length && col < board.length; row++, col--){
	    board[row][col] = board[row][col]+1;
	}
	for(int col = c-1, row = r-1; row < board.length && col < board.length; row--, col--){
	    board[row][col] = board[row][col]+1;
	}
	
    }
    
    private void removeQueen(int r, int c){
	board[r][c]=0;
	//Cross
	for(int i=0; i < board.length; i++){
	    board[i][c] = board[i][c]-1;
	    board[r][i] = board[r][i]-1;
	}
	for(int col = c+1, row = r+1; row < board.length && col < board.length; row++, col++){
	    board[row][col] = board[row][col]-1;
	}
	
	for(int col = c+1, row = r-1; row < board.length && col < board.length; row--, col++){
	    board[row][col] = board[row][col]-1;
	}
	for(int col = c-1, row = r+1; row < board.length && col < board.length; row++, col--){
	    board[row][col] = board[row][col]-1;
	}
	for(int col = c-1, row = r-1; row < board.length && col < board.length; row--, col--){
	    board[row][col] = board[row][col]-1;
	}

    }
}
