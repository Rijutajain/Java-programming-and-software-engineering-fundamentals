
/**
 * Write a description of EfficientMarkovModel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Random;
import java.util.*;
public class EfficientMarkovModel extends AbstractMarkovModel {
        private int N;
        private HashMap<String,ArrayList<String>> map;
	public EfficientMarkovModel(int val) {
		myRandom = new Random();
		N=val;
		map=new HashMap<String,ArrayList<String>>();
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
            int index = myRandom.nextInt(myText.length()-N);
            String key = myText.substring(index, index + N);
            sb.append(key);
            for(int k=0; k < numChars - N; k++){
            ArrayList<String> follows = getFollows(key);
            index = myRandom.nextInt(follows.size());
            sb.append(follows.get(index));
            key = key.substring(1) + follows.get(index);
            }

        return sb.toString();
	}
	 private HashMap<String,ArrayList<String>> buildMap(){
         map=new HashMap<String,ArrayList<String>>();
           map.clear();
           int k=0;
         for(k=0;k<myText.length()-N;k++){
         String keycurr=myText.substring(k,k+N);
         String followch=myText.substring(k+N,k+N+1);
         addToMap(keycurr,followch);
         }
         if(k>=myText.length()-N){
            String keyEnd=myText.substring(k,k+N);
            String followEnd=" ";
            addToMap(keyEnd,followEnd);
            }
         return map;
}
      private void addToMap(String keycurr,String followch){
         if(!map.containsKey(keycurr)){
            ArrayList<String> rr=new ArrayList<String>(); 
            rr.add(followch);
            map.put(keycurr,rr);
            }
         else{
            map.get(keycurr).add(followch);
            }
        }
        public void printHashmapInfo(){
         HashMap<String,ArrayList<String>> map= buildMap();
          for (String s : map.keySet()) {
           System.out.println("key = "+s+" arraylist of words= "+map.get(s));
        }
        System.out.println("size of hashmap= "+map.size());
        int largest=0;
        for(String key:map.keySet()){
        if(map.get(key).size()>largest){
        largest=map.get(key).size();
        }
        
        }
        System.out.println("the size of largest key= "+largest);
         for(String key:map.keySet()){
            if(map.get(key).size()==largest){
             System.out.println(key);
            }
            
            }
  }  
}
