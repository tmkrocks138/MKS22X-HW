
import java.util.Random;

public class Partition{

    public int part(int[] ary, int start, int end){

	int ans = -1;
	
	Random r = new Random();
	int specialI = r.nextInt(end+1 - start)+start;
	int val = ary[specialI];
	
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
    
}
