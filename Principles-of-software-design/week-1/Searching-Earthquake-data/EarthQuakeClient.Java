import java.util.*;
import edu.duke.*;

public class EarthQuakeClient {
    public EarthQuakeClient() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filterByMagnitude(ArrayList<QuakeEntry> quakeData,
    double magMin) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe:quakeData){
        if(qe.getMagnitude()>magMin){
        answer.add(qe);
        }
        
        }

        return answer;
    }

    public ArrayList<QuakeEntry> filterByDistanceFrom(ArrayList<QuakeEntry> quakeData,double distMax,Location from) {
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        
        for(QuakeEntry ff:quakeData){
        Location loc=ff.getLocation();
        if(loc.distanceTo(from)<distMax){
        answer.add(ff);
        System.out.println(loc.distanceTo(from));
         System.out.println(ff.getInfo());
        }
        
        }

        return answer;
    }

    public void dumpCSV(ArrayList<QuakeEntry> list){
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }

    }

    public void bigQuakes() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");
         ArrayList<QuakeEntry> answer=filterByMagnitude(list,5.0);
         for (QuakeEntry qe : answer) {
            System.out.println(qe);
        }
    }

    public void closeToMe(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source = "data/nov20quakedatasmall.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("read data for "+list.size()+" quakes");

        // This location is Durham, NC
        //Location city = new Location(35.988, -78.907);
        //ArrayList<QuakeEntry> answer=filterByDistanceFrom(list,1000,city);
         //  for (QuakeEntry qe : answer) {
          //  System.out.println(qe);
        //}

        //This location is Bridgeport, CA
        Location city =  new Location(38.17, -118.82);
        ArrayList<QuakeEntry> answer=filterByDistanceFrom(list,1000000.0,city);
           
    }

    public void createCSV(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source="data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
        for (QuakeEntry qe : list) {
            System.out.println(qe);
        }
    }
    public ArrayList<QuakeEntry> filterByDepth(ArrayList<QuakeEntry> quakeData,double minDepth,double maxDepth){
        ArrayList<QuakeEntry> answer=new ArrayList<QuakeEntry>();
    for(QuakeEntry qe:quakeData){
        double depth=qe.getDepth();
    if(depth>minDepth && depth<maxDepth){
    
    answer.add(qe);
    }
    
    }
    return answer;
    }
    public void quakesOfDepth(){
       EarthQuakeParser parser = new EarthQuakeParser();
        String source="data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
        ArrayList<QuakeEntry> ans  = filterByDepth(list,-4000.0,-2000.0);
       for(QuakeEntry qe:ans){
         System.out.println(qe);
        
        }
         System.out.println("number of such earthquakes = "+ans.size());
    }
    public ArrayList<QuakeEntry> filterByPhrase(ArrayList<QuakeEntry> quakeData,String where,String phrase){
    ArrayList<QuakeEntry> answer=new ArrayList<QuakeEntry>();
    for(QuakeEntry qe:quakeData){
    if(where=="start" && qe.getInfo().startsWith(phrase)){
    answer.add(qe);
    }
    if(where=="end" && qe.getInfo().endsWith(phrase)){
    answer.add(qe);
    
    }
    if(where=="any" && qe.getInfo().contains(phrase)){
    answer.add(qe);
    
    }
    }
    return answer;
    }
    public void quakePhrase(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source="data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        //dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
         ArrayList<QuakeEntry> ans=filterByPhrase(list,"any","Can");
           for(QuakeEntry qe:ans){
         System.out.println(qe);
        
        }
         System.out.println("number of such earthquakes = "+ans.size());
    }
    
}
