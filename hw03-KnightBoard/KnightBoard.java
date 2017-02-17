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
		stringy+= board[r][c]+ " ";
	    }
	    stringy+="\n";
	}
	return stringy;
    } //blank if you never called solve or when there is no solution

    public void solve(){
	System.out.println(solveH(0,0,0));
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
    private boolean solveH(int row ,int col, int level){
	if (level == squaresnum){
	    return true;
	}
	if (valid(row, col)){
	    addKnight(row, col, level);
	    if (allThemMoves(row, col, level)){
		return true;
	    }
	    else{
		removeKnight(row, col);
		return false;
		//TRY AGAIN 
		//return False accordings
	    }
	    
	}
	return false;
    }
    
    private boolean valid(int row, int col){
	return board[row][col]==0;
    }

    private boolean allThemMoves(int row, int col, int level){
	return (((row + 1 < rowL && col + 2 < columnL) && solveH(row + 1, col + 2, level + 1))||
		((row + 1 < rowL && col - 2 >= 0) && solveH(row + 1, col - 2, level + 1))||
		((row - 1 >= 0 && col + 2 < columnL) && solveH(row - 1, col + 2, level + 1))||
		((row - 1 >= 0 && col - 2 >= 0) && solveH(row - 1, col - 2, level + 1))||
		((row + 2 < rowL && col + 1 < columnL) && solveH(row + 2, col + 1, level + 1))||
		((row + 2 < rowL && col - 1 >= 0 ) && solveH(row + 2, col - 1, level + 1))||
		((row - 2 >= 0 && col + 1 < columnL) && solveH(row - 2, col + 1, level + 1))||
		((row - 2 >= 0 && col - 1 >= 0) && solveH(row - 2, col - 1, level + 1)));
	    
    }

    private void addKnight(int r, int c, int level){
	board[r][c] = level;
    }
    
    private void removeKnight(int r, int c){
	board[r][c] = 0;
    }

    public static void main(String[] args){
	KnightBoard k = new KnightBoard(5, 5);
	k.solve();
	System.out.println(k);
    }
}
