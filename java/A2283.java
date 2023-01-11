import java.util.HashMap;
import java.util.Map;
public class A2283 {
    public boolean digitCount(String num) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<num.length(); i++){
            map.put(num.charAt(i), map.getOrDefault(num.charAt(i), 0)+1);
        }
        int gap = '1'-1;
        for(int i=0; i<num.length(); i++){
            if(map.get(num.charAt(i)) != num.charAt(i)-gap) return false;
        }
        return true;
    }
}