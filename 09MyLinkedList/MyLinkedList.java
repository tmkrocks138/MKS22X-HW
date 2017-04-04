public class MyLinkedList{
    public LNode start, end;
    public int size;

    public void MyLinkedList(){
	size = 0;
    }
    /*public boolean add(int value){


	//adds to front
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
    }*/

    public boolean add(int index, int value){
	LNode plus = new LNode();
	set(plus, value);
	if (size != 0){
	    if(index == 0){
		start.setPrevious(plus);
		plus.setNext(start);

		start = plus;
		size++;

		return true;
	    }
	
	    if(index < size){
		LNode nxt = get(index);
	    
		plus.setPrevious(nxt.getPrevious());
		nxt.getPrevious().setNext(plus);
		plus.setNext(nxt);
		nxt.setPrevious(plus);

		size++;
	    
		return true;
	    }
	    if(size == index){
		end.setNext(plus);
		plus.setPrevious(end);

		end = plus;
		size++;
		return true;
	    }
	}
	else if(size==0){
	    start = plus;
	    end = plus;
	    size = 1;
	    return true;
	}
	return false;
    }

    public int size(){
	return size;
    }

    public LNode get(int index){
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

    public void set(LNode n, int val){
	n.value = val;
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

	public LNode getPrevious(){
	    return previous;
	} 
	
	public int getVal(){
	    return value;
	}

    }
    
}

