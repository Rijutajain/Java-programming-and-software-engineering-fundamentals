
/**
 * Write a description of Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
import java.io.*;
public class Tester {
public void testSliceString(){
    VigenereBreaker vv=new VigenereBreaker();
    String s1="abcdefghijklm";
    String a1=vv.sliceString(s1,1,4);
    System.out.println(a1);
}
public void testTryKeyLength(){
    VigenereBreaker vv=new VigenereBreaker();
    FileResource fr=new FileResource();
    String h=fr.asString();
    int[] g=vv.tryKeyLength(h,4,'e');
    for(int j=0;j<g.length;j++)
        {
            System.out.print(g[j]+" ");
        }  
}
public void testBreakVigenere (){
 VigenereBreaker vv=new VigenereBreaker();
 vv.breakVigenere ();

}
public void testReadDictionary(){
    VigenereBreaker vv=new VigenereBreaker();
    DirectoryResource dr=new DirectoryResource();
    for(File fr:dr.selectedFiles()){
        FileResource f=new FileResource(fr);
    HashSet set=vv.readDictionary(f);
    System.out.println(set);
    }
    
}
public void testCountWords(){
     VigenereBreaker vv=new VigenereBreaker();
     FileResource fr=new FileResource();
     HashSet<String> set=vv.readDictionary(fr);
     FileResource gr=new FileResource();
     String h=gr.asString();
     int counts=vv.countWords(h,set);
     System.out.println(counts);
}
}
