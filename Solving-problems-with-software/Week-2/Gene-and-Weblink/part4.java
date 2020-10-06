import edu.duke.*;
import java.io.*;

public class part4 {
  public void findWeblink(){
    URLResource Ur=new URLResource("https://www.dukelearntoprogram.com/course2/data/manylinks.html");
    for(String word : Ur.words()){
        System.out.println(word);
        String cat=word.toLowerCase();
  
    if(cat.contains("youtube.com")){
    int quotestart=word.indexOf("\"");
    int quoteend=word.indexOf("\"",quotestart+1);
    String dog=word.substring(quotestart,quoteend);
    System.out.println("youtube link is "+dog);
    

    }
    
   }
   
}
}
