public class part3 {
    public int findStopCodon(String dna,int startindex ,String stopcodon ){
    int currindex=dna.indexOf(stopcodon,startindex+3);
    while (currindex!=-1){
     if((currindex-startindex)%3==0){
        return currindex;
        }
        else{
        currindex=dna.indexOf(stopcodon,currindex+1);
        }
    }
    return dna.length();
    }
   public String findGene(String dna,int where){
    int startindex=dna.indexOf("atg",where);
    if(startindex==-1){
    return "";
    }
    int taaindex=findStopCodon(dna,startindex,"taa");
    int tgaindex=findStopCodon(dna,startindex,"tga");
    int tagindex=findStopCodon(dna,startindex,"tag");
    int minindex=0;
    if(taaindex==-1 || tgaindex!=-1 && tgaindex<taaindex){
    minindex = tgaindex;
    }
    else{
    minindex=taaindex;
    }
    if(minindex==-1 || tagindex!=-1 && tagindex<minindex){
    minindex=tagindex;
    }
    if(minindex==-1){
    return "";
    }
    if((minindex-startindex)%3==0){
    return dna.substring(startindex,minindex+3);
    }
    else{
    return "";
    }
    }
    public void printAllGenes(String dna){
        int startindex=0;
        while(true){
        String currGene=findGene(dna,startindex);
        if(currGene.isEmpty()){
        break;
        }
        System.out.println(currGene);
        startindex=dna.indexOf(currGene,startindex)+currGene.length();
        }
    
    }
    public int countGenes(String dna){
    int startindex=0;
    int count=0;
    while(true){
        String currGene=findGene(dna,startindex);
         if(currGene.isEmpty()){
        break;
        }
        else{
        count=count+1;
        startindex=dna.indexOf(currGene,startindex)+currGene.length();
    }
    }
    return count;
}
public void testCountGenes(){
String a="atggaccagtaaatggactgaacgtag";
int number1=countGenes(a);
System.out.println(number1);
String b="atgaaaaaaaaaaa";
int number2=countGenes(b);
System.out.println(number2);
String c="agctacgtca";
int number3=countGenes(c);
System.out.println(number3);
}
}
