import edu.duke.*;
import java.io.*;
import java.util.ArrayList;
public class wordFrequencies {
 private ArrayList<String> myWords;
 private ArrayList<Integer> myFreqs;
 public wordFrequencies(){
    myWords=new ArrayList<String>();
    myFreqs=new ArrayList<Integer>();
    
    }
 public void findUnique(){
    myWords.clear();
    myFreqs.clear();
    FileResource fr=new FileResource();
    for(String s:fr.words()){
    s=s.toLowerCase();
    int index=myWords.indexOf(s);
    if(index==-1){
    myWords.add(s);
    myFreqs.add(1);
    }
    else{
    int value=myFreqs.get(index);
    myFreqs.set(index,value+1);
    }
    }
}
public void tester(){
findUnique();
System.out.println("unique words= "+myWords.size());
for(int k=0;k<myWords.size();k++){
System.out.println(myFreqs.get(k)+" "+myWords.get(k));
}
int largest=findIndexOfMax();
System.out.println("most common word in file is "+myWords.get(largest)+" and it occurs "+myFreqs.get(largest)+" times");
}
public int findIndexOfMax(){
int largest=0;
for(int i=0;i<myFreqs.size();i++){
if(myFreqs.get(i)>myFreqs.get(largest)){
largest=i;
break;
}

}
return largest;
}
}
