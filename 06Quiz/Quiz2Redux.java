import java.util.*;
public class Quiz2Redux{  
    /*Returns an ArrayList<String> that contains all subsets of the
     *characters of String s. Assume s has no duplicate characters.
     *the characters should appear in the same order that they occur 
     *in the original string.
     */
    public static ArrayList<String> combinations(String s){
	ArrayList<String>words = new ArrayList<String>();
	help( words , s, 0);
	Collections.sort(words);
	return words;
    }
  
    private static void help( ArrayList<String> words, String s, int index){
        if(index >= s.length()){
	    return;
	}
	else{
	    if(index==0){
		words.add("");
	    }
	    
	    for(int count = index; count < s.length(); count++){
		    words.add(words.get(index)+s.charAt(count));
	    }
	    
	    help(words, s, index+1);
	}
	
    }



    public static void main(String[] args){
	Quiz2Redux a = new Quiz2Redux();
	ArrayList<String> words = new ArrayList<String>();
	String s = "abcde";
	help(words, s, 0);
	String ans = "\"\", ";
	for(int i = 0; i < words.size(); i++) {
	    ans += words.get(i) + ", ";
	}
	System.out.println(ans);
    }
}

