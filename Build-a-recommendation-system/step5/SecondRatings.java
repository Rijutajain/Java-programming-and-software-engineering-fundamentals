
/**
 * Write a description of SecondRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class SecondRatings {
 private ArrayList<Movie> myMovies;
    private ArrayList<Rater> myRaters;
    
    public SecondRatings() {
        // default constructor
        this("ratedmoviesfull", "ratings");
    }
    public SecondRatings(String movieFile,String ratingsFile){
    FirstRatings ff=new FirstRatings();
    myMovies=ff.loadMovies("ratedmoviesfull");
    myRaters=ff.loadRaters();
    }
    public int getMovieSize(){
    return myMovies.size();
    }
    public int getRatersSize(){
    return myRaters.size();
   }
   public double getAverageById(String movieId,int minimalRaters){
       int count=0;
       double totalRating=0.0;
       double averageRating=0.0;
        for(Rater r : myRaters){
           if(r.hasRating(movieId)){
            count++;
            double temp=r.getRating(movieId);
            totalRating=totalRating+temp;
            }
           
        }
        if(count>=minimalRaters){
        return totalRating/count;
        }
        return 0;
        
   }
   public ArrayList<Rating> getAverageRatings(int minimalRaters){
       ArrayList<Rating> res=new ArrayList<Rating>();
        for(Movie p : myMovies){
        String l =p.getID();
        double avg=getAverageById(l,minimalRaters);
        Rating obj=new Rating(l,avg);
        if(!res.contains(obj.getItem()) && avg!=0.0){
        res.add(obj);
        }
        }
        return res;
    }
    public String getTitle(String movieId){
    for(Movie m : myMovies){
    if(m.getID().equals(movieId)){
    return m.getTitle();
    }
    }
    return "The ID was not found";
    }
    public String getID(String title){
    for(Movie n : myMovies){
    if(n.getTitle().equals(title)){
    return n.getID();
    }
    }
    return "NO SUCH TITLE FOUND";
    }
    
}
