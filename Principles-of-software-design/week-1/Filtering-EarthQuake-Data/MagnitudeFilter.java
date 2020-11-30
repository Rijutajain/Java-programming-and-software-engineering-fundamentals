
/**
 * Write a description of MagnitudeFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MagnitudeFilter implements Filter {
private double magMin;
private double magMax;
private String name;
public MagnitudeFilter(double min,double max,String na){
magMin=min;
magMax=max;
name=na;
}
public boolean satisfies(QuakeEntry qe){
if(qe.getMagnitude()>=magMin && qe.getMagnitude()<=magMax){
return true;

}
return false;
}
public String getName(){
return name;
}
}
