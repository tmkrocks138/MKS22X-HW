
import java.util.Iterator;

public class MyLinkedList implements Iterable<Integer>{
    public LNode start, end;
    private int size;

    public void MyLinkedList(){
	size = 0;
    }

    public int size(){
	return size;
    }
    public boolean add(int value){
	LNode temp = new LNode();
	temp.setVal(value);
	if (size == 0){
	    start = temp;
	    end = temp;
	    size++;
	    return true;
	}
	temp.setPrevious(end);
	end.setNext(temp);
	end = temp;
	size++; 
	//System.out.println(size);
	return true;
    }

    public void add(int index, int value){
	LNode plus = new LNode();
	plus.setVal(value);
	//System.out.println(plus.value);
	if (size != 0){
	    if(index == 0){
		start.setPrevious(plus);
		plus.setNext(start);

		start = plus;
		size++;
		
	    }
	
	    else if(index < size){
		LNode nxt = getNthNode(index);

		plus.setPrevious(nxt.getPrevious());
		nxt.getPrevious().setNext(plus);
		plus.setNext(nxt);
		nxt.setPrevious(plus);

		size++;

	    }
	    else if(size == index){
		end.setNext(plus);
		plus.setPrevious(end);
		end = plus;
		size++;
	    }
	}
	else if(size==0){
	    start = plus;
	    end = plus;
	    size = 1;
	}
	else{
	    throw new IndexOutOfBoundsException("Bad Index");
	}
    }


    private void remove(LNode target){
	if (size==1){
	    start = null;
	    end = null;
	    size = 0;
	}
	else if(target.getNext()==null){
	    target.getPrevious().setNext(null);
	    end = target.getPrevious();
	    size--;
	}
	else if(target.getPrevious()==null){
	    target.getNext().setPrevious(null);
	    start = target.getNext();
	    size--;
	}
	else{
	    LNode a = target.getPrevious();
	    LNode c = target.getNext();
	    a.setNext(c);
	    c.setPrevious(a);
	    size--;
	}
    }
    

    public boolean remove(int index){
	if(index <= size && size != 1){
	    LNode minus = getNthNode(index);
	    if (index == 0){
		minus.getNext().setPrevious(null);
		start = minus.getNext();
		size--;
	    }
	    else if (index + 1 == size){
		minus.getPrevious().setNext(null);
		end = minus.getPrevious();
		size--;
	    }
	    else{
		LNode a	= minus.getNext();
		LNode c = minus.getPrevious();

		a.setNext(c);
		c.setPrevious(a);

		size--;
	    }
	    return true;
	}
	if(index == 0 && size == 1){
	    start = null;
	    end = null;
	    size = 0;
	    return true;
	}
	return false;
    }

    public LNode getNthNode(int index){
	if (size > index){
	    int i = index;
	    LNode place = start;
	    while(i!=0){
		place = place.next;
		i--;
	    }
	    return place;
	}
	else{
	    throw new IndexOutOfBoundsException("Bad Index");
	}

    }

    public int get(int index){
	return getNthNode(index).value;
    }

    public int set(int index, int val){
	int old = get(index);
	getNthNode(index).value = val;
	return old;
    }

    public int indexOf(int value){
	boolean found = false;
	LNode temp = start;
	int index = 0;
	while(!found){
	    if(temp.getVal() == value){
		return index;
	    }
	    else if(temp == end){
		found = true;
	    }
	    else{
		index++;
		temp = temp.getNext();
	    }
	
	}
	return -1;
    }

    public Iterator<Integer> iterator(){
	MyLinkIterator temp = new MyLinkIterator(this);
	return temp;
    }
    
    public String toString(){
	int temp = size;
	String str = "[";
	/*start at start, tack on every value each node. when next == null, stop*/
	LNode now = start;
	while(temp > 1){
	    //System.out.println(now);
	    str += now.getVal()+ ", ";
	    //System.out.println(str);
	    now = now.getNext();
	    temp--;
	}
	str += end.getVal();
	str += "]";

	return str;
    }

    public static void main(String[] args){
	MyLinkedList l = new MyLinkedList();
	l.add(0,4);
	l.add(0,2);
	l.add(1,9);
	System.out.println(l);
	l.remove(2);
	System.out.println(l);
    }



    private class LNode{
	public int value;
	public LNode next, previous;
	
	public LNode(){
	    value = 0;
	}

	public LNode(LNode a){
	    //for iterator
	    this.setNext(a);
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

	public LNode getPrevious(){
	    return previous;
	} 
	
	public int getVal(){
	    return value;
	}

    }

    public class MyLinkIterator implements Iterator<Integer>{

	public LNode current;
	public MyLinkedList ll;

	public MyLinkIterator(MyLinkedList listy){
	    ll = listy;
	    current = new LNode(listy.start);
	}
	
	public boolean hasNext(){
	    return current.getNext()!=null;
	}

	public Integer next(){
	    if(!this.hasNext()){
		throw new UnsupportedOperationException();
	    }
	    current = current.getNext();
	    return current.getVal();
	}

	public void remove(){
	    throw new UnsupportedOperationException();
	}
    }
    
}

