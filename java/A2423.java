import java.util.HashSet;
import java.util.Set;

public class A2423 {
    public boolean equalFrequency(String word) {
        int length = word.length();
        Set<Character> set = new HashSet<>();
        boolean flag = false;
        for (int i = 0; i < length; i++) {
            if (set.contains(word.charAt(i))) {
                flag = true;
            }
            set.add(word.charAt(i));
        }

        return set.size() == length-1 ;
    }
}