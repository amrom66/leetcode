import java.util.HashMap;
import java.util.Map;

public class B567 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>(); //s1用
        Map<Character, Integer> window = new HashMap<>(); //s2用
        for(char ch : s1.toCharArray()) need.put(ch, need.getOrDefault(ch, 0)+1);

        int left = 0;
        int right = 0;
        int valid = 0;

        while(right < s2.length()){
            char c = s2.charAt(right);
            right ++;
            if(need.containsKey(c)){
                window.put(c, window.getOrDefault(c, 0)+1);
                if(need.get(c).equals(window.get(c))) valid ++;
            }

            while(right-left == s1.length()){
                if(valid == need.size()) return true;
                char d = s2.charAt(left);
                left ++;
                if(need.get(d).equals(window.get(d))) valid --;
                window.put(d, window.getOrDefault(d,0)-1);
            }
        }
        return false;
    }
}
