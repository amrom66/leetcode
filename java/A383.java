import java.util.HashMap;
import java.util.Map;
public class A383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int length1 = ransomNote.length();
        int length2 = magazine.length();
        if(length1 > length2) return false;
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        for(int i=0; i<length1; i++){
            map1.put(ransomNote.charAt(i), map1.getOrDefault(ransomNote.charAt(i), 0)+1);
        }
        for(int i=0; i<length2; i++){
            map2.put(magazine.charAt(i), map2.getOrDefault(magazine.charAt(i), 0)+1);
        }
        for(Map.Entry<Character, Integer> entry: map1.entrySet()){
            if(map2.getOrDefault(entry.getKey(), 0) < entry.getValue()) return false;
        }
        return true;
    }
    
}
