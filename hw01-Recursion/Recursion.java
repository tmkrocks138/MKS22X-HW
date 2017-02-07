public class Recursion{ 
    public static String name(){
	return "Khanna,Tara";
    }
    public static double sqrt(double n){
	if (n == 0.0){
	    return 0.0;
	}
	return help(10, 1);
    }
    public static double help(double n, double guess){
	if (isCloseEnough(guess*guess, n)){
	    return guess;
	}
	double better = ((n/guess)+guess)/2.0;
	return help(n,better);
	//return 0.0;
    }
    private static boolean isCloseEnough(double a,double b){
	double diff=0;
	if (a==0 && b==0){
	    return true;
	}
	else if (a/b <= 1.000000001 && a/b >= .99999999){
	    return true;
	}
	else{
	    return false;
	}
    }
}

