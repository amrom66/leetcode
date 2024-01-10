public class A2696 {
    public int minLength(String s) {
        while (s.length() >1) {
            int len1 = s.length();
            s = s.replace("AB", "");
            s = s.replace("CD", "");
            int len2 = s.length();
            if(len1 == len2) break;
        }
        return s.length();
    }
}
