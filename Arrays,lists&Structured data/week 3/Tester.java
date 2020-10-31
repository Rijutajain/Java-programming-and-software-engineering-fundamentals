
/**
 * Write a description of Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        LogAnalyzer ll=new LogAnalyzer();
        ll.readFile("weblog1_log");
        ll.printAll();
    }
    public void testUniqueIp(){
     LogAnalyzer ll=new LogAnalyzer();
     ll.readFile("weblog2_log");
     int ip=ll.countUniqueIPs();
     System.out.println(ip);
    }
    public void testPrintAllHigherThanNum(){
     LogAnalyzer ll=new LogAnalyzer();
     ll.readFile("weblog2_log");
     ll.printAllHigherThanNum(400);
    }
     public void testUniqueIpVisitsOnDay(){
          LogAnalyzer ll=new LogAnalyzer();
         
          ll.readFile("weblog2_log");
          ArrayList<String> cat=ll.uniqueIpVisitsOnDay("Mar 24");
           System.out.println(cat);
          System.out.println(cat.size());
    }
    public void testCountUniqueIPsInRange(){
    LogAnalyzer ll=new LogAnalyzer();
    ll.readFile("weblog2_log");
    int count=ll.countUniqueIPsInRange(200,299);
      System.out.println(count);
    }
    public void testCountVisitsPerIp(){
    LogAnalyzer ll=new LogAnalyzer();
    ll.readFile("weblog2_log");
    HashMap<String,Integer> map=ll.countVisitsPerIp();
    System.out.println(map);
    }
    public void testMostNumberVisitsByIP(){
    LogAnalyzer ll=new LogAnalyzer();
    ll.readFile("weblog2_log");
    HashMap<String,Integer> counts= ll.countVisitsPerIp();
    int max=ll.mostNumberVisitsByIP(counts);
    System.out.println(max);
    
    }
    public void testIpsMostVisit(){
     LogAnalyzer ll=new LogAnalyzer();
    ll.readFile("weblog2_log");
    HashMap<String,Integer> counts= ll.countVisitsPerIp();
    ArrayList max=ll.IpsMostVisit(counts);
    System.out.println(max);
    }
    public void testiPsForDays(){
      LogAnalyzer ll=new LogAnalyzer();
    ll.readFile("weblog1_log");
    HashMap<String,ArrayList<String>> counts=ll.iPsForDays();
    System.out.println(counts);
    }
    public void testDayWithMostIPVisits(){
      LogAnalyzer ll=new LogAnalyzer();
    ll.readFile("weblog2_log");
    HashMap<String, ArrayList<String>> k= ll.iPsForDays();
    String day=ll.dayWithMostIPVisits(k);
    System.out.println(day);
    }
    public void testIPsWithMostVisitsOnDay(){
    LogAnalyzer ll=new LogAnalyzer();
    ll.readFile("weblog1_log");
    HashMap<String, ArrayList<String>> k= ll.iPsForDays();
    ArrayList n=ll.iPsWithMostVisitsOnDay(k,"Mar 17");
    System.out.println(n);
    }
}
