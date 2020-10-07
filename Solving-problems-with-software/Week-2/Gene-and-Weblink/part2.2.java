public class part2 {
 public int howMany(String a,String b){
        int count=0;
        int startIndex=0;
        
        while(startIndex < b.length()){
            int currIndex = b.indexOf(a,startIndex);
            if(currIndex == -1){
                return count;
            }
            else
            {
                count=count+1;
                startIndex = currIndex + a.length();
            }
        }
        
        return count;
    }
    
    
 public void testHowMany(){
    String a="abcdefabyhujabh";
    String b="ab";
    String c="jn";
    int how1=howMany(b,a);
    System.out.println(how1);
    int how2=howMany(c,a);
    System.out.println(how2);
    
    }
}
