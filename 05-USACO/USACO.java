import java.util.*;
import java.io.*;

public class USACO {
    private static int R = 0, C = 0, E = 0, N = 0;
    private static String lakeS="";
    private static int[][] lake;
    private static Scanner scanner = null;

  
    public static int bronze(String filename) {
    
	//R = row
	//C = column
	//E = elevation for the final water level
	//N = amount of stomp digging
	//R_s = row start for stomp digging
	//C_s = column start for stomp digging
	//D_s = push down D_s inches
	//N = amount of stomp digging
    
	readFileB(filename);
	//System.out.println(lake);
	int rowStomp = R + 2;
	int stompCount = N;
	while (scanner.hasNextLine() && stompCount > 0){
	    stompDig(lake, scanner.nextLine());
	    stompCount--;
	}

	int ans = lastBronze(lake, E);
	
	return ans;

	
    }
  
    private static void readFileB(String filename){
	try{
	    scanner = new Scanner(new File(filename));
	}
	catch(FileNotFoundException e) {
	    System.out.println("FILE NOT FOUND!!!");
	}

	String line1= scanner.nextLine();
	String[] temp = line1.split(" ");
	R = Integer.parseInt(temp[0]);
	C = Integer.parseInt(temp[1]);
	E = Integer.parseInt(temp[2]);
	N = Integer.parseInt(temp[3]);

	lake = new int[R][C];
	int fillerR = R, fillerC = C;
	while(scanner.hasNextLine() && fillerR > 0){
	    String row = scanner.nextLine();
	    temp = row.split(" ");
	    for(int i = 0; i < temp.length; i++){
		lake[R-fillerR][i]=Integer.parseInt(temp[i]);
	    }
	    fillerR--;
	}
    }

    private static void stompDig(int[][] l, String liney){
	String[] temp = liney.split(" ");
	int r = Integer.parseInt(temp[0]) - 1;
	int c = Integer.parseInt(temp[1]) - 1;
	int down = Integer.parseInt(temp[2]);

	int[] nums = new int[9];
	for (int counterR = r, loop = 0; loop < 3 ; loop++, counterR++){
	    for (int counterC = c, loopy = 0; loopy < 3 ; loopy++, counterC++){
		nums[(3*loop)+loopy]=l[counterR][counterC];
	    }
	}

	int max = nums[0];
        for(int i = 0; i < nums.length; i++){
	    if(max < nums[i]){
                max = nums[i];
            }
        }

	max = max - down;

	for(int i = 0; i < nums.length; i++){
	    if(nums[i] > max){
		nums[i]= max;
	    }
	}
	

	for (int counterR = r, loop = 0; loop < 3 ; loop++, counterR++){
	    for (int counterC = c, loopy = 0; loopy < 3 ; loopy++, counterC++){
		l[counterR][counterC] =	nums[(3*loop)+loopy];
	    }
	}
 	
    }

    private static int lastBronze(int[][] l, int el){
	int sum = 0;
	for(int i = 0; i < l.length; i++){
	    for(int j = 0; j < l[i].length; j++){
		l[i][j] = el - l[i][j];
		if(l[i][j] < 0){
		    l[i][j] = 0;
		}
		sum += l[i][j];
	    }
	}

	int ans;
	ans = (72)*(72)*sum;
	return ans;
	
    }
    
    public String toString() {
       
	String result = "\n";
	for (int i = 0; i < lake.length; i++) {
	    for (int j = 0; j < lake[i].length; j++) {
		if(lake[i][j] < 100) {
		    result += lake[i][j] + "  ";
		} else {
		    result += lake[i][j] + " ";
		}
	    }
	    result += "\n";
	}
	return result;
    }


    public static String toPrint(int[][] f) {
       
	String result = "\n";
	for (int i = 0; i < f.length; i++) {
	    for (int j = 0; j < f[i].length; j++) {
		if(f[i][j] < 100) {
		    result += f[i][j] + "  ";
		}
		else {
		    result += f[i][j] + " ";
		}
	    }
	    result += "\n";
	}
	return result;
    }




    private static int M = 0, T= 0;
    private static int[][] field;
    private static Scanner in=null;


    
    public int silver(String filename) {
	//set a ton of cows in different directions
	//set ticks and count down
	int ways = 0;
	
	readFileS(filename);

	ways = moving(field, in.nextLine(), T);
	
	return ways;
	
    }

    private static void readFileS(String filename){
	try{
	    in = new Scanner(new File(filename));
	}
	catch(FileNotFoundException e) {
	    System.out.println("FILE NOT FOUND!!!");
	}

	
	String line1= in.nextLine();
	String[] temp = line1.split(" ");
	N = Integer.parseInt(temp[0]);
	M = Integer.parseInt(temp[1]);
	T = Integer.parseInt(temp[2]);

	field = new int[N][M];
	int fillerR = N, fillerC = M;
	
	while(in.hasNextLine() && fillerR > 0){
	    String row = in.nextLine();
	    char[] T = row.toCharArray();
	    // System.out.println(row);
	    
	    
	    for(int i = 0; i < T.length; i++){
		//System.out.println(T[i]);
	       	if(T[i] == '*'){
		    field[N-fillerR][i]=-1;
		}
		else if(T[i] == '.'){
		    field[N-fillerR][i]=0;
		}

	    }
	    fillerR--;
	}
    }

    private static int moving(int[][] f, String start2end, int moves){
	System.out.println(toPrint(f));
	int times = 0;
	
	String[] temp = start2end.split(" ");
	int r1 = Integer.parseInt(temp[0]) - 1;
	int c1 = Integer.parseInt(temp[1]) - 1;
	int r2 = Integer.parseInt(temp[2]) - 1;
	int c2 = Integer.parseInt(temp[3]) - 1;


	for(int count = 0; count <= moves; count++){
	    int[][] newNums = new int[f.length][f[0].length];
	    for (int i = 0; i < f.length; i++){
		for (int j = 0; j < f[i].length; j++){
		    if (count == 0){
			newNums[r1][c1] = 1;
		    }
		    if(f[i][j]==-1){
			newNums[i][j] = -1;
		    }
		    if(i >= 1 && f[i-1][j] > 0){
			newNums[i][j] += f[i-1][j];
		    }
		    if(j >= 1 && f[i][j-1] > 0){
			newNums[i][j] += f[i][j-1];
		    }
		    if(i < f.length - 1 && f[i+1][j] > 0){
			newNums[i][j] += f[i+1][j];
		    }
		    if(j < f[i].length - 1 && f[i][j+1] > 0){
		       
			newNums[i][j] += f[i][j+1];
		    }
		    if(f[i][j]==-1){
			newNums[i][j] = -1;
		    }

		}
	    }
	    f = newNums;
	    System.out.println(toPrint(f));
	}

	times = f[r2][c2];

	return times;
    }
}
