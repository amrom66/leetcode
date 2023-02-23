import java.util.ArrayList;
import java.util.List;

public class A67 {
    public static void main(String[] args) {
        String a = "100";
        String b = "110010";
        new A67().addBinary(a, b);
    }
    public String addBinary(String a, String b) {
        int len1 = a.length();
        int len2 = b.length();
        if(len1 < len2) return addBinary(b,a);
        int carry = 0;
        List<Character> list = new ArrayList<>();

        for(int i=0; i<len2; i++){
            char c1 = a.charAt(len1-1-i);
            char c2 = b.charAt(len2-1-i);
            int i1 = c1 == '0' ? 0 : 1;
            int i2 = c2 == '0' ? 0 : 1; 
            int value = i1 + i2 + carry;
            carry = value / 2;
            value = value % 2;
            list.add(0, value == 0 ? '0' : '1');
        }

        for(int i=len1-len2-1; i>=0; i--){
            char c1 = a.charAt(i);
            int i1 = c1 == '0' ? 0 : 1;
            int value = i1 + carry;
            carry = value / 2;
            value = value % 2;
            list.add(0, value == 0 ? '0' : '1');
        }

        if(carry == 1) list.add(0, '1');
        
        StringBuilder sb = new StringBuilder();
        for(Character num : list){
            sb.append(num);
        }
        return sb.toString();
    }
}
