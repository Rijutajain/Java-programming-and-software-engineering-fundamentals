import edu.duke.*;
import java.io.*;

public class part2 {
     public String findSimpleGene(String dna,String startcodon,String stopcodon) {
	        int upper=0,lower=0;
		int start = dna.indexOf(startcodon);
		if (start == -1) {
			return "";
		}
		int stop = dna.indexOf(stopcodon, start+3);
		if(stop == -1){
		  return "";
                }
		if ((stop - start) % 3 == 0) {
			String pea= dna.substring(start, stop+3);
			if(dna==dna.toUpperCase())
			{
			 return pea.toUpperCase();
			 }
			 else if(dna==dna.toLowerCase())
			 {
			 return pea.toLowerCase();
			 }
		}
		else
		{
	        return "";
		}
		return "";
		
                }

	
	public void testSimpleGene() {
		String a = "cccgggtttaaataataataggagagagagagagagttt";
		String b = "atggggttattatag";
		String c = "atgcctaa";
		String d = "attagttgattatga";
		String e = "accatggactaagttgataacgt";
		String f = "ACCATGGACTAAGTTGATAACGT";
		String sta="atg";
		String sto="taa";
		String STA="ATG";
		String STO="TAA";
		String result = findSimpleGene(f,STA,STO);
		System.out.println("string is=" +f);
		System.out.println("gene is="+result);
		
	}
}
