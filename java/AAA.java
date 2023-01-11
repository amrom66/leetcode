import java.util.Arrays;

public class AAA {

    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == ' '){
                sb.append("%20");
            }else{
                sb.append(s.charAt(i));
            }
        }
        return new String(sb);
    }

    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        char[] tmp1 = Arrays.copyOfRange(chars, 0, n);
        char[] tmp2 = Arrays.copyOfRange(chars, n, chars.length);
        System.arraycopy(tmp2, 0, chars, 0, tmp2.length);
        System.arraycopy(tmp1, 0, chars, tmp2.length, tmp1.length);
        return new String(chars);
    }
    
}
