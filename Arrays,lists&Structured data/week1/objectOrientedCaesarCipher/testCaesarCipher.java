import edu.duke.*;
import java.io.*;
public class testCaesarCipher {
public int [] countLetters(String encrypted){
String alph="abcdefghijklmnopqrstuvwxyz";
int[]counts=new int[26];
for(int k=0;k<encrypted.length();k++){
char ch=Character.toLowerCase(encrypted.charAt(k));
int dex=alph.indexOf(ch);
if(dex!=-1){
counts[dex]+=1;
}
}
return counts;
}
public int maxIndex(int[] vals){
int maxdex=0;
for(int k=0;k<vals.length;k++){
if(vals[k]>vals[maxdex]){
maxdex=k;
}
}
return maxdex;
}
public void simpleTest(){
FileResource fr=new FileResource();
String message=fr.asString();
CaesarCipher cc=new CaesarCipher(18);
String enc=cc.encrypt(message);
System.out.println(enc);
String dec=cc.decrypt(enc);
System.out.println(dec);
String dec1=breakCaesarCipher(enc);
System.out.println(dec1);
}
public String breakCaesarCipher(String input){
int [] counters=countLetters(input);
int maxidx=maxIndex(counters);
int key=maxidx-4;
if(maxidx<4){
key=26-(4-maxidx);
}
CaesarCipher cc=new CaesarCipher(key);
String dec=cc.decrypt(input);
return dec;
}
}
