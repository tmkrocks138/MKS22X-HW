import java.util.*;//random, scanner, arrayList
import java.io.*;//file, filenotfourd

public class Maze{


    private char[][]maze;
    private boolean animate;

    

    /*Constructor loads a maze text file, and sets animate to false by default.
      1. The file contains a rectangular ascii maze, made with the following 4 characters:
      '#' - locations that cannot be moved onto
      ' ' - locations that can be moved onto
      'E' - the location of the goal (exactly 1 per file)

      'S' - the location of the start(exactly 1 per file)

      2. The maze has a border of '#' around the edges. So you don't have to check for out of bounds!
      3. When the file is not found OR there is no E or S then: print an error and exit the program.

    */

    public Maze(String filename){
	Scanner in = new Scanner(new File(filename));
        //COMPLETE CONSTRUCTOR



	setAnimate(false);
    }

    

    private void wait(int millis){ //ADDED SORRY!
         try {
             Thread.sleep(millis);
         }
         catch (InterruptedException e) {
         }
     }


    public void setAnimate(boolean b){

        animate = b;

    }


    public void clearTerminal(){

        //erase terminal, go to top left of screen.

        System.out.println("\033[2J\033[1;1H");

    }



    /*Wrapper Solve Function
      Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
    */
    public boolean solve(){
            int startr=-1,startc=-1;

            //Initialize starting row and startint col with the location of the S. 

            maze[startr][startc] = ' ';//erase the S, and start solving!
            return solveH(startr,startc);
    }


    /*
      Recursive Solve function:

      A solved maze has a path marked with '@' from S to E.

      Returns true when the maze is solved,
      Returns false when the maze has no solution.


      Postcondition:

        The S is replaced with '@' but the 'E' is not.

        All visited spots that were not part of the solution are changed to '.'
        All visited spots that are part of the solution are changed to '@'
    */
    private boolean solve(int row, int col){
        if(animate){
            System.out.println("\033[2J\033[1;1H"+this);

            wait(20);
        }

	if(getSpot(row, col)=='E'){
	    return true;
	}
	else{
	    setSpot(row, col, '@');
	    if(validSpot(row - 1, col) && getSpot(row - 1, col)==' '){
		return solve(row - 1, col);
	    }
	    else if (validSpot(row, col + 1) && getSpot(row, col + 1) == ' '){
		return solve(row, col + 1);
	    }
	    else if (validSpot(row + 1, col) && getSpot(row + 1, col) == ' '){
		return solve(row + 1, col);
	    }
	    else if (validSpot(row, col - 1) && getSpot(row, col - 1) == ' '){
		return solve(row, col - 1);
	    }

	    /*   IS IT THIS???

	    if(validSpot(row - 1, col) && getSpot(row - 1, col)==' ' && solve(row - 1, col)){
	        return true;
	    }
	    else if (validSpot(row, col + 1) && getSpot(row, col + 1) == ' ' && solve(row, col + 1)){
		return true;
	    }
	    else if (validSpot(row + 1, col) && getSpot(row + 1, col) == ' ' && solve(row + 1, col)){
		return true;
	    }
	    else if (validSpot(row, col - 1) && getSpot(row, col - 1) == ' ' && solve(row, col - 1)){
		return true;
	    }
	     */
	    
	    else{
		setSpot(row, col, '.');
		return false;
	    }
	  
	}
        //COMPLETE SOLVE

        return false; //so it compiles
    }

    public char getSpot(int row, int col){
	return maze[row][col];
    }
    public void setSpot(int row, int col, char setting){
	maze[row][col]=setting;
    }

    private boolean validSpot(int row, int col){
	return (maze.length > row && row >= 0) && (maze[0].length > col && col >= 0);
    }
    


}
