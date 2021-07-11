
/**
 * Write a description of MinutesFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MinutesFilter implements Filter {
   private int minMinute;
   private int maxMinute;
   public MinutesFilter(int min,int max) {
		minMinute = min;
		maxMinute=max;
	}
	public boolean satisfies(String id) {
		if(MovieDatabase.getMinutes(id) >= minMinute && MovieDatabase.getMinutes(id)<=maxMinute){
		  return true;
		  }
		  return false;
	}
}
