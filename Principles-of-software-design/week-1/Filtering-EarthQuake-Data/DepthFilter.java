
/**
 * Write a description of DepthFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DepthFilter implements Filter{
private double depthMin;
private double depthMax;
private String name;
public DepthFilter(double min,double max,String na){
depthMin=min;
depthMax=max;
name=na;
}
public boolean satisfies(QuakeEntry qe){
if(qe.getDepth()>=depthMin && qe.getDepth()<=depthMax){
return true;

}
return false;
}
public String getName(){
return name;
}
}
