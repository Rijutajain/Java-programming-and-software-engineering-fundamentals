import edu.duke.*;
import java.io.*;
public class caeserCipher {
public String encrypt(String input,int key){
StringBuilder encrypted=new StringBuilder(input);
String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
String shiftedAlphabet=alphabet.substring(key)+alphabet.substring(0,key);
for(int i=0;i<encrypted.length();i++){
char currChar=encrypted.charAt(i);
char currCharU=Character.toUpperCase(currChar);
int idx=alphabet.indexOf(currCharU);
if(idx !=-1){
char newChar=shiftedAlphabet.charAt(idx);
if(Character.isLowerCase(currChar)){
char newCharL=Character.toLowerCase(newChar);
encrypted.setCharAt(i,newCharL);
}
if(Character.isUpperCase(currChar)){
char newCharU=Character.toUpperCase(newChar);
encrypted.setCharAt(i,newCharU);
}

}

}
return encrypted.toString();
}
public void testCaeser(){
   // int key=17;
//FileResource fr = new FileResource();
//String message = fr.asString();
//String encrypted = encrypt(message, key);
//System.out.println(encrypted);
String s1="Can you imagine life WITHOUT the internet AND computers in your pocket?";
String a1=encrypt(s1,15);
System.out.println(a1);


}
public String encryptTwoKeys(String input,int key1,int key2){
StringBuilder encrypted=new StringBuilder(input);
String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
String shiftedAlphabet1=alphabet.substring(key1)+alphabet.substring(0,key1);
String shiftedAlphabet2=alphabet.substring(key2)+alphabet.substring(0,key2);
for(int i=0;i<encrypted.length();i++){
char currChar=encrypted.charAt(i);
char currCharU=Character.toUpperCase(currChar);
int idx=alphabet.indexOf(currCharU);
if(idx !=-1 && i%2==0){
char newChar=shiftedAlphabet1.charAt(idx);
if(Character.isLowerCase(currChar)){
char newCharL=Character.toLowerCase(newChar);
encrypted.setCharAt(i,newCharL);
}
if(Character.isUpperCase(currChar)){
char newCharU=Character.toUpperCase(newChar);
encrypted.setCharAt(i,newCharU);
}

}
if(idx !=-1 && i%2!=0){
char newChar=shiftedAlphabet2.charAt(idx);
if(Character.isLowerCase(currChar)){
char newCharL=Character.toLowerCase(newChar);
encrypted.setCharAt(i,newCharL);
}
if(Character.isUpperCase(currChar)){
char newCharU=Character.toUpperCase(newChar);
encrypted.setCharAt(i,newCharU);
}
}
}
return encrypted.toString();
}
public void testEncryptTwoKeys(){
String s1="Can you imagine life WITHOUT the internet AND computers in your pocket?";
String a1=encryptTwoKeys(s1,21,8);
System.out.println(a1);
String s2="Hfs cpwewloj loks cd Hoto kyg Cyy.";
String a2=encryptTwoKeys(s2,12,2);
System.out.println(a2);
}
}
