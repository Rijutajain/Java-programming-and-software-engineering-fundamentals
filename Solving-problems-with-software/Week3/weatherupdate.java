public class weatherupdate {
    public CSVRecord getSmallestOfTwo(CSVRecord currentRow, CSVRecord smallestSoFar){
    if(smallestSoFar==null){
    smallestSoFar=currentRow;
    }
    else{
    double currentTemp=Double.parseDouble(currentRow.get("TemperatureF"));
    double smallestTemp=Double.parseDouble(smallestSoFar.get("TemperatureF"));
    if(currentTemp<smallestTemp && currentTemp>0){
    smallestSoFar=currentRow;
    }
    }
    return smallestSoFar;
    }
    public CSVRecord coldestHourInFile(CSVParser parser){
    CSVRecord smallestSoFar=null;
    for(CSVRecord currentRow:parser){
    smallestSoFar=getSmallestOfTwo(currentRow,smallestSoFar);
    }
    return smallestSoFar;
}
 public void testColdestInDay(){
    FileResource fr=new FileResource("nc_weather\\2013\\weather-2013-01-23.csv");
    CSVRecord smallest=coldestHourInFile(fr.getCSVParser());
    System.out.println("coldest temperature was " + smallest.get("TemperatureF") + "at" + smallest.get("TimeEST"));
    
    
    }
    public String fileWithColdestTemperature(){
    CSVRecord smallestSoFar=null;
    File dog=null;
    DirectoryResource dr=new DirectoryResource();
    for(File f:dr.selectedFiles()){
     FileResource fr=new FileResource(f);
     CSVRecord currentRow=coldestHourInFile(fr.getCSVParser());
     smallestSoFar=getSmallestOfTwo(currentRow,smallestSoFar);
    if(smallestSoFar.equals(currentRow)){
     dog=f;
    }
    }
    return dog.getAbsolutePath();
    
    
    
    
    }
    public void testFileWithColdestTemperature(){
    String File=fileWithColdestTemperature();
    System.out.println("Coldest day was in File "+ File);
    FileResource fr=new FileResource(File);
    CSVRecord smallestSoFar=coldestHourInFile(fr.getCSVParser());
    System.out.println("Coldest temperature on that day was "+ smallestSoFar.get("TemperatureF"));
    System.out.println("All the Temperatures on coldest day were ");
    for(CSVRecord currentRow :fr.getCSVParser()){
        System.out.println(currentRow.get("DateUTC")+ ": "+currentRow.get("TemperatureF"));
        
    
    }
    
    
    
    
    
    }
    public CSVRecord getSmallestHOfTwo(CSVRecord currentRow, CSVRecord smallestSoFar){
        double currentH=0;
        double smallestH=0;
    if(smallestSoFar==null){
    smallestSoFar=currentRow;
    }
    else
    {
        String s=currentRow.get("Humidity");
        if(s!="N/A"){
        currentH=Double.parseDouble(s);
        smallestH=Double.parseDouble(smallestSoFar.get("Humidity"));
        }
        if(currentH<smallestH){
        smallestSoFar=currentRow;
        }
    }
    return smallestSoFar;
    }
   
    public CSVRecord lowestHumidityInFile(CSVParser parser){
    CSVRecord smallestSoFar=null;
    for(CSVRecord currentRow:parser){
    smallestSoFar=getSmallestHOfTwo(currentRow,smallestSoFar);
    }
    return smallestSoFar;
    
    }
    public void testLowestHumidityInFile(){
     FileResource fr=new FileResource("nc_weather\\2014\\weather-2014-01-20.csv");
    CSVRecord smallest=lowestHumidityInFile(fr.getCSVParser());
    System.out.println("lowest humidity was " +smallest.get("Humidity")+"at "+smallest.get("DateUTC"));
    
    }
    public CSVRecord lowestHumidityInManyFiles(){
    CSVRecord smallestSoFar=null;
    DirectoryResource dr=new DirectoryResource();
    for(File f:dr.selectedFiles()){
     FileResource fr=new FileResource(f);
     CSVRecord currentRow=lowestHumidityInFile(fr.getCSVParser());
     smallestSoFar=getSmallestHOfTwo(currentRow,smallestSoFar);
    }
    return smallestSoFar;
    }
    public void testLowestHumidityInManyFiles(){
    CSVRecord smallest=lowestHumidityInManyFiles();
    System.out.println("lowest humidity was "+ smallest.get("Humidity") +"at "+smallest.get("DateUTC"));
    }
    public double averageTemperatureInFile(CSVParser parser){
    double totalTemp=0.0;
    double count=0.0;
    for(CSVRecord currentRow  : parser){
        double currTemp=Double.parseDouble(currentRow.get("TemperatureF"));
        totalTemp=totalTemp+currTemp;
        count=count+1;
        
    
    }
    return totalTemp/count;
    }
    public void testAverageTemp(){
        FileResource fr=new FileResource("nc_weather\\2013\\weather-2013-08-10.csv");
    double average=averageTemperatureInFile(fr.getCSVParser());
    System.out.println("average temperature was "+ average);
    }
    public double averageTemperatureWithHighHumidityInFile(CSVParser parser,int value){
        double totalTemp=0.0;
        double count=0.0;
        for(CSVRecord currentRow :parser){
        if(Double.parseDouble(currentRow.get("Humidity"))>=value){
            totalTemp=totalTemp+Double.parseDouble(currentRow.get("TemperatureF"));
            count=count+1;
        
        }
        else{
        System.out.println("No temperatures with that humidity");
        }
        }
        return totalTemp/count;
    }
    public void testaverageTemperatureWithHighHumidityInFile(){
      FileResource fr=new FileResource("nc_weather\\2013\\weather-2013-09-02.csv");
    double average=averageTemperatureWithHighHumidityInFile(fr.getCSVParser(),80);
    System.out.println("average temperature at humidity greater then 80 was "+ average);
    }
    
}
