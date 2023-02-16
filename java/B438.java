import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class B438 {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s.length() < p.length()) return res;
        Map<Character, Integer> need = new HashMap<>();
        for(char ch : p.toCharArray()) need.put(ch, need.getOrDefault(need, need.getOrDefault(ch, 0)+1));
        int left = 0;
        int right = left + p.length();
        while(right <= s.length()){
            Map<Character, Integer> window = new HashMap<>(need);
            for(int i=left; i<right; i++){
                char tmp = s.charAt(i);
                if(!window.containsKey(tmp)) break;
                window.put(tmp, window.get(tmp)-1);
                if(window.get(tmp) == 0) window.remove(tmp);
            }
            if(window.size() == 0) res.add(left);
            left ++;
            right ++;
        }
        return res;
    }
}