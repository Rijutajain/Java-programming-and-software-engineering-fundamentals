
/**
 * Write a description of MovieRunnerSimilarRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class MovieRunnerSimilarRatings {
   public void printAverageRatings(){
        FourthRatings fo=new FourthRatings();
        MovieDatabase.initialize("ratedmoviesfull");
        RaterDatabase.initialize("ratings");
        System.out.println("total number of movies = "+MovieDatabase.size());
        System.out.println("total number of raters = "+RaterDatabase.size());
        //double ans=ss.getAverageById("1790864",0);
        //System.out.println(ans);
        ArrayList<Rating> ans1=fo.getAverageRatings(35);
        System.out.println("number of ratings "+ans1.size());
        Collections.sort(ans1);
        for(Rating a : ans1){
        System.out.println(a.getValue()+" " +MovieDatabase.getTitle(a.getItem()));
        }
     }
     public void printAverageRatingsByYearAfterAndGenre(){
         FourthRatings fo1=new FourthRatings();
        AllFilters ff=new AllFilters();
        ff.addFilter(new YearAfterFilter(1990));
        ff.addFilter(new GenreFilter("Drama"));
        ArrayList<Rating> result5=fo1.getAverageRatingsByFilter(8,ff);
         System.out.println("number of movies found = "+result5.size());
        for(Rating r : result5){
        System.out.println(r.getValue()+" "+MovieDatabase.getYear(r.getItem())+" "+MovieDatabase.getTitle(r.getItem()));
        System.out.println(MovieDatabase.getGenres(r.getItem()));
        }
        
        }
     public void printSimilarRatings(){
        FourthRatings fo2=new FourthRatings();
        MovieDatabase.initialize("ratedmoviesfull");
        RaterDatabase.initialize("ratings");
        ArrayList<Rating> ans2=fo2.getSimilarRatings("71",20,5);
        System.out.println(MovieDatabase.getTitle(ans2.get(0).getItem()));
     }
     public void printSimilarRatingsByGenre(){
        FourthRatings fo2=new FourthRatings();
        MovieDatabase.initialize("ratedmoviesfull");
        RaterDatabase.initialize("ratings");
        ArrayList<Rating> ans2=fo2.getSimilarRatingsByFilter("964",20,5,new GenreFilter("Mystery"));
        for(Rating h : ans2){
        System.out.println(MovieDatabase.getTitle(h.getItem())+ " "+h.getValue());
        System.out.println(MovieDatabase.getGenres(h.getItem()));
       }
        }
     public void printSimilarRatingsByDirector(){
          FourthRatings fo2=new FourthRatings();
        MovieDatabase.initialize("ratedmoviesfull");
        RaterDatabase.initialize("ratings");
        ArrayList<Rating> ans2=fo2.getSimilarRatingsByFilter("120",10,2,new DirectorFilter("Clint Eastwood,J.J. Abrams,Alfred Hitchcock,Sydney Pollack,David Cronenberg,Oliver Stone,Mike Leigh"));
        for(Rating h : ans2){
        System.out.println(MovieDatabase.getTitle(h.getItem())+ " "+h.getValue());
        System.out.println(MovieDatabase.getDirector(h.getItem()));
       }
     }
     public void printSimilarRatingsByGenreAndMinutes(){
          FourthRatings fo2=new FourthRatings();
        MovieDatabase.initialize("ratedmoviesfull");
        RaterDatabase.initialize("ratings");
          AllFilters ff=new AllFilters();
        ff.addFilter(new MinutesFilter(80,160));
        ff.addFilter(new GenreFilter("Drama"));
        ArrayList<Rating> ans2=fo2.getSimilarRatingsByFilter("168",10,3,ff);
        for(Rating h : ans2){
        System.out.println(MovieDatabase.getTitle(h.getItem())+ " "+h.getValue()+" "+MovieDatabase.getMinutes(h.getItem()));
        System.out.println(MovieDatabase.getGenres(h.getItem()));
       }
      }
      public void printSimilarRatingsByYearAfterAndMinutes(){
           FourthRatings fo2=new FourthRatings();
        MovieDatabase.initialize("ratedmoviesfull");
        RaterDatabase.initialize("ratings");
          AllFilters ff=new AllFilters();
        ff.addFilter(new MinutesFilter(70,200));
        ff.addFilter(new YearAfterFilter(1975));
        ArrayList<Rating> ans2=fo2.getSimilarRatingsByFilter("314",10,5,ff);
        for(Rating h : ans2){
        System.out.println(MovieDatabase.getTitle(h.getItem())+ " "+h.getValue()+" "+MovieDatabase.getMinutes(h.getItem())+" "+MovieDatabase.getYear(h.getItem()));
       }
        }
    }
