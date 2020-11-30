
/**
 * Write a description of MatchAllFilters here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class MatchAllFilters implements Filter {
private ArrayList<Filter> f;
public MatchAllFilters(){
f=new ArrayList<Filter>();

}
public void addFilter(Filter fin){
f.add(fin);

}
public boolean satisfies(QuakeEntry qe){
for(Filter a:f){
if(!a.satisfies(qe)){
return false;
}
}
return true;
}
public String getName(){
    String out="";
for(Filter ret:f){
String cat=ret.getName();
out=out+cat;
}
return out;
}
}
