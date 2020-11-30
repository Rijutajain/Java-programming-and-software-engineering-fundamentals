
/**
 * Write a description of MarkovFour here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Random;
import java.util.*;
public class MarkovFour extends AbstractMarkovModel {

	public MarkovFour() {
		myRandom = new Random();
		order=4;
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
            int index = myRandom.nextInt(myText.length()-4);
            String key = myText.substring(index, index + 4);
            sb.append(key);
            for(int k=0; k < numChars - 4; k++){
            ArrayList<String> follows = getFollows(key);
            index = myRandom.nextInt(follows.size());
            sb.append(follows.get(index));
            key = key.substring(1) + follows.get(index);
            }

        return sb.toString();
	}
	
}
