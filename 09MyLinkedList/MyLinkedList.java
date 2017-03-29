public class MyLinkedList{
    public LNode start, end;
    public int size;

    public void MyLinkedList(){
	size = 0;
    }
    public boolean add(int value){


	//adds to front
	LNode temp = new LNode();
	temp.setVal(value);
	if (size == 0){
	    start = temp;
	    end = temp;
	    size++;
	}
	
	temp.setNext(start);
	start.setPrevious(temp);
	start = temp;
	size++; 
	
	return true;
    }

    public String toString(){
	String str = "[";
	/*start at start, tack on every value each node. when next == null, stop*/
	LNode now = start;
	while(now.getNext() != null){
	    str += now.getVal()+ ", ";
	    now = now.getNext();
	}
	str += end.getVal();
	str = "]";

	return str;

    }

    public static void main(String[] args){
	MyLinkedList l = new MyLinkedList();
	l.add(4);
	l.add(7);
	System.out.println(l);
    }


    public class LNode{
	public int value;
	public LNode next, previous;
	
	public void LNode(int n){
	    value = n;
	}

	public void setVal(int n){
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

