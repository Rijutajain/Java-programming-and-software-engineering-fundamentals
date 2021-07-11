
/**
 * Write a description of DirectorFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class DirectorFilter implements Filter {
     private String[] myDirector;
         public DirectorFilter(String directors) {
		myDirector = directors.split(",");
		
	}
	  public boolean satisfies(String id) {
        for (String s : myDirector) {
            if (MovieDatabase.getDirector(id).toLowerCase().contains(s.toLowerCase())){
                return true;      
            }
        }
        return false;
    }
	   
     
}
