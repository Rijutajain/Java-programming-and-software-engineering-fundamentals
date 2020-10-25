public class CaesarCipherTwo {
private String alpha;
private String shiftedAlpha1;
private String shiftedAlpha2;
private int mainKey1;
private int mainKey2;
public CaesarCipherTwo(int key1,int key2){
alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
shiftedAlpha1=alpha.substring(key1)+alpha.substring(0,key1);
shiftedAlpha2=alpha.substring(key2)+alpha.substring(0,key2);
mainKey1=key1;
mainKey2=key2;
}
public String encrypt(String input){
 StringBuilder enc=new StringBuilder(input);
 for(int i=0;i<input.length();i++){
    char currchar=input.charAt(i);
    int index=alpha.indexOf(currchar);
    if(i%2==0 && index!=-1){
    char evenchar=shiftedAlpha1.charAt(index);
    if(Character.isLowerCase(currchar)){
        Character.toLowerCase(evenchar);
    }
    enc.setCharAt(i,evenchar);
    }
      if(i%2!=0 && index!=-1){
    char oddchar=shiftedAlpha2.charAt(index);
      if(Character.isLowerCase(currchar)){
        Character.toLowerCase(oddchar);
    }
    enc.setCharAt(i,oddchar);
    }
    }   
    return enc.toString();
}
public String decrypt(String input){
CaesarCipherTwo cc=new CaesarCipherTwo(26-mainKey1,26-mainKey2);
String dec=cc.encrypt(input);
return dec;
}
}
