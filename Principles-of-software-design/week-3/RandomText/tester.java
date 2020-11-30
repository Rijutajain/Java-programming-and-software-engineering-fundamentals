
/**
 * Write a description of tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
import edu.duke.*;
public class tester {
public void testGetFollows(){
MarkovOne markov=new MarkovOne();
String st="this is a test yes this is a test.";
st = st.replace('\n', ' ');
markov.setTraining(st);
ArrayList<String> follows=markov.getFollows("st");
for(String m:follows){
System.out.println(m);
}
}
public void testGetFollowsWithFile(){
FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		MarkovOne markov = new MarkovOne();
		markov.setTraining(st);
		ArrayList<String> follows=markov.getFollows("th");
		System.out.println(follows.size());
             for(String m:follows){
                System.out.println(m);
               }
               
}
}
