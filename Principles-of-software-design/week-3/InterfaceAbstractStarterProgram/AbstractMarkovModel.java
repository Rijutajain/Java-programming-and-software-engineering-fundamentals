
/**
 * Abstract class AbstractMarkovModel - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */

import java.util.*;

public abstract class AbstractMarkovModel implements IMarkovModel {
    protected String myText;
    protected Random myRandom;
    protected int order;
    
    public AbstractMarkovModel() {
        myRandom = new Random();
    }
    
    public void setTraining(String s) {
        myText = s.trim();
    }
 
    abstract public String getRandomText(int numChars);
    
    protected ArrayList<String> getFollows(String Key){
	    ArrayList<String> follows=new ArrayList<String>();
	    int pos = 0;
        while (pos < myText.length()){
            int start = myText.indexOf(Key, pos);
            if (start == -1){
                break;
            }
            if (start + Key.length() > myText.length() - order){
                break;
            }
            String next = myText.substring(start + Key.length(), start + Key.length() + 1);
            follows.add(next);
            pos = start + Key.length();
        }
        return follows;
	   
	   
	   
  }
  //public String toString(){
    //return "Markov model of order "+order;
    //
    //}
}
