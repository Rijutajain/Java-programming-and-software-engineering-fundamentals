public class CaesarCipher {
  private String alpha;
  private String shiftedAlpha;
  private int mainKey;
  public CaesarCipher(int key){
   alpha="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
   shiftedAlpha=alpha.substring(key)+alpha.substring(0,key);
   mainKey=key;
    }
  public String encrypt(String input){
      StringBuilder encrypted=new StringBuilder(input);
      for(int i=0;i<input.length();i++){
            char ch=input.charAt(i);
            int index=alpha.indexOf(ch);
            if(index!=0){
            char newch=shiftedAlpha.charAt(index);
            encrypted.setCharAt(i,newch);
            }
        }
  return encrypted.toString();
    }
  public String decrypt(String input){
      CaesarCipher cc=new CaesarCipher(26-mainKey);
      String dec=cc.encrypt(input);
      return dec;
    }
    
}
