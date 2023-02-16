import java.util.HashSet;
import java.util.Set;

public class A1763 {
    public String longestNiceSubstring(String s) {
        int length = s.length();
        while(length >1){
            String res = help(s, length);
            if(res != null) return res;
            length --;
        }
        return "";
    }
    
    public String help(String s, int length){
        int gap = 'a'-'A';
        int left = 0;
        int right = left + length;
        while(right <= s.length()){
            Set<Character> set = new HashSet<Character>();
            for(int i=left; i<right; i++) {
                set.add(s.charAt(i));
            }
            Set<Character> copy = new HashSet<>();
            for(Character ch : set){
                if(ch >= 'A' && ch <= 'Z' && set.contains((char) (ch +gap))){
                    copy.add(ch);
                }
                if(ch >='a' && ch <= 'z' && set.contains((char) (ch -gap))){
                    copy.add(ch);
                }
            }
            if(set.size() == copy.size()) return s.substring(left, right);
            left ++;
            right ++;
        }

        return null;
    }

    public static void main(String[] args) {
        String s = "YazaAay";
        String out = new A1763().longestNiceSubstring(s);
        System.out.println(out);
    }
    
}
