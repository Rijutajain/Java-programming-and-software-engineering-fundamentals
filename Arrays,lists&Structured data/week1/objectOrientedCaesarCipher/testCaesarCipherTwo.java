import edu.duke.*;
import java.io.*;
public class testCaesarCipherTwo {
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
public int maxIndex(int[] vals){
int maxdex=0;
for(int k=0;k<vals.length;k++){
if(vals[k]>vals[maxdex]){
maxdex=k;
}
}
return maxdex;
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
public void simpleTests(){
FileResource fr=new FileResource();
String message=fr.asString();
CaesarCipherTwo cc=new CaesarCipherTwo(17,3);
String enc=cc.encrypt(message);
System.out.println(enc);
String dec=cc.decrypt(enc);
System.out.println(dec);
String dec1=breakCaesarCipher(enc);
System.out.println(dec1);
}
public String breakCaesarCipher(String input){
String even=halfOfString(input,0);
String odd=halfOfString(input,1);
int [] counterseven=countLetters(even);
int maxidxeven=maxIndex(counterseven);
int key1=maxidxeven-4;
if(maxidxeven<4){
key1=26-(4-maxidxeven);
}
int [] countersodd=countLetters(odd);
int maxidxodd=maxIndex(countersodd);
int key2=maxidxodd-4;
if(maxidxodd<4){
key2=26-(4-maxidxodd);
}
CaesarCipherTwo cc=new CaesarCipherTwo(key1,key2);
String dec=cc.decrypt(input);
return dec;
}
}
