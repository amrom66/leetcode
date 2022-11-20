import java.util.*;

public class A242 {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for(int i=0; i<s.length(); i++){
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0)+1);
        }
        for(int i=0; i<t.length(); i++){
            map2.put(t.charAt(i), map2.getOrDefault(t.charAt(i), 0)+1);
        }
        if(map1.size() != map2.size()) return false;
        for(Map.Entry<Character, Integer> entry: map1.entrySet()){
            if(map2.getOrDefault(entry.getKey(), 0) != entry.getValue()) return false;
        }
        return true;
    }
}
