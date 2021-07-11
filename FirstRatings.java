
/**
 * Write a description of FirstRatings here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.*;
import org.apache.commons.csv.*;
public class FirstRatings {
  public ArrayList<Movie> loadMovies(String filename){
      FileResource fr=new FileResource("C:\\Users\\HRABC\\Downloads\\StepOneStarterProgram\\data\\"+filename+".csv");
      CSVParser parser=fr.getCSVParser(true);
      ArrayList<Movie> res=new ArrayList<Movie>();
      for(CSVRecord currentRow : parser){
          String ss=currentRow.get("minutes");
          int j=Integer.parseInt(ss);
          Movie mm=new Movie(currentRow.get("id"),currentRow.get("title"),currentRow.get("year"),currentRow.get("genre"),currentRow.get("director"),currentRow.get("country"),currentRow.get("poster"),j);
          res.add(mm);
       }
      return res;
    }
  public void testLoadMovies(){
      HashMap<String,Integer> director = new HashMap<String,Integer>();
      ArrayList<Movie> temp=loadMovies("ratedmoviesfull");
      System.out.println("Total number of movies "+temp.size());
      System.out.println("List of movies");
      for(Movie m : temp){
       System.out.println(m);
        }
        int comedy=0;
        int time=0;
        int max=0;
        String answer="";
        for(Movie k : temp){
        if(k.getGenres().contains("Comedy")){
        comedy++;
        }
        if(k.getMinutes()>150){
        time++;
        }
        String[] d = k.getDirector().split(",");
        for(int i=0;i<d.length;i++){
        if(!director.containsKey(d[i])){
        director.put(d[i],1);
        }
        else{
        director.put(d[i],director.get(d[i])+1);
        }
        }
        }
      for(Map.Entry<String,Integer>entry : director.entrySet()){
        if(entry.getValue()>max){
        max=entry.getValue();
        answer=entry.getKey();
        }
        }
      System.out.println("maximum number of movies directed by a director are"+max+"and the director is"+answer);
      System.out.println("Number of Movies of Comedy genre are "+comedy);
      System.out.println("Number of Movies greater than 150 minutes are "+time);
    }
  public CSVParser makingParser(String filename){
      FileResource fr=new FileResource("C:\\Users\\HRABC\\Downloads\\StepOneStarterProgram\\data\\"+filename+".csv");
      CSVParser parser=fr.getCSVParser(true);
      return parser;
    }
  public ArrayList<Rater> loadRaters(){
      CSVParser parser4=makingParser("ratings");
       HashMap<String,Rater> map=new HashMap<String,Rater>();
      for(CSVRecord currentRow : parser4){
           String raterId =currentRow.get("rater_id");
           String movieId = currentRow.get("movie_id");
           double rating = Double.parseDouble(currentRow.get("rating"));
           Rater rr=new Rater(raterId);
           rr.addRating(movieId,rating);
           if(!map.containsKey(raterId)){
           map.put(raterId,rr);
            }
           else{
            map.get(raterId).addRating(movieId,rating);
            }
           
       }
      return new ArrayList(map.values());
  }
  public int numberOfratings(String id){
        ArrayList<Rater> k=loadRaters();
         for(Rater r : k){
            if(r.getID().equals(id)){
            return r.numRatings();
            }
            }
            return -1;
      }
  public void maxRatingsByAnyRater(){
   int max=-1;
   ArrayList<Rater> k=loadRaters();
   ArrayList<String> peoplewithmaxratings=new ArrayList<String>();
    for(Rater r : k){
       int p=r.numRatings();
       if(p>max){
        max=p;
       }
    } 
    System.out.println("maximum number of ratings by any rater is "+max);
    for(Rater p : k){
    if(p.numRatings()==max){
     peoplewithmaxratings.add(p.getID());
    }
    }
    System.out.println("And people with max ratings are rater id ");
    for(String l : peoplewithmaxratings){
    System.out.println(l);
    }
   }
  public void numberOfRatingsParticularMovie(String id){
      CSVParser parser2=makingParser("ratings");
      int count=0;
      for(CSVRecord currentRow : parser2){
           String movieId = currentRow.get("movie_id");
           if(id.equals(movieId)){
            count++;
            }
    }
    System.out.println("number of ratings of movie "+id+" are "+count);
   }
   public void differentMovies(){
       CSVParser parser3=makingParser("ratings");
    ArrayList<String> track=new ArrayList<String>();
    for(CSVRecord currentRow : parser3){
       String movieId = currentRow.get("movie_id");
       if(!track.contains(movieId)){
        track.add(movieId);
        }
     }
     System.out.println("number of different movies "+track.size());
  }
  
  public void testLoadraters(){
   /*ArrayList<Rater> ans =loadRaters();
   System.out.println("total number of raters = "+ans.size());
   System.out.println("their IDs and number of Ratings are ");
   for(Rater p : ans){
    System.out.println(p.getID()+" "+p.numRatings());
    System.out.println("movie ids and ratings are - ");
    ArrayList<String> res=p.getItemsRated();
    for(String h : res){
    System.out.println("movie id "+ h +" has rating"+p.getRating(h));
    }
    }*/
    
   //int numberOfRatingsOfParticularPerson=numberOfratings("193");
   //System.out.println(numberOfRatingsOfParticularPerson);
   //maxRatingsByAnyRater();
    numberOfRatingsParticularMovie("1798709");
   //differentMovies();
   }
}
