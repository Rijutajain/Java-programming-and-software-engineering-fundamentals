
public class wordPlay {
    public Boolean isVowel(char ch){
        char v=Character.toLowerCase(ch);
        if(v=='a' || v=='e' || v=='i' || v=='o' || v=='i'){
        return true;
        }
        else{
        return false;
        }
    
    
    }
    public void testIsVowel(){
    Boolean answer1=isVowel('f');
    System.out.println(answer1);
    Boolean answer2=isVowel('H');
    System.out.println(answer2);
    Boolean answer3=isVowel('a');
    System.out.println(answer3);
    Boolean answer4=isVowel('I');
    System.out.println(answer4);
    
    
    }
    public String replaceVowels(String phrase,char ch){
    StringBuilder encrypted=new StringBuilder(phrase);
    for(int i=0;i<encrypted.length();i++){
    char currChar=encrypted.charAt(i);
    if(isVowel(currChar)==true){
    encrypted.setCharAt(i,ch);
    }
    }
    return encrypted.toString();
    }
    public void testReplaceVowels(){
    String s1="Hello World";
    String r1=replaceVowels(s1,'*');
    System.out.println(r1);
    String s2="HELLO WORLD";
    String r2=replaceVowels(s2,'*');
    System.out.println(r2);
    }
    public String emphasize(String phrase,char ch){
    StringBuilder encrypted=new StringBuilder(phrase);
    char ch1=Character.toLowerCase(ch);
    for(int i=0;i<encrypted.length();i++){
    char currChar=encrypted.charAt(i);
    char currChar1=Character.toLowerCase(currChar);
    if(currChar1==ch1){
    if(i%2==0){
    encrypted.setCharAt(i,'*');
    }
    else{
    encrypted.setCharAt(i,'+');
    }
    }
    
    }
    return encrypted.toString();
    }
    public void testEmphasize(){
    String s1="mary bella abracadabra";
    String e1=emphasize(s1,'a');
    System.out.println(e1);
    String s2="PROGRAMMING IS EASY";
    String e2=emphasize(s2,'I');
    System.out.println(e2);
    }

}
