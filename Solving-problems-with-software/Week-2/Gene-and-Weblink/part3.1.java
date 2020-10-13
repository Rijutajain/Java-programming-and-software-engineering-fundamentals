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
    return -1;
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
    public StorageResource getAllGenes(String dna){
        StorageResource genelist=new StorageResource();
        int startindex=0;
        while(true){
        String currGene=findGene(dna,startindex);
        if(currGene.isEmpty()){
        break;
        }
        genelist.add(currGene);
        startindex=dna.indexOf(currGene,startindex)+currGene.length();
        }
     return genelist;
    }
    public void testOn(String dna){
    System.out.println("Testing getAllGenes on "+dna);
    StorageResource genes=getAllGenes(dna);
    for(String g:genes.data()){
    System.out.println(g);
    }
    
    }
    public void test(){
    testOn("atgatctaatttatgctgcaacggtgaaga");
    testOn("atggctga");
    testOn("gcatgaacg");
    }
    
}
