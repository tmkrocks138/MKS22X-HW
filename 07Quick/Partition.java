
import java.util.Random;

public class Partition{

    public static int part(int[] ary, int start, int end){
	Random r = new Random();
	int specialI = r.nextInt(end+1 - start)+start;
	int val = ary[specialI];

	//move special to front
	ary[specialI]= ary[start];
	ary[start]=val;

	int a=start+1, b=end;

	while(b >= a){
	    if (ary[a]<val){
		a++;
	    }
	    else{
		int temp = ary[b];
		ary[b]=ary[a];
		ary[a]=temp;
		b--;
	    }
	}

	ary[start]=ary[b];
	ary[b]=val;

	return b;
    }

    
    public static int part2(int[] ary, int start, int end){

	int ans = -1;
	
	Random r = new Random();
	int specialI = r.nextInt(end+1 - start)+start;
	int val = ary[specialI];
	
	System.out.println(val);

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

	return ans;
    }

    public static String toString(int[] ary){
	String ans = "";
	for (int i = 0; i < ary.length; i++){
	    ans += ary[i] + "  ";
	}
	return ans;
    }

    public static void main(String[] args){
	int[]ary = { 2, 10, 15, 23, 0,  5, 5, 5, 4, 24563, 33333, 777, 4, 9, 123, -1};
	System.out.println(part(ary, 0, 5));
	System.out.println(toString(ary));
	System.out.println(part(ary, 1, 5));
	System.out.println(toString(ary));
    }

}
