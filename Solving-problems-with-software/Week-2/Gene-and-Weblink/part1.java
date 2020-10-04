import edu.duke.*;
import java.io.*;

public class part1 {
	public String findSimpleGene(String dna) {
		int start = dna.indexOf("atg");
		if (start == -1) {
			return "";
		}
		int stop = dna.indexOf("taa", start+3);
		if(stop == -1){
		  return "";
                }
		if ((stop - start) % 3 == 0) {
			return dna.substring(start, stop+3);
		}
		else {
			return "";
		}
	}
	
	public void testSimpleGene() {
		String a = "cccgggtttaaataataataggagagagagagagagttt";
		String b = "atggggttattatag";
		String c = "atgcctaa";
		String d = "attagttgattatga";
		String e = "accatggactaagttgataacgt";
		
		String result = findSimpleGene(e);
		System.out.println("string is=" +e);
		System.out.println("gene is="+result);
		
	}
}
