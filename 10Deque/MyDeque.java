
import java.util.*;

public class MyDeque{
    int front, back, size;
    String[] listy;

    public MyDeque(){
	listy = new String[10];
	size = 0;
    }

    public void addFirst(String str){
	if(str.equals("")){
	    throw new NullPointerException();
	}
	if(size == 0){
	    listy[0]=str;
	    front = 0;
	    back = 0;
	}
	else{
	    if(front-1 == back){
		this.resize();
	    }
	    if(front == 0){
		if(back==listy.length - 1){
		    this.resize();
		}
		listy[(listy.length)-1]=str;
		front = listy.length-1;
	    }

	    else{
		listy[front-1]=str;
		front--;
	    }
	}

	size++;
    }

    public void addLast(String str){
	if(str.equals("")){
	    throw new NullPointerException();
	}
	if(size == 0){
	    listy[0]=str;
	    front = 0;
	    back = 0;
	}
	else{
	    if(front-1 == back){
		this.resize();
	    }
	    if(back == listy.length -1){
		if(front != 0){
		    listy[0]=str;
		    back = 0;
		}
		else{
		    this.resize();
		    listy[size]=str;
		    back++;
		}
	    }
	    else{
		listy[back+1]=str;
		back++;
	    }
	}
	size++;
	
    }

    public void resize(){
	String[] temp = new String[2*(size+1)];
	for(int i=0, j=front; i < size; i++, j++){
	    if(j == listy.length){
		j = 0;
	    }
	    temp[i]=listy[j];
	}
	listy = temp;
	front=0;
	back=size-1;
    }

    public String removeFirst(){
	String temp = listy[front];
	if (front == listy.length-1){
	    front = 0;
	}
	else{
	    front--;
	}
	size--;
	return temp;
    }

    public String removeLast(){
	String temp = listy[back];
	if (back==0){
	    back = size;
	}
	else{
	    back--;
	}
	size--;
	return temp;
    }
    
    public String getFirst(){
	if (size ==0){
	    throw new NoSuchElementException();
	}
	else{
	    return listy[front];
	}
    }
    public String getLast(){
	if (size ==0){
	    throw new NoSuchElementException();
	}
	else{
	    return listy[front];
	}
    }

    
    
}
