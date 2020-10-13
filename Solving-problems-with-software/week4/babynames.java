public class babyNames {
public void totalBirth(FileResource fr){
    int totalBorn=0;
    int girlsBorn=0;
    int boysBorn=0;
    int countgirlsname=0;
    int countboysname=0;
    for(CSVRecord rec:fr.getCSVParser(false)){
    int numBorn=Integer.parseInt(rec.get(2));
    totalBorn=totalBorn+numBorn;
    if(rec.get(1).equals("M")){
    boysBorn=boysBorn+numBorn;
    countboysname=countboysname+1;
    }
    else if(rec.get(1).equals("F")){
    girlsBorn=girlsBorn+numBorn;
    countgirlsname=countgirlsname+1;
    }
    
    }
    System.out.println("totalBirth= "+totalBorn);
    System.out.println("total number of girls born= "+girlsBorn);
    System.out.println("total number of boys born = "+boysBorn);
    System.out.println("total boysname "+countboysname);
     System.out.println("total girlsname "+countgirlsname);
}
public void testTotalBirth(){
FileResource fr=new FileResource("us_babynames\\us_babynames_by_year\\yob1905.csv");
totalBirth(fr);
}
public int getRank(int year,String name,String gender){
FileResource fr=new FileResource("us_babynames\\us_babynames_by_year\\yob"+ year +".csv");
CSVParser parser=fr.getCSVParser(false);

int rank=0;
for(CSVRecord currentRow:parser){
if(currentRow.get(1).equals(gender)){
rank=rank+1;
}

if(currentRow.get(0).equals(name) && currentRow.get(1).equals(gender)){
    return rank;

}

}
return -1;
}
public void testGetRank(){
int getrank1=getRank(1971,"Frank","M");
System.out.println("Rank of given name and gender "+getrank1);
int getrank2=getRank(1960,"Emily","F");
System.out.println("Rank of given name and gender "+getrank2);
int getrank3=getRank(2014,"Mason","F");
System.out.println("Rank of given name and gender "+getrank3);
}
public String getName(int year,int rank,String gender){
String name="NO NAME";
int rankcount=0;
FileResource fr=new FileResource("us_babynames\\us_babynames_by_year\\yob"+ year +".csv");
for(CSVRecord record:fr.getCSVParser(false)){
if(record.get(1).equals(gender)){
rankcount=rankcount+1;
}
if(rankcount==rank){
name=record.get(0);
}

}
return name;

}
public void testGetName(){
String name1=getName(1980,350,"F");
System.out.println("name of the given rank is " +name1);
String name2=getName(1982,450,"M");
System.out.println("name of the given rank is " +name2);
String name3=getName(2015,6,"M");
System.out.println("name of the given rank is " +name3);
}
public void whatIsNameInYear(String name,int year,int newyear,String gender){

     	  int rank=getRank(year,name,gender);
     	 String newname=getName(newyear,rank,gender);
     	  
    
    System.out.println(name+" would be "+newname+" if she/he wasborn in "+newyear+" instead of "+year);


}
public void testWhatIsNameInYear(){
whatIsNameInYear("Owen",1974,2014,"M");
}
public int yearOfHighestRank(String name,String gender){
    DirectoryResource dr=new DirectoryResource();
    int highestRank=0;
    int year=0;
    for(File f:dr.selectedFiles()){
  FileResource fr=new FileResource(f);   
  String fName = f.getName();
  String yr = fName.substring(3,7);
  int currentyear = Integer.parseInt(yr);
  int currentrank = getRank(currentyear,name,gender);
  if(highestRank==0){
    highestRank=currentrank;
    year=currentyear;
    }
  else if(currentrank<highestRank){
    highestRank=currentrank;
    year=currentyear;
    
    }
  else if(currentrank==-1){
    continue;
    }

}
return year;
}
public void testYearOfHighestRank(){
int year1=yearOfHighestRank("Mich","M");
System.out.println("highest rank of Mich in selected files is in year "+year1);



}
public double getAverageRank(String name,String gender){
  DirectoryResource dr=new DirectoryResource();
    double totalRank=0.0;
    int count=0;
    for(File f:dr.selectedFiles()){
  FileResource fr=new FileResource(f);
  String fName = f.getName();
  String yr = fName.substring(3,7);
  int currentyear = Integer.parseInt(yr);
  int currentrank = getRank(currentyear,name,gender);
  if(currentrank==-1){
    return -1;
    }
  totalRank=totalRank+currentrank;
count=count+1;
}
return totalRank/count;
}
public void testGetAverageRank(){
double average1=getAverageRank("Robert","M");
System.out.println("average of ranks is "+average1);
double average2=getAverageRank("Rijuta","F");
System.out.println("average of ranks is "+average2);
}
public int getTotalBirthsRankedHigher(int year ,String name,String gender ){
        FileResource fr=new FileResource("us_babynames\\us_babynames_by_year\\yob"+ year +".csv");
        CSVParser parser = fr.getCSVParser(false);    
        int indexRank=getRank(year,name,gender);
        int sumBirth=0;
        if (indexRank==-1){
            return -1;
        }
        for(CSVRecord record:parser){
            if(record.get(1).equals(gender)){
                int currRank=getRank(year,record.get(0),gender);
                if(currRank<indexRank){
                    sumBirth=sumBirth+Integer.parseInt(record.get(2));
                }
                else if(currRank>=indexRank){
                break;
                }
            }
        }
        return sumBirth;
}
public void testgettotalbirthrankedhigher(){
int birth1=getTotalBirthsRankedHigher(1990,"Drew","M");
System.out.println("total number of children born with rank higher then mason's= "+birth1);
}
}
