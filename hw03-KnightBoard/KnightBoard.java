public class KnightBoard{
    private int[][] board;
    private int rowL, columnL;
    public KnightBoard(int startingRows,int startingCols){
	board = new int [startingRows][startingCols];
	rowL = board.length;
	columnL = board[].length;
    }
	
    public String toString(){
	String stringy = "";
	for (int r = 0; r < row+1;)
	return stringy;
    } //blank if you never called solve or when there is no solution

    public void solve(){
	
    } 

    private boolean solveH(int row ,int col, int level){
	return false;
	/*
if done()->true
if isAValidSquare()
    markboard()
      if true
        solve(next knight)
      else-->unmarkboard try again
else->false
	 */

    }

 // level is the # of the knight



}
