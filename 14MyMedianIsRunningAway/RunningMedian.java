public class RunningMedian{

    private MyHeap small, big;
    private int median;
    
    public RunningMedian(){
	small = new MyHeap();
	big = new MyHeap(true);
    }

    public void add(int a){
	if (median == 0 && small.getSize() == 0){
	    small.add(a);
	    median = a;
	    return;
	}
	if(a <= median){
	    small.add(a);
	    if (small.getSize() > big.getSize() + 1){
		big.add(small.remove());
	    }	    
	}
	else{
	    big.add(a);
	    if (big.getSize() > small.getSize() + 1){
		small.add(big.remove());
	    }
	}
	if (small.getSize() == big.getSize()){
	    median = (small.peak() + big.peak())/2;
	}
	else if(small.getSize() < big.getSize()){
	    median = big.peak();
	}
	else if(small.getSize() > big.getSize()){
	    median = small.peak();
	}
    }

}
