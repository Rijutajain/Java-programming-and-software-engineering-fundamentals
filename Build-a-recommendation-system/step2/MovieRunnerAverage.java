
/**
 * Write a description of MovieRunnerAverage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class MovieRunnerAverage {
     public void printAverageRatings(){
        SecondRatings ss=new SecondRatings("ratedmoviesfull","ratings");
        System.out.println("total number of movies = "+ss.getMovieSize());
        System.out.println("total number of raters = "+ss.getRatersSize());
        //double ans=ss.getAverageById("1790864",0);
        //System.out.println(ans);
        ArrayList<Rating> ans1=ss.getAverageRatings(12);
        Collections.sort(ans1);
        for(Rating a : ans1){
        System.out.println(a.getValue()+" " +ss.getTitle(a.getItem()));
        }
     }
     public void getAverageRatingOneMovie(){
        SecondRatings s2=new SecondRatings("ratedmoviesfull","ratings");
        String identity=s2.getID("Vacation");
        System.out.println(identity);
        double ans2=s2.getAverageById(identity,1);
        System.out.println("Average rating is "+ans2);
     }
}
