
/**
 * Write a description of MovieRunnerWithFilters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class MovieRunnerWithFilters {
   public void printAverageRatings(){
        ThirdRatings tt=new ThirdRatings();
        MovieDatabase.initialize("ratedmoviesfull");
        System.out.println("total number of movies = "+MovieDatabase.size());
        System.out.println("total number of raters = "+tt.getRatersSize());
        //double ans=ss.getAverageById("1790864",0);
        //System.out.println(ans);
        ArrayList<Rating> ans1=tt.getAverageRatings(35);
        System.out.println("number of ratings "+ans1.size());
        Collections.sort(ans1);
        for(Rating a : ans1){
        System.out.println(a.getValue()+" " +MovieDatabase.getTitle(a.getItem()));
        }
     }
     public void printAverageRatingsByYear(){
        ThirdRatings tt1=new ThirdRatings();
        ArrayList<Rating> result1=tt1.getAverageRatingsByFilter(20,new YearAfterFilter(2000));
        System.out.println("number of movies found = "+result1.size());
        for(Rating h : result1){
        System.out.println(h.getValue()+" " +MovieDatabase.getYear(h.getItem())+" " +MovieDatabase.getTitle(h.getItem()));
        }
        }
         public void printAverageRatingsByGenre(){
        ThirdRatings tt2=new ThirdRatings();
        ArrayList<Rating> result2=tt2.getAverageRatingsByFilter(20,new GenreFilter("Comedy"));
        System.out.println("number of movies found = "+result2.size());
        for(Rating p : result2){
        System.out.println(p.getValue()+" "+MovieDatabase.getTitle(p.getItem()));
        System.out.println(MovieDatabase.getGenres(p.getItem()));
        }
        }
          public void printAverageRatingsByMinute(){
        ThirdRatings tt3=new ThirdRatings();
        ArrayList<Rating> result3=tt3.getAverageRatingsByFilter(5,new MinutesFilter(105,135));
        System.out.println("number of movies found = "+result3.size());
        for(Rating l : result3){
        System.out.println(l.getValue()+" "+ "Time "+MovieDatabase.getMinutes(l.getItem())+" "+MovieDatabase.getTitle(l.getItem()));
        }
        }
          public void printAverageRatingsByDirector(){
        ThirdRatings tt4=new ThirdRatings();
        ArrayList<Rating> result4=tt4.getAverageRatingsByFilter(4,new DirectorFilter("Clint Eastwood,Joel Coen,Martin Scorsese,Roman Polanski,Nora Ephron,Ridley Scott,Sydney Pollack"));
        System.out.println("number of movies found = "+result4.size());
        for(Rating o : result4){
        System.out.println(o.getValue()+" "+MovieDatabase.getTitle(o.getItem()));
        System.out.println(MovieDatabase.getDirector(o.getItem()));
        }
        }
        public void printAverageRatingsByYearAfterAndGenre(){
         ThirdRatings tt5=new ThirdRatings();
        AllFilters ff=new AllFilters();
        ff.addFilter(new YearAfterFilter(1990));
        ff.addFilter(new GenreFilter("Drama"));
        ArrayList<Rating> result5=tt5.getAverageRatingsByFilter(8,ff);
         System.out.println("number of movies found = "+result5.size());
        for(Rating r : result5){
        System.out.println(r.getValue()+" "+MovieDatabase.getYear(r.getItem())+" "+MovieDatabase.getTitle(r.getItem()));
        System.out.println(MovieDatabase.getGenres(r.getItem()));
        }
        
        }
         public void printAverageRatingsByMinutesAndDirector(){
         ThirdRatings tt6=new ThirdRatings();
        AllFilters ff=new AllFilters();
        ff.addFilter(new MinutesFilter(90,180));
        ff.addFilter(new DirectorFilter("Clint Eastwood,Joel Coen,Tim Burton,Ron Howard,Nora Ephron,Sydney Pollack"));
        ArrayList<Rating> result6=tt6.getAverageRatingsByFilter(3,ff);
         System.out.println("number of movies found = "+result6.size());
        for(Rating r : result6){
        System.out.println(r.getValue()+" "+MovieDatabase.getMinutes(r.getItem())+" "+MovieDatabase.getTitle(r.getItem()));
        System.out.println(MovieDatabase.getDirector(r.getItem()));
        }
        
        }
}
