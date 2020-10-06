
/**
 * Write a description of part3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class part3 {
    public boolean twoOccurrences(String a,String b){
        int startIndex = b.indexOf(a);
        startIndex = startIndex + a.length();
        int secondIndex = b.indexOf(a, startIndex);
        if(startIndex==-1 ||secondIndex==-1)
        {
        return false;
        }
        else
        {
        return true;
        }

}
   public String lastPart(String a,String b){
    int startIndex=b.indexOf(a);
    startIndex=startIndex+a.length();
    if(startIndex == -1)
    {
        return b;
    }
    else
    {
        return b.substring(startIndex);
    }
    }  
   public void testing(){
           String l="banana";
           String m="na";
           String n="the marium marry";
           String o="mar";
           String p="an";
           boolean answer=twoOccurrences(m,l);
           System.out.println("result="+answer);
           String result=lastPart(p,l);
           System.out.println("substring="+result);
    }
}
