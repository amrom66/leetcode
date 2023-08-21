public class A58 {
    public int lengthOfLastWord(String s) {
        if(s.charAt(s.length()-1) == ' ') return lengthOfLastWord(s.substring(0, s.length()-1));
        int len = 0;
        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i) != ' ') len ++;
            else break;
        }
        return len;
    }
}
