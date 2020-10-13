public class exportdata {
 public void tester(){
      FileResource fr = new FileResource();
      CSVParser parser = fr.getCSVParser();
      String country="Nauru";
      String a1=countryInfo(parser,country);
      System.out.println(a1);
      parser = fr.getCSVParser();
      listExportersTwoProducts(parser,"cotton","flowers");
      parser = fr.getCSVParser();
      String exportItem="cocoa";
      int a2=numberOfExporters(parser,exportItem);
      System.out.println("number of countries export cocoa= " + a2);
      parser = fr.getCSVParser();
      bigExporters(parser,"$999,999,999,999");
 
    
    }
    public String countryInfo(CSVParser parser,String country){
        for (CSVRecord record : parser){
                   String dog=record.get("Country");
            if(dog.contains(country)){
                return record.get("Country")+": "+ record.get("Exports")+" : "+record.get("Value (dollars)");
            }
        }
        return "NOT FOUND";        
    }
    public void listExportersTwoProducts(CSVParser parser,String export1,String export2){
        for (CSVRecord record : parser){
                   String export=record.get("Exports");
                   if((export.contains(export1))  && (export.contains(export2))){
                    System.out.println(record.get("Country"));
                    }
    
                }
    }
    public int numberOfExporters(CSVParser parser,String exportItem){
        int count=0;
       for(CSVRecord record : parser){
        String cat=record.get("Exports");
        if(cat.contains(exportItem)){
        count=count+1;
        }
         
        
        }
        return count;
    
    }
    public void bigExporters(CSVParser parser,String amount){
    for(CSVRecord record :parser){
    String cap=record.get("Value (dollars)");
    if(amount.length()<cap.length()){
    System.out.println(record.get("Country") + ": " + record.get("Value (dollars)"));
    }
    }
    
    }
     
}
