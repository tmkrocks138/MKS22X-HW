public class MyLinkedList{
    public LNode start, end;
    public int size;

    public boolean add(int value){

	//adds to front
	LNode temp = new LNode(value);
	temp.setNext() = start;
	start.setPrevious() = temp;
	start = temp;
	size++; 
	
	return true;
    }

    public String toString(){
	String str = "[";
	/*start at start, tack on every value each node. when next == null, stop*/
	now = start;
	while(now.getNext() != null){
	    str += now.getVal + ", ";
	    now++;
	}
	str += end.getVal();
	str = "]";

	return str;

    }





    private class LNode{
	public int value;
	public LNode next, previous;
	public void LNode(int n){
	    value = n;
	}
	public void setNext(LNode i){
	    next = i;
	}
	public void setPrevious(LNode i){
	    previous = i;
	}

	public LNode getNext(){
	    return next;
	} 
	public int getVal(){
	    return value;
	}

    }
    
}

