
/**
 * Write a description of LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     
     public LogAnalyzer() {
         records=new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         FileResource fr=new FileResource(filename);
         for(String s:fr.lines()){
            LogEntry l1=WebLogParser.parseEntry(s);
            records.add(l1);
            }
     }
     public int countUniqueIPs(){
    ArrayList<String> uniqueIPs=new ArrayList<String>();
    for(LogEntry le:records){
    String IpAddr=le.getIpAddress();
    if(!uniqueIPs.contains(IpAddr)){
    uniqueIPs.add(IpAddr);
    }
    }
    return uniqueIPs.size();
    } 
    public void printAllHigherThanNum(int num){
      for(LogEntry le:records){
        int sta=le.getStatusCode();
        if(sta>num){
        System.out.println(le);
        }
        }
    
    }
    public ArrayList<String> uniqueIpVisitsOnDay(String someday){
        ArrayList<String> cat=new ArrayList<String>();
    for(LogEntry le:records){
    if(le.getAccessTime().toString().contains(someday)){
            String IpAddr=le.getIpAddress();
    if(!cat.contains(IpAddr)){
    cat.add(IpAddr);
    }
        
       
    }
    
    
    }
    return cat;
}
    public int countUniqueIPsInRange(int low,int high){
        ArrayList<String> cat=new ArrayList<String>();
    for(LogEntry le : records){
    if(le.getStatusCode()>=low && le.getStatusCode()<=high){
       String IpAddr=le.getIpAddress();
    if(!cat.contains(IpAddr)){
    cat.add(IpAddr);
    }
    }
    }
    return cat.size();
    }
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         
              System.out.println(le.getAccessTime().toString());
        }
     }
     public HashMap<String,Integer> countVisitsPerIp(){
        HashMap<String,Integer> map=new HashMap<String,Integer>();
        for(LogEntry le:records){
        String ip=le.getIpAddress();
        if(!map.containsKey(ip)){
        map.put(ip,1);
        }
        else{
        map.put(ip,map.get(ip)+1);
        }
        
        }
        return map;
        }
     public int mostNumberVisitsByIP(HashMap<String,Integer> map){
             
            
         String largest=null;
          for(String s:map.keySet()){
            if(largest==null){
            largest=s;
            }
           if(map.get(s)>map.get(largest)){
            largest=s;
            map.get(largest);
           }
        }
        return map.get(largest);
        }
      public ArrayList IpsMostVisit(HashMap<String,Integer> map){
           ArrayList<String> mostVisits=new ArrayList<String>();
           int m=mostNumberVisitsByIP(map);
           for(String s:map.keySet()){
            if(map.get(s)==m){
            mostVisits.add(s);
            
            }
            }
            return mostVisits;
        }
         public HashMap<String, ArrayList<String>> iPsForDays(){
             HashMap<String, ArrayList<String>> myMap = new HashMap<String, ArrayList<String>>();
              
            for(LogEntry le : records) {
             String date = le.getAccessTime().toString().substring(4,10);
             String ip = le.getIpAddress();
            if(!myMap.containsKey(date)) {
                ArrayList<String> myList = new ArrayList<String>();
              myList.add(ip);
             myMap.put(date, myList);
             }
            else{
            ArrayList jj=myMap.get(date);
            jj.add(ip);
            }
            
            
            }
            
            return myMap;
        }
          public String dayWithMostIPVisits(HashMap<String,ArrayList<String>>map){
            
              String largest=null;
             for(String s:map.keySet()){
               
                 if(largest==null){
            largest=s;
            }
           if(map.get(s).size()>map.get(largest).size()){
            largest=s;
           }
           }
           return largest;
         }
        public ArrayList iPsWithMostVisitsOnDay(HashMap<String,ArrayList<String>> map,String date){
            ArrayList<String> m=new ArrayList<String>();
             
             m=map.get(date);
             HashMap<String,Integer> visiterPerIP = new HashMap<String, Integer>();
        for (String s:m) {
              
              if(!visiterPerIP.containsKey(s)) {
                visiterPerIP.put(s,1);
              }
              else {
                visiterPerIP.put(s, visiterPerIP.get(s)+1);
              }
        }
        
        return IpsMostVisit(visiterPerIP);
    }
            
  }

    


