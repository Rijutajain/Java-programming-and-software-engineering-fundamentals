
/**
 * Write a description of MarkovOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Random;
import java.util.*;
public class MarkovOne {
  private String myText;
	private Random myRandom;
	
	public MarkovOne() {
		myRandom = new Random();
	}
	
	public void setRandom(int seed){
		myRandom = new Random(seed);
	}
	
	public void setTraining(String s){
		myText = s.trim();
	}
	
	public String getRandomText(int numChars){
		 if (myText == null){
                    return "";
                  }
            StringBuilder sb = new StringBuilder();
            int index = myRandom.nextInt(myText.length()-1);
            String key = myText.substring(index, index + 1);
            sb.append(key);
            for(int k=0; k < numChars - 1; k++){
            ArrayList<String> follows = getFollows(key);
            index = myRandom.nextInt(follows.size());
            sb.append(follows.get(index));
            key = key.substring(1) + follows.get(index);
            }

        return sb.toString();
	}
	public ArrayList<String> getFollows(String Key){
	    ArrayList<String> follows=new ArrayList<String>();
	    int pos = 0;
        while (pos < myText.length()){
            int start = myText.indexOf(Key, pos);
            if (start == -1){
                break;
            }
            if (start + Key.length() > myText.length() - 1){
                break;
            }
            String next = myText.substring(start + Key.length(), start + Key.length() + 1);
            follows.add(next);
            pos = start + Key.length();
        }
        return follows;
	   
	   
	   
	   }
}
