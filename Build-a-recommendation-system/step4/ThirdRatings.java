
/**
 * Write a description of ThirdRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class ThirdRatings {
    private ArrayList<Rater> myRaters;
    
    public ThirdRatings() {
        // default constructor
        this("ratings");
    }
    public ThirdRatings(String ratingsFile){
    FirstRatings ff=new FirstRatings();
    myRaters=ff.loadRaters();
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
       ArrayList<String> movies = MovieDatabase.filterBy(new TrueFilter());
        for(String id : movies){
        double avg=getAverageById(id,minimalRaters);
        Rating obj=new Rating(id,avg);
        if(!res.contains(obj.getItem()) && avg!=0.0){
        res.add(obj);
        }
        }
        return res;
    }
   public ArrayList<Rating> getAverageRatingsByFilter(int minimalRaters,Filter filterCriteria){
       ArrayList<Rating> result=new ArrayList<Rating>();
    ArrayList<String> moviesEligible=MovieDatabase.filterBy(filterCriteria);
    for(String id : moviesEligible){
    double avg=getAverageById(id,minimalRaters);
        Rating obj=new Rating(id,avg);
        if(!result.contains(obj.getItem()) && avg!=0.0){
        result.add(obj);
        }
    }
    return result;
    }
}

