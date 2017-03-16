import java.util.Random;

public class Quick{

    public static int select(int[] data, int k){
	boolean splitting = true;
	int start = 0, end = data.length - 1;
	while (splitting){
	    int ind = part(data, start, end);
	    if(k == ind){
		splitting = false;
		return data[ind];
	    }
	    else if(start == end){
		splitting = false;
	    }
	    else if (k < ind){
		end = ind;
	    }
	    else if (k > ind){
		start = ind;
	    }
	}
	return -1;
    }


    public static int part(int[] ary, int start, int end){

	int ans = -1;
	
	Random r = new Random();
	int specialI = r.nextInt(end+1 - start)+start;
	int val = ary[specialI];
	
	//System.out.println(val);

	int[] temp= new int[ary.length];
	int low = start, high = end;
	for(int i = start; i < end + 1; i++){
	    if(!(i == specialI)){
		if(ary[i] < val){
		    temp[low]=ary[i];
		    low++;
		}
		else{
		    temp[high]=ary[i];
		    high--; 
		}
	    }
	}
	if(low == high){
	    ans = low;
	    temp[low] = val;
	}
	ary = temp;
	
	return ans;
    }


    public static void main(String[] args){
	int[]ary = { 2, 10, 15, 23, 0,  5};
	System.out.println(select( ary , 0 ));
	System.out.println(select( ary , 1 ));
	System.out.println(select( ary , 2 ));
	System.out.println(select( ary , 3 ));
	System.out.println(select( ary , 4 ));
	System.out.println(select( ary , 5 ));
    } 
}
