public class Merge{

    public static void mergeSort(int[] ary){
	if(ary.length == 1){
	    return;
	}
	else{
	    int split = ary.length / 2;
	    int[] left = getPart(ary, 0, split);
	    int[] right = getPart(ary, split, ary.length);
	    mergeSort(left);
	    mergeSort(right);
	    mergeTogether(ary, right, left);
	}

    }


    private static int[] getPart(int[] ary, int start, int end){
	int[] ans = new int[end - start];
	for(int i = start, j = 0; i < end ; i++, j++){
	    ans[j] = ary[i];
	}
	return ans;

    }

    private static void mergeTogether(int[] ary, int[] a, int[] b){
	int i = 0 , j = 0, bigI = 0;
	boolean done = false;
	while (!done){
	    if(a.length == i && b.length == j){
		done = true;
	    }
	    else if(a.length == i){
		ary[bigI] = b[j];
		j++;
	    }
	    else if(b.length == j){
		ary[bigI] = a[i];
		i++;
	    }
	    else if(b[j]<a[i]){
		ary[bigI] = b[j];
		j++;
	    }
	    else if(a[i]<=b[j]){
		ary[bigI] = a[i];
		i++;
	    }
	    bigI++;
	}
    }
    
    



}
