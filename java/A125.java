public class A125{
     public boolean isPalindrome(String s) {
        String pattern = "[^a-zA-Z0-9]";
        String replacement = "";
        String result = s.replaceAll(pattern, replacement).toLowerCase();
        System.out.println(result);
        for(int i=0; i<result.length()/2; i++){
            if(result.charAt(i) != result.charAt(result.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}