import java.util.*;

public class StackFrontier implements Frontier{
    
    Stack<Locations> pancake;
    
    public StackFrontier(){
	pancake = new Stack<Location>();
    }
    
    public void add(Location l){
	pancake.push(l);
    }

    public Location next(){
	//	try{
	    return pancake.pop();
	    //	}
	//	catch ()
    }
}
