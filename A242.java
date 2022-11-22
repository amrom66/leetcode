import java.util.*;

public class A242 {
    public boolean isAnagram(String s, String t) {
        int length1 = s.length();
        int length2 = t.length();
        if(length1 != length2) return false;
        char[] ch1 = s.toCharArray();
        Arrays.sort(ch1);
        char[] ch2 = t.toCharArray();
        Arrays.sort(ch2);
        for(int i=0; i<length1; i++){
            if(ch1[i] != ch2[i]) return false;
        }
        return true;
    }
}
