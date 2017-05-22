
import java.util.*;

public class QueueFrontier implements Frontier{
    private LinkedList<Location> listy;
    private int size;
    
    public QueueFrontier(){
	listy = new LinkedList<Location>();
    }
    
    public int getSize(){
	return size;
    }

    public void add(Location l){
	listy.add(l);
	size++;
    }

    public boolean hasNext(){
	return listy.peekFirst() != null;
    }
    
    public Location next(){
	if (hasNext()){
	    size--;
	    return listy.remove();
	}
	else{
	    return null;
	}
    }

}
