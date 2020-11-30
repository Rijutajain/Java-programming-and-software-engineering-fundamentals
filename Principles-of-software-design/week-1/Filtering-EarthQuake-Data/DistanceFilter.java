
/**
 * Write a description of DistanceFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DistanceFilter implements Filter {
private Location loc;
private double dist;
private String name;
public DistanceFilter(double maxDist,Location from,String na){
loc=from;
dist=maxDist;
name=na;
}
public boolean satisfies(QuakeEntry qe){
if(qe.getLocation().distanceTo(loc)<dist){
return true;
}
else{
return false;
}
}
public String getName(){
return name;
}
}
