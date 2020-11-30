
/**
 * Write a description of LargestQuakes here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class LargestQuakes {
public void findLargestQuakes(){
        EarthQuakeParser parser = new EarthQuakeParser();
        String source="data/nov20quakedata.atom";
        ArrayList<QuakeEntry> list  = parser.read(source);
        System.out.println("# quakes read: " + list.size());
        //for(QuakeEntry qe:list){
        //System.out.println(qe);
        
        //}
        //indexOfLargest(list);
        
        ArrayList<QuakeEntry> ret=getLargest(list,50);
        //for(int p=0;p<ret.size();p++){
        //System.out.println("magnitude of 20th largest earthquake = "+ret.get(49).getMagnitude());
        
        //}
}
public int indexOfLargest(ArrayList<QuakeEntry> data){
int index=0;
for(int k=0;k<data.size();k++){
QuakeEntry quake=data.get(k);
double mag=quake.getMagnitude();
if(mag>data.get(index).getMagnitude()){
index=k;

}

}
System.out.println("The earthquake with largest magnitude is "+data.get(index)+"at location "+ index);
return index;
}
public ArrayList<QuakeEntry> getLargest(ArrayList<QuakeEntry> quakeData,int howMany){
ArrayList<QuakeEntry> copy=new ArrayList<QuakeEntry>(quakeData);
ArrayList<QuakeEntry> ans=new ArrayList<QuakeEntry>();
for(int j=0;j<howMany;j++){
int large=indexOfLargest(copy);
ans.add(copy.get(large));
copy.remove(large);
}
return ans;
}
}
