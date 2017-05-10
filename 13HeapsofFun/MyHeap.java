import java.util.*;

public class MyHeap{
    private int size;
    private ArrayList<String> heap;
    
    public MyHeap(){
	heap = new ArrayList<String>();
	heap.add("");
	size=0;
    }

    public void add(String s){
	
	heap.add(s);
	size++;
	pushUp();
    }

    public String remove(){
	String ans = heap.get(1);
	heap.remove(1);
	heap.add(1, heap.remove(size));
	size--;
	pushDown();
	return ans;
    }

    private void pushUp(){
	int index = size;
	String move = heap.get(size);
	String s = heap.get(size / 2);
	while(move.compareTo(s)>0){
	    if (index <= 1){
		return;
	    }
	    swap(index, index/2);
	    index /= 2;
	    move = heap.get(index);
	    s = heap.get(index/2); 
	}
    }

    private void pushDown(){
	int index = 1;
	String move=heap.get(index);
	String s1=heap.get(index * 2);
	String s2 = heap.get((index * 2) + 1);
	while ((move.compareTo(s1) < 0 || move.compareTo(s2) < 0) && index < size){
	    if (move.compareTo(s1) < 0 && s1.compareTo(s2) > 0){
		swap(index, index * 2);
		index = index * 2;
		move=heap.get(index);
		s1=heap.get(index * 2);
		s2 = heap.get((index * 2) + 1);
	    }
	    else if (move.compareTo(s2) < 0 && s1.compareTo(s2) < 0){
		swap(index, index * 2 + 1);
		index = index * 2 + 1;
		move=heap.get(index);
		s1=heap.get(index * 2);
		s2 = heap.get((index * 2) + 1);
	    }
	}
    }


    public String peek(){
        if (size < 1){
	    return "";
	}
	return heap.get(1);
    }

    public void swap(int i, int t){
	String a = heap.get(i);
	heap.set(i,heap.get(t));
	heap.set(t,a);
    }

}
