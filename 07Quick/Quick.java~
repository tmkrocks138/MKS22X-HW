import java.util.Random;

public class Quick{

    public int[] data;
    
    public static int select(int[] data, int k){
	boolean splitting = true;
	int start = 0, end = data.length - 1;
	while (splitting){
	    int[] sol = part(data, start, end);
	    int low = sol[0];
	    int high = sol [1];
	    if(k >= low && k <= high){
		splitting = false;
		return data[low];
	    }
	    else if(start == end){
		splitting = false;
	    }
	    else if (k < low){
		end = low-1;
	    }
	    else if (k > high){
		start = high+1;
	    }
	}
	return -1;
    }


    public static int[] part(int[] ary, int start, int end){
	Random r = new Random();
	int specialI = r.nextInt(end+1 - start)+start;
	int val = ary[specialI];

	//move special to front
	ary[specialI]= ary[start];
	ary[start]=val;

	int lt =start+1, i = lt, gt=end ;

	while(i <= gt){
	    if (ary[i]<val){
		int temp = ary[i];
		ary[i]=ary[lt];
		ary[lt]=temp;
		i++;
		lt++;
	    }
	    else if(ary[i]==val){
		i++;
	    }
	    else if(ary[i]>val){
		int temp = ary[gt];
		ary[gt]=ary[i];
		ary[i]=temp;
		gt--;
	    }
	}

	ary[start]=ary[gt];
	ary[gt]=val;

	int[] ans = new int[2];
	ans[0]= lt;
	ans[1]=gt;
	return ans;
    }

    public void quickSort(){
        sortH(data, 0, data.length - 1);
    }
    
    public static int[] sortH(int[] ary, int start, int end){
	if(start < end){
	    int[] p = part(ary, start, end);
	    if(p[0] != 0){
		sortH(ary, start, p[0]-1);	
	    }
	    if(p[1] != end){
		sortH(ary, p[1]+1, end);
	    }
	}
	return ary;
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
	//System.out.println(part( ary, 0, ary.length - 1 ));
      	/*System.out.println(select( ary , 0 ));
	System.out.println(select( ary , 1 ));
	System.out.println(select( ary , 2 ));
	System.out.println(select( ary , 3 ));
	System.out.println(select( ary , 4 ));
	System.out.println(select( ary , 5 ));*/
	System.out.println(toString(sortH(ary, 0, ary.length - 1)));
    } 
}

