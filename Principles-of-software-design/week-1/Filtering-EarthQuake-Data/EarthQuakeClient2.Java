import java.util.*;
import edu.duke.*;

public class EarthQuakeClient2 {
    public EarthQuakeClient2() {
        // TODO Auto-generated constructor stub
    }

    public ArrayList<QuakeEntry> filter(ArrayList<QuakeEntry> quakeData, Filter f) { 
        ArrayList<QuakeEntry> answer = new ArrayList<QuakeEntry>();
        for(QuakeEntry qe : quakeData) { 
            if (f.satisfies(qe)) { 
                answer.add(qe); 
            } 
        } 
        
        return answer;
    } 

    public void quakesWithFilter() { 
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);         
        System.out.println("read data for "+list.size()+" quakes");
        //Location denver=new Location(39.7392, -104.9903);
        Filter f = new MagnitudeFilter(3.5,4.5,"Magnitude"); 
        ArrayList<QuakeEntry> m7  = filter(list, f); 
        Filter d=new DepthFilter(-55000,-20000,"Depth");
        ArrayList<QuakeEntry> d7 = filter(m7,d);
        for (QuakeEntry qe: d7){
            System.out.println(qe);
        }
         System.out.println(d7.size());
       /*Location Tokyo=new Location(35.42,135.43);
       Filter h=new DistanceFilter(10000000,Tokyo);
       ArrayList<QuakeEntry> h7  = filter(list, h); 
       Filter p=new PhraseFilter("end","Japan");
       ArrayList<QuakeEntry> p7 = filter(h7,p);
       for (QuakeEntry qe: p7){
            System.out.println(qe);
       }
        System.out.println(p7.size());*/
    }

    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
    }

    public void dumpCSV(ArrayList<QuakeEntry> list) {
        System.out.println("Latitude,Longitude,Magnitude,Info");
        for(QuakeEntry qe : list){
            System.out.printf("%4.2f,%4.2f,%4.2f,%s\n",
                qe.getLocation().getLatitude(),
                qe.getLocation().getLongitude(),
                qe.getMagnitude(),
                qe.getInfo());
        }
    }
    public void testMatchAllFilters(){
       EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        //dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
       MatchAllFilters maf=new MatchAllFilters();
       maf.addFilter(new MagnitudeFilter(1.0,4.0,"Magnitude"));
       maf.addFilter(new DepthFilter(-180000.0,-30000.0,"Depth"));
       maf.addFilter(new PhraseFilter("any","o","Phrase"));
       ArrayList<QuakeEntry> q=filter(list,maf);
       for(QuakeEntry qe:q){
        System.out.println(qe);
    }
     System.out.println(q.size());
    }
    public void testMatchAllFilters2(){
     EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "../data/nov20quakedata.atom";
        String source = "data/nov20quakedata.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        //dumpCSV(list);
        System.out.println("# quakes read: "+list.size());
       MatchAllFilters maf=new MatchAllFilters();
        maf.addFilter(new MagnitudeFilter(0.0,5.0,"Magnitude"));
        Location Billund=new Location (55.7308, 9.1153);
        maf.addFilter(new DistanceFilter(3000000.0,Billund,"Distance"));
        maf.addFilter(new PhraseFilter("any","e","Phrase"));
         ArrayList<QuakeEntry> q=filter(list,maf);
       for(QuakeEntry qe:q){
        System.out.println(qe);
    }
     System.out.println(q.size());
     System.out.println("Filters used are "+ maf.getName());
    }
}
