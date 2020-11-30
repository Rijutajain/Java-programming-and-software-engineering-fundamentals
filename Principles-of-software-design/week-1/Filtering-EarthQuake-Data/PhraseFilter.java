
/**
 * Write a description of PhraseFilter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PhraseFilter implements Filter {
private String type;
private String phrase;
private String name;
public PhraseFilter(String req,String ph,String na){
type=req;
phrase=ph;
name=na;
}
public boolean satisfies(QuakeEntry qe){
    if(type=="start" && qe.getInfo().startsWith(phrase)){
    return true;
    }
    if(type=="end" && qe.getInfo().endsWith(phrase)){
    return true;
    
    }
    if(type=="any" && qe.getInfo().contains(phrase)){
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
