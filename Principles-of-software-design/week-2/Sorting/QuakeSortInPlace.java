
/**
 * Write a description of class QuakeSortInPlace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class QuakeSortInPlace {
    public QuakeSortInPlace() {
        // TODO Auto-generated constructor stub
    }
   
    public int getSmallestMagnitude(ArrayList<QuakeEntry> quakes, int from) {
        int minIdx = from;
        for (int i=from+1; i< quakes.size(); i++) {
            if (quakes.get(i).getMagnitude() < quakes.get(minIdx).getMagnitude()) {
                minIdx = i;
            }
        }
        return minIdx;
    }
    
    public void sortByMagnitude(ArrayList<QuakeEntry> in) {
       
       for (int i=0; i< in.size(); i++) {
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
        }
        
    }

    public void testSort() {
        EarthQuakeParser parser = new EarthQuakeParser(); 
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        String source = "data/earthQuakeDataWeekDec6sample1.atom";
        //String source = "data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);  
       
        System.out.println("read data for "+list.size()+" quakes");    
        //sortByMagnitude(list);
        //sortByLargestDepth(list);
        //sortByMagnitudeWithBubbleSort(list);
        sortByMagnitudeWithBubbleSortWithCheck(list);
        //sortByMagnitudeWithCheck(list);
        //System.out.println("Earthquake after being sorted ");
        for (QuakeEntry qe: list) { 
            System.out.println(qe);
        } 
        
    }
    
    public void createCSV() {
        EarthQuakeParser parser = new EarthQuakeParser();
        //String source = "data/nov20quakedata.atom";
        String source = "data/nov20quakedatasmall.atom";
        //String source = "http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        dumpCSV(list);
        System.out.println("# quakes read: " + list.size());
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
    public int getLargest(ArrayList<QuakeEntry> quakeData,int from){
         int maxIdx = from;
        for (int i=from+1; i< quakeData.size(); i++) {
            if (quakeData.get(i).getDepth() > quakeData.get(maxIdx).getDepth()) {
                maxIdx = i;
            }
        }
        return maxIdx;
    
    }
    public void sortByLargestDepth(ArrayList<QuakeEntry> in){
     for (int i=0; i<=70; i++) {
            int minIdx = getLargest(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
        }
    
    }
    public void onePassBubbleSort(ArrayList<QuakeEntry> quakeData,int numSorted){
    for(int j=0;j<quakeData.size()-numSorted-1;j++){
    QuakeEntry current=quakeData.get(j);
    QuakeEntry next=quakeData.get(j+1);
    if(current.getMagnitude()>next.getMagnitude()){
    quakeData.set(j+1,current);
    quakeData.set(j,next);
    }
    
    }
    }
    public void sortByMagnitudeWithBubbleSort(ArrayList<QuakeEntry> in){
    int N=in.size();  
    for(int i=0;i<N-1;i++){
    onePassBubbleSort(in,i);
    System.out.println("Printing quakes after pass "+i);
    System.out.println(in);
    }
    }
    public boolean checkinSortedOrder(ArrayList<QuakeEntry> quakes){
        int count=0;
    for(int i=0;i<quakes.size()-1;i++){
        QuakeEntry current=quakes.get(i);
        QuakeEntry next=quakes.get(i+1);
        if(current.getMagnitude()<=next.getMagnitude()){
        count=count+1;
        }
    }
    if(count==quakes.size()-1){
    return true;
    }
    else{
    return false;
    }
    }
    public void sortByMagnitudeWithBubbleSortWithCheck(ArrayList<QuakeEntry> in){
    int N=in.size();
    int count=0;
    for(int i=0;i<N-1;i++){
    onePassBubbleSort(in,i);
    count=count+1;
    if(checkinSortedOrder(in)==true){
    break;
    }
    }
    System.out.println("number of pass needed = "+count);
    }
    public void sortByMagnitudeWithCheck(ArrayList<QuakeEntry> in){
    int count=0;
    for (int i=0; i< in.size(); i++) {
            int minIdx = getSmallestMagnitude(in,i);
            QuakeEntry qi = in.get(i);
            QuakeEntry qmin = in.get(minIdx);
            in.set(i,qmin);
            in.set(minIdx,qi);
             count=count+1;
             if(checkinSortedOrder(in)==true){
             break;   
             }
        }
        System.out.println("number of pass needed = "+count);
  
    }
}

