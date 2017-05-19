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

    public int CompareTo(Location other){
	int a = this.getToStart() + this.getToEnd();
	int b = other.getToStart() + other.getToEnd();
	if (a < b){
	    return -1;
	}
	else{
	    return 1;
	}
    }
    
}
