import java.util.*;
import java.io.*;

public class USACO {
    private static int R = 0, C = 0, E = 0, N = 0;
    private static String lakeS="";
    private static int[][] lake;
  
    public static int bronze(String filename) {
    
	//R = row
	//C = column
	//E = elevation for the final water level
	//N = amount of stomp digging
	//R_s = row start for stomp digging
	//C_s = column start for stomp digging
	//D_s = push down D_s inches
	//N = amount of stomp digging
    
	readFile(filename);
	return 0;
    }
  
    private static void readFile(String filename){
	Scanner scanner;
	try{
	    scanner = new Scanner(new File(filename));
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
	catch(FileNotFoundException e) {
	    System.out.println("FILE NOT FOUND!!!");
	}

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

    // public int silver(String filename) {
    //
    // }

}
