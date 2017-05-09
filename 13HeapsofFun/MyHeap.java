public class MyHeap{
    private int size;
    private ArrayList<String> heap;
    
    public MyHeap(){
	heap = new ArrayList<String>;
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
	String s;
	while(move.compareTo)
    }

    private void pushDown(){
	int index = 1;

    }


    public String peek(){
	return heap.get(1);
    }

    public void swap(int i, int t){
	String a = heap.get(i);
	heap.set(t,a);
    }

}
