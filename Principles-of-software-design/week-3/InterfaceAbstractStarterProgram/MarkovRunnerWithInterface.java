
/**
 * Write a description of class MarkovRunner here.
 * 
 * @author Duke Software
 * @version 1.0
 */

import edu.duke.*; 

public class MarkovRunnerWithInterface {
    public void runModel(IMarkovModel markov, String text, int size,int seed) {
        markov.setTraining(text);
        markov.setRandom(seed);
        System.out.println(markov);
        
        for(int k=0; k < 3; k++){
			String st= markov.getRandomText(size);
			printOut(st);
		}
    }
    
    public void runMarkov() {
        FileResource fr = new FileResource();
		String st = fr.asString();
		st = st.replace('\n', ' ');
		int size = 200;
		int seed=44;
		
        MarkovZero mz = new MarkovZero();
        runModel(mz, st, size, seed);
    
        MarkovOne mOne = new MarkovOne();
        runModel(mOne, st, size, seed);
        
        MarkovModel mThree = new MarkovModel(3);
        runModel(mThree, st, size, seed);
        
        MarkovFour mFour = new MarkovFour();
        runModel(mFour, st, size, seed);

    }

	private void printOut(String s){
		String[] words = s.split("\\s+");
		int psize = 0;
		System.out.println("----------------------------------");
		for(int k=0; k < words.length; k++){
			System.out.print(words[k]+ " ");
			psize += words[k].length() + 1;
			if (psize > 60) {
				System.out.println();
				psize = 0;
			}
		}
		System.out.println("\n----------------------------------");
	}
	public void testHashmap(){
	        EfficientMarkovModel em=new EfficientMarkovModel(5);
	          FileResource fr = new FileResource();
		String s = fr.asString();
		s = s.replace('\n', ' ');
	        em.setTraining(s);
                em.setRandom(615);
                em.printHashmapInfo();
	        String st= em.getRandomText(50);
                printOut(st);
	   }
	public void compareMethods(){
	        FileResource fr = new FileResource();
		String s = fr.asString();
		s = s.replace('\n', ' ');
	        MarkovModel m1=new MarkovModel(2);
	        EfficientMarkovModel m2=new EfficientMarkovModel(2);
	        m1.setRandom(42);
	        m2.setRandom(42);
	        m1.setTraining(s);
	        m2.setTraining(s);
	        
	        
	             for(int k=0; k < 3; k++){
			String st1= m1.getRandomText(1000);
			printOut(st1);
		}
		     for(int k=0; k < 3; k++){
			String st2= m2.getRandomText(1000);
			printOut(st2);
		}
	}
}
