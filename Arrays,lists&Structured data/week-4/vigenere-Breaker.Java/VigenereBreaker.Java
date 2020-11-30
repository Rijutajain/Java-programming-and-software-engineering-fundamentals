
/**
 * Write a description of VigenereBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
import java.io.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        String slice="";
        for(int i=whichSlice;i<message.length();i+=totalSlices){
        char c=message.charAt(i);
        slice=slice+c;
        
        
        
        }
        return slice;
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
           CaesarCracker cc=new CaesarCracker();
        for(int i=0;i<klength;i++)
        {
            String s=sliceString(encrypted,i,klength);
            int o=cc.getKey(s);
            key[i]=o;
        }
         
        return key;
    }
    
    

    public void breakVigenere () {
        HashMap<String,HashSet<String>> dict=new HashMap<String,HashSet<String>>(); 
         DirectoryResource dr=new DirectoryResource();
    for(File fr:dr.selectedFiles()){
        FileResource f=new FileResource(fr);
        String fName=fr.getName();
        HashSet set= readDictionary(f);
        dict.put(fName,set);
        
     }
        FileResource fr=new FileResource();
        String h=fr.asString();
        breakForAllLangs(h,dict);
        
    }
    public HashSet<String> readDictionary(FileResource fr){
    HashSet<String> set =new HashSet<String>();
    for(String s:fr.lines()){
    String h=s.toLowerCase();
    set.add(h);
    
    
    }
    return set;
    }
    public int countWords(String message,HashSet<String> dictionary){
        int count=0;
    for(String word:message.toLowerCase().split("\\W")){
        if(dictionary.contains(word)){
        
        count=count+1;
        }
    }
    
    return count;
    }
    public String breakForLanguage(String encrypted,HashSet<String> dictionary){
        int maxWords=0;
        int keyLength=0;
        String dec="";
        char mostCommon=mostCommonCharIn(dictionary);
       for(int key=1;key<100;key++){
    int[] o= tryKeyLength(encrypted,key,mostCommon);
       VigenereCipher vv=new VigenereCipher(o);
       String jj=vv.decrypt(encrypted);
        int theseWords=countWords(jj,dictionary);
        if(theseWords>maxWords){
        maxWords=theseWords;
          keyLength=key;
          dec=jj;
        }
    }
  
       //System.out.println(keyLength);
        //System.out.println(maxWords);
     
     return dec;
    }
    public char mostCommonCharIn(HashSet<String> dictionary){
        HashMap<Character,Integer> freq=new  HashMap<Character,Integer>();
    for(String s:dictionary){
        for(int i=0;i<s.length();i++){
        char c=s.charAt(i);
        if(!freq.containsKey(c)){
        freq.put(c,1);
        
        }
        else{
        int value=freq.get(c);
        freq.put(c,value+1);
        
        
        }
    }
}
        char max='a';
        int count=0;
        for(char g:freq.keySet()){
           if(freq.get(g)>count){
            count=freq.get(g);
            max=g;
            }
        
    
       
    
    
    

}
return max;
}
public void breakForAllLangs(String encrypted,HashMap<String,HashSet<String>> language){
    int count=0;
    String decr="";
    String lang="";
for(String s:language.keySet()){
HashSet<String> set=language.get(s);
String dec=breakForLanguage(encrypted,set);
int num=countWords(dec,set);
if(num>count){
count=num;
decr=dec;
lang=s;
}
}
System.out.println("Language used for decryption = "+lang);
System.out.println(decr);
}
}
