
/**
 * Write a description of MarkovModel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Random;
import java.util.*;
public class MarkovModel extends AbstractMarkovModel {
	public MarkovModel(int num) {
		myRandom = new Random();
		order=num;
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
            int index = myRandom.nextInt(myText.length()-order);
            String key = myText.substring(index, index + order);
            sb.append(key);
            for(int k=0; k < numChars - order; k++){
            ArrayList<String> follows = getFollows(key);
            index = myRandom.nextInt(follows.size());
            sb.append(follows.get(index));
            key = key.substring(1) + follows.get(index);
            }

        return sb.toString();
	}
	
}
