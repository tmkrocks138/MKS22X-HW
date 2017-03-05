import java.util.*;//random, scanner, arrayList
import java.io.*;//file, filenotfourd

public class Maze{


    private char[][]maze;
    private boolean animate;
    private String[] isolateRow;

    

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
	//Check for file
	try{
	    File files = new File(filename);
	}
	catch(FileNotFoundException e){
	    System.exit(0);
	}

	Scanner in = new Scanner(files);
	//get a BIG string of doc
	String bigStringy = in.nextLine();

	while (in.hasNextLine()){
	    bigStringy += "\n" + in.nextLine();    
	}
	// Take out bad values
	if (bigStringy.indexOf("S")== -1 || bigStringy.indexOf("E") == -1){
	    throw new IllegalArgumentException("");
	    System.exit(0);
	}
	if (bigStringy.indexOf("S")!= bigStringy.lastIndexOf("S") || bigStringy.indexOf("E") != bigStringy.lastIndexOf("E")){
	    throw new IllegalArgumentException("");
	    System.exit(0);
	}
	//split by line
	String[] ann = bigStringy.split("\n");   //Ann helped me...
	isolateRow = ann;
	//initialize maze
	maze = new char[ann.length][];
	for (int i = 0; i < ann.length; i++){
	    maze[i]=ann[i].toCharArray();
	}



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
	boolean exit = false;
	for (int i = 0; (exit || i < maze.length); i++){
	    for (int j = 0; (exit || j < maze[0].length); j++){
		if(maze[i][j]=='S'){
		    startr = i;
		    startc = j;
		    exit = true;
		}
	    }
	}
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
	    else{
		setSpot(row, col, '.');
		return false;
	    }
	    return false 
		}
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
