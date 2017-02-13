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
	    return false;
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
	for (int row = 0; row < board.length; row++){ //FIX COL
	    if (board[col][row]==0){
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
    	return "";
    }

    /*Used in WordSearch:
      for(int i = 0; i<word.length(); i++){
      if (data[row+(i*r)][col+(i*c)]!='_'&& data[row+(i*r)][col+(i*c)]!=word.charAt(i)){
      return false;
      }
      }
    */
    private void addQueen(int r,int c){
	board[r][c]=-1;
	//Cross
	for(int i=0; i < board.length; i++){
	    board[i][c] = board[i][c]+1;
	    board[r][i] = board[r][i]+1;
	}

	//diagonal HOW?!?!
	//for (int i=1; c+i<board.length; )
	
    }
    private void removeQueen(int r, int c){
	board[r][c]=0;
	//Cross
	for(int i=0; i < board.length; i++){
	    board[i][c] = board[i][c]-1;
	    board[r][i] = board[r][i]-1;
	}

	//diagonal HOW?!?!
	//for (int i=1; c+i<board.length; )

    }
}
