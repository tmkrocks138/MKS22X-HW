import java.util.*;

public class StackFrontier implements Frontier{
    
    private Stack<Location> pancake;
    private int size;
    
    public StackFrontier(){
	pancake = new Stack<Location>();
    }
    
    public void add(Location l){
	pancake.push(l);
	size++;
    }

    public int getSize(){
	return size;
    }

    public boolean hasNext(){
	return size > 0;
    } 
    
    public Location next(){
	if (this.hasNext()){
	    size--;
	    return pancake.pop();
	}
	else{
	    return null;
	}
    }
}
