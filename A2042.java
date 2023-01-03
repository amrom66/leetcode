import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class A2042 {
    public boolean areNumbersAscending1(String s) {
        String[] strs = s.split(" ");
        String regex = "[0-9]+[\\.]?[0-9]*";
        Integer tmp = 0;
        for(String str : strs){
            if(Pattern.matches(regex, str)) {
                if(Integer.parseInt(str) <= tmp) return false;
                tmp = Integer.parseInt(str);
            }
        }
        return true;
    }

    public char firstUniqChar(String s) {
        if(s.length() == 0) return ' ';
        Map<Character, Integer> map = new HashMap<>();
        for(Character character : s.toCharArray()){
           map.put(character, map.getOrDefault(character, 0)+1);
        }
        for(Character character : s.toCharArray()){
           if (map.get(character) == 1) return character;
        }
        return ' ';
    }

    public boolean areNumbersAscending(String s){
        String[] strs = s.split(" ");
        Integer tmp = 0;
        for(String str : strs){
            if(str.matches("^[0-9]*$")){
                if(Integer.parseInt(str) <= tmp) return false;
                tmp = Integer.parseInt(str);
            }
        }
        return true;
    }
}
