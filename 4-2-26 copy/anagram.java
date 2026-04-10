import java.util.Arrays;
class anagram{
     public static void main(String[] args){
        String s1 ="race";
        String s2 ="care";
        char[]a=s1.toCharArray();
        char[]b=s2.toCharArray();

        Arrays.sort(a);
        Arrays.sort(b);
        if (Arrays.equals(a,b))
            System.out.println("anagram");
        else
          System.out.println("not anagram");
    
}
}