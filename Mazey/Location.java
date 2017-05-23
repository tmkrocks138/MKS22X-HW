

import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;

public class Location{
    private int row, col, distToStart, distToGoal;
    private Location previous;
    private boolean aStar;

    public Location (int r, int c, Location prev, int distStart, int distGoal, boolean astar){
	row = r;
	col = c;
	previous = prev;
	distToStart = distStart;
	distToGoal = distGoal;
	aStar = astar;
    }

    public int getToStart(){
	return distToStart;
    }

    public int getToEnd(){
	return distToGoal;
    }

    public int getRow(){
	return row;
    }

    public int getCol(){
	return col;
    }

    public Location getPrev(){
	return previous;
    }

    public boolean getAStar(){
	return aStar;
    }

    public void setAStar(boolean t){
	aStar = t;
    }
    
    public void calcDist(int r, int c, boolean start){
	int a = Math.abs((this.getRow()-r) + (this.getCol() - c));
	if (start){
	    distToStart = a;
	}
	else{
	    distToGoal = a;
	}

    }
    
    public int CompareTo(Location other){
	int a = 0, b = 0;
	if (aStar){
	    a = this.getToStart() + this.getToEnd();
	    b = other.getToStart() + other.getToEnd();
	}
	else{
	    a = this.getToEnd();
	    b = other.getToEnd();
	}

	if (a < b){
	    return -1;
	}
	else{
	    return 1;
	}
    }

    public Location getNeighbor(Location start, Location end, int l, boolean star){
	Location a;
	if (l == 0){
	    a = new Location(this.getRow() - 1, this.getCol(), this, 0, 0, star);
	}
	else if (l == 1){
	    a = new Location(this.getRow() + 1, this.getCol(), this, 0, 0, star);
	}
	else if (l == 2){
	    a = new Location(this.getRow(), this.getCol() - 1, this, 0, 0, star);
	}
	else if (l == 3){
	    a = new Location(this.getRow(), this.getCol() + 1, this, 0, 0, star);
	}
	else{
	    throw new NullPointerException();
	}
	a.calcDist(start.getRow(), start.getCol(), true);
	a.calcDist(end.getRow(), end.getCol(), false);
	return a;
    }
    
}
