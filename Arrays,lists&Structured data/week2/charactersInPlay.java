import edu.duke.*;
import java.io.*;
import java.util.ArrayList;
public class charactersInPlay {
 private ArrayList<String> myWords;
 private ArrayList<Integer> myFreqs;
 public charactersInPlay(){
    myWords=new ArrayList<String>();
    myFreqs=new ArrayList<Integer>();
    
}
 public void update(String person){
   int index=myWords.indexOf(person);
   if(index==-1){
    myWords.add(person);
    myFreqs.add(1);
    }
    else{
    int value=myFreqs.get(index);
    myFreqs.set(index,value+1);
    }
}
public void findAllCharacters(){
     myWords.clear();
    myFreqs.clear();
   FileResource fr=new FileResource();
    for(String s:fr.lines()){
    if(s.contains(".")){
        int index=s.indexOf(".");
        String name=s.substring(0,index);
        update(name);
        }
    }
}
public void tester(){
findAllCharacters();
for(int k=0;k<myWords.size();k++){
    if(myFreqs.get(k)>5){
System.out.println(myWords.get(k)+ " "+myFreqs.get(k));
}
}
characterWithNumParts(10,15);
}
public void characterWithNumParts(int num1,int num2){
for(int k=0;k<myFreqs.size();k++){
if(myFreqs.get(k)>=num1 && myFreqs.get(k)<=num2){
System.out.println("The main characters between "+num1 +" and "+num2 +" = "+myWords.get(k)+" and number of speaking part is "+myFreqs.get(k));
}
}


}
}
