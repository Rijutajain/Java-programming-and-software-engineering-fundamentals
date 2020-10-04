import edu.duke.*;
import java.io.File;

public class PerimeterAssignmentRunner {
    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public int getNumPoints (Shape s) {
        int count=0;
        for (Point currPt : s.getPoints()) {
            count=count+1;
        }
        return count;
    }

    public double getAverageLength(Shape s) {
        double peri=getPerimeter(s);
        int sides=getNumPoints(s);
        double avg=peri/sides;
        return avg ;
    }

    public double getLargestSide(Shape s) {
        double largestsize=0;
        Point prevPt = s.getLastPoint();
         for (Point currPt : s.getPoints()) { 
            double currDist = prevPt.distance(currPt);
            prevPt = currPt;
            if(largestsize<currDist){
            largestsize=currDist;
        }
       }
            
        return largestsize;
    }

    public double getLargestX(Shape s) {
        double largestX=0;
        for (Point Pt : s.getPoints()) {
            double x=Pt.getX();
            if(largestX<x){
            largestX=x;
        }
                
            
        }
        return largestX;
    }

    public double getLargestPerimeterMultipleFiles() {
        double largestP=0;
         DirectoryResource dr=new DirectoryResource();
       for (File f : dr.selectedFiles()) {
         FileResource fr=new FileResource(f);
         Shape s=new Shape(fr);
         double length=getPerimeter(s);
         if(largestP<length){
            largestP=length;
        }
        }
        return largestP;
    }

    public String getFileWithLargestPerimeter() {
        File temp = null; 
        double largestP=0;
         DirectoryResource dr=new DirectoryResource();
       for (File f : dr.selectedFiles()) {
         FileResource fr=new FileResource(f);
         Shape s=new Shape(fr);
         double length=getPerimeter(s);
         if(largestP<length){
            largestP=length;
            temp=f;
        }
        }
       
        return temp.getName();
        
    }
    

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        System.out.println("perimeter = " + length);
        int points=getNumPoints(s);
        System.out.println("number of sides= "+points);
        double avg=getAverageLength(s);
        System.out.println("average of length is= "+avg);
        double longest=getLargestSide(s);
        System.out.println("longest side is= "+longest);
        double largex=getLargestX(s);
        System.out.println("largest X is= " +largex);
    }
    
    public void testPerimeterMultipleFiles() {
       DirectoryResource dr=new DirectoryResource();
       double largestP=getLargestPerimeterMultipleFiles();
       System.out.println("largest perimeter of shapes in all files="+largestP);
            
        }
     
    

    public void testFileWithLargestPerimeter() {
        String Name=getFileWithLargestPerimeter();
        System.out.println("Name of the file with largest perimeter="+Name);
        
    }

    // This method creates a triangle that you can use to test your other methods
    public void triangle(){
        Shape triangle = new Shape();
        triangle.addPoint(new Point(0,0));
        triangle.addPoint(new Point(6,0));
        triangle.addPoint(new Point(3,6));
        for (Point p : triangle.getPoints()){
            System.out.println(p);
        }
        double peri = getPerimeter(triangle);
        System.out.println("perimeter = "+peri);
    }

    // This method prints names of all files in a chosen folder that you can use to test your other methods
    public void printFileNames() {
        DirectoryResource dr = new DirectoryResource();
        for (File f : dr.selectedFiles()) {
            System.out.println(f);
        }
    }

    public static void main (String[] args) {
        PerimeterAssignmentRunner pr = new PerimeterAssignmentRunner();
        pr.testPerimeter();
    }
}
    

