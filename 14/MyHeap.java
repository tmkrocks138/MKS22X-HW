public class MyHeap{
    private int size;
    private ArrayList<Integer> heap;
    
    public MyHeap(){
	heap = new ArrayList<Integer>;
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
	if (size == 0){
	    return;
	}
	int index = size;
        int move = Integer.parseInt(heap.get(size));
	int temp = Integer.parseInt(heap.get(size/2));
	while(temp < move){
	    heap
	}
    }

    private void pushDown(){
	int index = 1;

    }


    public String peek(){
	return heap.get(1);
    }

}
