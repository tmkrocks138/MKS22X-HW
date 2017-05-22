import java.util.*;

public class MyHeap{
    private int size;
    private ArrayList<Location> heap;


    public int getSize(){
	return size;
    }
    
    public MyHeap(){
	heap = new ArrayList<Location>();
	heap.add(null);
	size=0;
    }
    
    public void add(Location s){
	heap.add(s);
	size++;
	pushUp();
	
    }

    public Location remove(){

	Location ans = heap.get(1);
	heap.remove(1);
	heap.add(1, heap.remove(size));
	size--;
	pushDown();
	return ans;

    }

    private void pushUp(){
	int index = size;
	Location move = heap.get(size);
        Location s = heap.get(size/2);
	while(move.CompareTo(s) == 1){
	    if (index <= 1){
		return;
	    }
	    swap(index, index/2);
	    index /= 2;
	    move = heap.get(index);
	    s = heap.get(index / 2);
	}
 
    }

    private void pushDown(){
	int index = 1;
	Location move = heap.get(index);
        Location s1 = heap.get(index * 2);
	Location s2 = heap.get((index * 2) + 1);

	while ((move.CompareTo(s1) == -1|| move.CompareTo(s2) == -1) && index < size){
	    if (move.CompareTo(s1) == -1 && s1.CompareTo(s2) == 1){
		swap(index, index * 2);
		index = index * 2;
		move = heap.get(index);
		s1 = heap.get(index * 2);
		s2 = heap.get((index * 2) + 1);
	    }
	    else if (move.CompareTo(s2) == -1 && s1.CompareTo(s2) == 1){
		swap(index, index * 2 + 1);
		index = index * 2 + 1;
		move=heap.get(index);
		s1=heap.get(index * 2);
		s2 = heap.get((index * 2) + 1);
	    }
	}
	
    }


    public Location peak(){
        if (size < 1){
	    throw new NullPointerException();
	}
	return heap.get(1);
    }

    public void swap(int i, int t){
	Location a = heap.get(i);
	heap.set(i,heap.get(t));
	heap.set(t,a);
    }

}
