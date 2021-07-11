
/**
 * Write a description of RecommendationRunner here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class RecommendationRunner implements Recommender {
   public ArrayList<String> getItemsToRate(){
    ArrayList<String> list=new ArrayList<String>();
    MovieDatabase.initialize("ratedmoviesfull");
    RaterDatabase.initialize("ratings");
    System.out.println("The size of raters = "+RaterDatabase.size());
    System.out.println("The size of movies = "+MovieDatabase.size());
    AllFilters ff=new AllFilters();
    ff.addFilter(new GenreFilter("Drama"));
    ArrayList<String> moviesEligible=MovieDatabase.filterBy(ff);
    for(int i=0;i<10;i++){
    list.add(moviesEligible.get(i));
    }
    return list;
    }
    public void printRecommendationsFor(String webRaterId){
    FourthRatings fo=new FourthRatings();
    MovieDatabase.initialize("ratedmoviesfull");
    RaterDatabase.initialize("ratings");
    System.out.println("The size of raters = "+RaterDatabase.size());
    System.out.println("The size of movies = "+MovieDatabase.size());
    AllFilters ff=new AllFilters();
    ff.addFilter(new GenreFilter("Drama"));
    ArrayList<Rating> rl=fo.getSimilarRatingsByFilter(webRaterId,3,1,ff);
    StringBuilder sb=new StringBuilder();
    sb.append("Recommended Movies Size:");
    sb.append(rl.size());
    sb.append("\n Top 20 Recommended Movies:");
    sb.append("<table border=\"1\">");
    sb.append("<tr>");
    sb.append("<th>");
    sb.append("Movies");
    sb.append("</th>");
   sb.append("<th>");
   sb.append("Poster");
   sb.append("</th></tr>");
   int count=0;
    for(Rating r : rl){
        sb.append("<tr>");
        sb.append("<td>");
        sb.append(MovieDatabase.getTitle(r.getItem()));
        sb.append("</td>");
        sb.append("<td>");
        String x=MovieDatabase.getPoster(r.getItem());
        sb.append("<img src=");
        sb.append(x);
        sb.append(">");
        sb.append("</td></tr>");
        count++;
        if(count==20){
        break;
        }
    }
    sb.append("</table>");
    System.out.println(sb.toString());
    }
}
