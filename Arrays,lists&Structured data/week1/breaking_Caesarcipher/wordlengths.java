import edu.duke.*;
import java.io.*;
public class wordLengths {
 public void countWordLengths(FileResource fr,int [] counts){
      for(String word:fr.words()){
            if(Character.isLetter(word.charAt(word.length()-1))){
                counts[word.length()]+=1;
            }
            else {
                counts[word.length() - 1]+=1;
            }
        }
    }
 public void testCountWordLength(){
    FileResource fr=new FileResource();
    int []counts=new int[31];
    countWordLengths(fr,counts);
     for(int i=0;i<counts.length;i++){
            if(counts[i]!=0){
                System.out.println(counts[i] + " words of length " + i);
            }
        }
    int maximum=indexOfMax(counts);
    System.out.println("most common length of word is "+ maximum);
    }
 public int indexOfMax(int [] Values){
    FileResource fr=new FileResource();
    for(String word:fr.words()){
            if(Character.isLetter(word.charAt(word.length()-1))){
                Values[word.length()]+=1;
            }
            else {
                Values[word.length() - 1]+=1;
            }
        }
    int max=0;
    for(int i=0;i<Values.length;i++){
    if(Values[i]>Values[max]){
    max=i;
    }
    }
    return max;
    }
    
}
