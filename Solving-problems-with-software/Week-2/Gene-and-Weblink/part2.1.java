
public class part1 {
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
    public String findGene(String dna){
    int startindex=dna.indexOf("atg");
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
    return dna.substring(startindex,minindex+3);
    }
    public void testFindStopCodon(){
    String a="actatggcttactaatgatag";
    String b="actatggcttgtaagctataa";
    String c="actatggcttgtaatga";
    String d="acatggctcgagctag";
    int index1=findStopCodon(a,3,"taa");
    System.out.println(index1);
    int index2=findStopCodon(a,3,"tga");
    System.out.println(index2);
    int index3=findStopCodon(a,3,"tag");
    System.out.println(index1);
    int index4=findStopCodon(b,3,"taa");
    System.out.println(index4);
    int index5=findStopCodon(c,3,"tga");
    System.out.println(index5);
    int index6=findStopCodon(d,3,"tag");
    System.out.println(index6);
    
    }
    public void testFindGene(){
    String a="actgactgacgt";
    String gene1=findGene(a);
    System.out.println(a);
    System.out.println(gene1);
    String b="actatgcgagcataa";
    String gene2=findGene(b);
    System.out.println(b);
    System.out.println(gene2);
    String c="gctatggaccagtactaagcatag";
    String gene3=findGene(c);
    System.out.println(c);
    System.out.println(gene3);
    String d="atggcaacgtaagattagacgtgaagc";
    String gene4=findGene(d);
    System.out.println(d);
    System.out.println(gene4);
    String e="atggcaactaaagctgtgaagggctag";
    String gene5=findGene(e);
    System.out.println(e);
    System.out.println(gene5);
    
    }
    public void printAllGenes(String dna){
        
    
    }
}
