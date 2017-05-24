
import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;

public class MazeSolver{

    private String filey;
    private Maze mazey;
    private boolean anime;
    private Frontier rest;
    
    public MazeSolver(String filename){
	this(filename, false);
    }

    public MazeSolver(String filename, boolean animate){
	mazey = new Maze(filename);
	anime = animate;
	filey = filename;	
    }

    public void solve(){
	solve(1);
    }

    public void solve(int num){
	// style is 0-4, where 0-DFS, 1-BFS,2-BestFirst, 3-A*
	if(num == 0){
	    rest = new StackFrontier();
	}
	else if(num == 1){
	    rest = new QueueFrontier();
	}
	else if (num == 2){
	    rest = new FrontierPriorityQueue(false);
	}
	else if (num == 3){
	    rest = new FrontierPriorityQueue(true);
	}
	else{
	    throw new NullPointerException();
	}

	boolean done = false;
	rest.add(mazey.getStart());
	while (rest.getSize() > 0 && !done){
	    Location current = rest.next();
	    mazey.set(current.getRow(), current.getCol(), '.');
	    if(current.getRow()==mazey.getEnd().getRow() && current.getCol()==mazey.getEnd().getCol()){
		mazey.set(current.getRow(), current.getCol(), 'E');
		Location a = current.getPrev();
		while(a.getRow()!=mazey.getStart().getRow() && a.getCol() != mazey.getStart().getCol()){
		    mazey.set(a.getRow(), a.getCol(), '@');
		    a = a.getPrev();
		}
		done = true;
	    }
	    else{
		for(int n = 0; n < 4; n++){
		    Location b = current.getNeighbor(mazey.getStart(), mazey.getEnd(), n, current.getAStar());
		    if(mazey.get(b.getRow(),b.getCol()) == ' '){
			rest.add(b);
			mazey.set(b.getRow(),b.getCol(),'?');
		    }
		}
	    }
	}
	
	
    }
    
}
