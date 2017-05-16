import java.util.*;

public class MyHeap{
    private int size;
    private ArrayList<Integer> heap;
    private int constant;

    public int getConstant(){
	return constant;
    }

    public int getSize(){
	return size;
    }
    
    public MyHeap(){
	heap = new ArrayList<Integer>();
	heap.add(0);
	size=0;
	constant = 1;
    }

    public MyHeap(boolean min){
	heap = new ArrayList<Integer>();
	heap.add(0);
	size=0;
	if (min){
	    constant = -1;
	}
	else{
	    constant = 1;
	}
    }
    
    public void add(Integer s){
	
	heap.add(s);
	size++;
	pushUp();
	
    }

    public Integer remove(){

	Integer ans = heap.get(1);
	heap.remove(1);
	heap.add(1, heap.remove(size));
	size--;
	pushDown();
	return ans;

    }

    private void pushUp(){
	int index = size;
	int move = heap.get(size);
        int s = heap.get(size/2);
	if (constant == -1){
	    while(move < s){
		if (index <= 1){
		    return;
		}
		swap(index, index/2);
		index /= 2;
		move = heap.get(index);
		s = heap.get(index / 2);
	    }
	}
	else{
	    while(move >s){
		if (index <= 1){
		    return;
		}
		swap(index, index/2);
		index /= 2;
		move = heap.get(index);
		s = heap.get(index / 2);
	    }
	}
    }

    private void pushDown(){
	int index = 1;
	int move = heap.get(index);
	int s1 = heap.get(index * 2);
	int s2 = heap.get((index * 2) + 1);
	if(constant == -1){
	    while ((move > s1 || move > s2) && index < size){
		if (move > s1 && s1 < s2){
		    swap(index, index * 2);
		    index = index * 2;
		    move = heap.get(index);
		    s1 = heap.get(index * 2);
		    s2 = heap.get((index * 2) + 1);
		}
		else if (move > s2 && s1 < s2){
		    swap(index, index * 2 + 1);
		    index = index * 2 + 1;
		    move=heap.get(index);
		    s1=heap.get(index * 2);
		    s2 = heap.get((index * 2) + 1);
		}
	    }
	}
	else{
	    while ((move < s1 || move < s2) && index < size){
		if (move < s1 && s1 > s2){
		    swap(index, index * 2);
		    index = index * 2;
		    move = heap.get(index);
		    s1 = heap.get(index * 2);
		    s2 = heap.get((index * 2) + 1);
		}
		else if (move < s2 && s1 <s2){
		    swap(index, index * 2 + 1);
		    index = index * 2 + 1;
		    move=heap.get(index);
		    s1=heap.get(index * 2);
		    s2 = heap.get((index * 2) + 1);
		}
	    }
	}
    }


    public Integer peak(){
        if (size < 1){
	    throw new NullPointerException();
	}
	return heap.get(1);
    }

    public void swap(int i, int t){
	int a = heap.get(i);
	heap.set(i,heap.get(t));
	heap.set(t,a);
    }

}
