
/**
 * Write a description of FourthRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class FourthRatings {
    private ArrayList<Rater> myRaters;
    
    public FourthRatings() {
        // default constructor
        this("ratings");
    }
    public FourthRatings(String ratingsFile){
    MovieDatabase.initialize("ratedmoviesfull");
    RaterDatabase.initialize("ratings");
    }
   public double getAverageById(String movieId,int minimalRaters){
       int count=0;
       double totalRating=0.0;
       double averageRating=0.0;
       
       ArrayList<Rater> myRaters=RaterDatabase.getRaters();
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
    private double dotProduct(Rater me,Rater r){
    ArrayList<String> items=MovieDatabase.filterBy(new TrueFilter());
    double product=0.0;
        String meID = me.getID();
        String rID = r.getID();
        for (String item: items) {
            if (me.hasRating(item) && r.hasRating(item)) {
                double meRating = me.getRating(item) - 5.0;
                double rRating = r.getRating(item) - 5.0;
                double temp = meRating * rRating;
                product=product+temp;
            }
        }
        return product;
    }
    private ArrayList<Rating> getSimilarities(String id){
    ArrayList<Rating> ratings = new ArrayList<Rating>();
        ArrayList<Rater> raters = RaterDatabase.getRaters();
        Rater me = RaterDatabase.getRater(id);
        
        for (Rater rater: raters) {
            double product = 0.0;
            if (!rater.getID().equals(id)) {
                product = dotProduct(me,rater);
            }
               
            if(product>0.0){
             Rating rat = new Rating(rater.getID(), product);
             ratings.add(rat);
            }
        }
        Collections.sort(ratings,Collections.reverseOrder());
        return ratings;
    }
    public ArrayList<Rating> getSimilarRatings(String id,int numSimilarRaters,int minimalRaters){
     ArrayList<Rating> result=new ArrayList<Rating>();
     ArrayList<Rating> list=getSimilarities(id);
     ArrayList<String> items = MovieDatabase.filterBy(new TrueFilter());
     for(String item : items){
         int count=0;
         double sum=0.0;
        for(int i=0;i<numSimilarRaters;i++){
        Rating rr=list.get(i);
        String RaterId=rr.getItem();
        Rater pp=RaterDatabase.getRater(RaterId);
          if(pp.hasRating(item)) {
              count++;
              double score = pp.getRating(item);
              double res = rr.getValue() * score;
              sum =sum+res;
          }
        }
        if(count>=minimalRaters){
        double weightedAvg=sum/count;
        Rating ss=new Rating(item,weightedAvg);
        result.add(ss);
        }
      }
      Collections.sort(result,Collections.reverseOrder());
      return result;
    }
    public ArrayList<Rating> getSimilarRatingsByFilter(String id,int numSimilarRaters,int minimalRaters,Filter filterCriteria){
     ArrayList<String> moviesEligible=MovieDatabase.filterBy(filterCriteria);
     ArrayList<Rating> result=new ArrayList<Rating>();
     ArrayList<Rating> list=getSimilarities(id);
     for(String item : moviesEligible){
         int count=0;
         double sum=0.0;
        for(int i=0;i<numSimilarRaters;i++){
        Rating rr=list.get(i);
        String RaterId=rr.getItem();
        Rater pp=RaterDatabase.getRater(RaterId);
          if(pp.hasRating(item)) {
              count++;
              double score = pp.getRating(item);
              double res = rr.getValue() * score;
              sum =sum+res;
          }
        }
        if(count>=minimalRaters){
        double weightedAvg=sum/count;
        Rating ss=new Rating(item,weightedAvg);
        result.add(ss);
        }
        }
        Collections.sort(result,Collections.reverseOrder());
      return result;
    }
}

