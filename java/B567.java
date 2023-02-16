import java.util.HashMap;
import java.util.Map;

public class B567 {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        for(Character ch : s1.toCharArray()){
            need.put(ch, need.getOrDefault(ch, 0)+1);
        }
        int left = 0;
        int right = left + s1.length();
        while(right <= s2.length()){
            Map<Character, Integer> window = new HashMap<>(need);
            for(int i=left; i<right; i++){
                if(!window.containsKey(s2.charAt(i))) break;
                window.put(s2.charAt(i), window.get(s2.charAt(i))-1);
                if(window.get(s2.charAt(i)) == 0) window.remove(s2.charAt(i));
            }
            if(window.size() == 0) return true;
            right ++;
            left ++;
        }
        return false;
    }
}