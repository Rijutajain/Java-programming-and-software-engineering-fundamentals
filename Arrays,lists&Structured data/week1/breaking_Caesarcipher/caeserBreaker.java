import edu.duke.*;
import java.io.*;
public class caeserBreaker {
public String decrypt(String encrypted){
caeserCipher cc=new caeserCipher();
int [] freqs=countLetters(encrypted);
int maxdex=maxIndex(freqs);
int dkey=maxdex-4;
if(maxdex<4){
dkey=26-(4-maxdex);
}
return cc.encrypt(encrypted,26-dkey);
}
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
public void testDecrypt(){
String enc="a txh a ttFlh lWd.Pxxx";
String dec1=decrypt(enc);
System.out.println(dec1);
}
public String halfOfString(String message,int start){
StringBuilder half=new StringBuilder();
for(int i=0;(start+i)<message.length();i++){
if(start%2==0){
    if((start+i)%2==0){
half.append(message.charAt(start+i));
}
}
else if(start%2!=0){
if((start+i)%2!=0){
half.append(message.charAt(start+i));
}
}
}
return half.toString();
}
public void testHalfOfString(){
String s1="Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!";
String a1=halfOfString(s1,0);
System.out.println(a1);
String a2=halfOfString(s1,1);
System.out.println(a2);
}
public int getKey(String s){
int [] x=countLetters(s);
int y=maxIndex(x);
int key=y-4;
if(y<4){
key=26-(4-y);
}
return key;
}
public void testGetKey(){
String s1="jggkqg";
int k=getKey(s1);
System.out.println(k);

}
public String decryptTwoKeys(String encrypted){
caeserCipher cc=new caeserCipher();
String even=halfOfString(encrypted,0);
String odd=halfOfString(encrypted,1);
int evenkey=getKey(even);
int oddkey=getKey(odd);
System.out.println("key for even String= "+evenkey);
System.out.println("key for odd String= "+oddkey);
String dec=cc.encryptTwoKeys(encrypted,26-evenkey,26-oddkey);
return dec;
}
public void testDecryptTwoKeys(){
caeserCipher cc=new caeserCipher();
FileResource fr = new FileResource();
String message = fr.asString();
String a3 = decryptTwoKeys(message);
System.out.println(a3);
String s1="Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!";
String a1=decryptTwoKeys(s1);
System.out.println(a1);
//String s2="Akag tjw Xibhr awoa aoee xakex znxag xwko";
//String a2=decryptTwoKeys(s2);
//System.out.println(a2);
}
}
