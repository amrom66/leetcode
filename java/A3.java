import java.util.HashMap;
import java.util.Map;

public class A3 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int len = 0;

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                len = Math.max(len, i - map.get(s.charAt(i)));
            }
            map.put(s.charAt(i), i);
        }

        return len;
    }
}
