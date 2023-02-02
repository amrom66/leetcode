import java.util.HashMap;
import java.util.Map;
public class A2325 {
    public String decodeMessage(String key, String message) {
        Map<Character, Character> map = new HashMap<Character, Character>(16);
        char index = 'a';
        for(int i=0; i<key.length(); i++){
            char tmp = key.charAt(i);
            if(tmp != ' ' && !map.containsKey(tmp)){
                map.put(tmp, index);
                index ++;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<message.length(); i++){
            char tmp = message.charAt(i);
            if(tmp != ' ') tmp = map.get(tmp);
            sb.append(tmp);
        }

        return sb.toString();
    }
}