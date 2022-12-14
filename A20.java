import java.util.Stack;

public class A20 {
    //s = "()[]{}"
    public boolean isValid(String s) {
        int length = s.length();
        if(length%2 !=0) return false;
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<length; i++){
            Character ch = s.charAt(i);
            switch (ch) {
                case '(':
                    stack.push(')');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case '[':
                    stack.push(']');
                    break;
                default:
                    if(stack.isEmpty() || ch!= stack.pop()) return false;
                    break;
            }
        }
        return stack.size() %2 ==0;
    }
}
