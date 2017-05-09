public class MyHeap{
    private int size;
    private ArrayList<String> heap;
    
    public MyHeap(){
	heap = new ArrayList<String>();
	heap.add("NOTHING!!");
	size=0;
    }

    public void add(String s){
	
	heap.add(s);
	size++;
	heap.pushUp();
    }

    public String remove(){
	String ans = heap.get(1);
	heap.remove(1);
	heap.add(1, heap.remove(size));
	size--;
	heap.pushDown();
	return ans;
    }

    private void pushUp(){
	int index = size;
	String move = heap.get(size);
	String s = heap.get(index/2);
	boolean done = false;
	while(move.compareTo(s) > 0 && !done){
	    if(index==1){
		done = true;
	    }
	    else{
	
		heap.add(index, s);
		index = index / 2;
		heap.add(index, move);
		s = heap.get(index/2);
	    }
	}
	
	
    }

    /*  private void pushDown(){
	int index = 1;
	String move = heap.get(1);
	if (size % 2 == 0)
	String s = 
	boolean done == false;
	while(move.compareTo(s) > 0 && !done){
	    if(index==1){
		done == true;
	    }
	    else{
	
		heap.add(index, s);
		index = index / 2;
		heap.add(index, move);
		s = heap.get(index/2);
	    }
    }

    */
    public String peek(){
	return heap.get(1);
    }

}
