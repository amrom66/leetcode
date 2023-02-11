import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class A17 {

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }
        Map<Character, String> phoneMap = new HashMap<>();
        phoneMap.put('2', "abc");
        phoneMap.put('3', "def");
        phoneMap.put('4', "ghi");
        phoneMap.put('5', "jkl");
        phoneMap.put('6', "mno");
        phoneMap.put('7', "pqrs");
        phoneMap.put('8', "tuv");
        phoneMap.put('9', "wxyz");
        backTrack(res, digits, 0, phoneMap, new StringBuffer());

        return res;
    }


    public void backTrack(List<String> res, String digits, int index, Map<Character, String> phoneMap, StringBuffer sb){
        if(sb.length() == digits.length()) {
            res.add(sb.toString());
        }else{
            String letters = phoneMap.get(digits.charAt(index));
            for(int i=0; i<letters.length(); i++){
                sb.append(letters.charAt(i));
                backTrack(res, digits, index++, phoneMap, sb);
                sb.deleteCharAt(index);
            }
        }
    }
}