public class KnightBoard{
    private int[][] board;
    private int rowL, columnL, squaresnum;
    public KnightBoard(int startingRows,int startingCols){
	board = new int [startingRows][startingCols];
	rowL = board.length;
	columnL = board[0].length;
	squaresnum = startingRows * startingCols;
    }
	
    public String toString(){
	String stringy = "";
	for (int r = 0; r < rowL; r++){
	    for (int c = 0; c < columnL; c++){
		if (board[r][c] < 10){
		    stringy += " ";   		
		}		
		stringy+= board[r][c]+ "";
	    }
	    stringy+="\n";
	}
	return stringy;
    } //blank if you never called solve or when there is no solution

    public void solve(){
	
    } 

    private boolean solveH(int row ,int col, int level){
	if (level == squaresnum){
	    return true;
	}
	if (valid(row, col)){
	   
	}

	/*
if done()->true
if isAValidSquare()
    markboard()
      if true
        solve(next knight)
      else-->unmarkboard try again
else->false
	 */
	return false;
    }
    
    private boolean valid(int row, int col){
	return board[row][col]==0;
    }
    private void addKnight(int r, int c, int level){
	
    }



}
