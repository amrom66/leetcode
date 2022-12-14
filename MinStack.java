import java.util.Stack;

public class MinStack {

    Stack<Integer> stack = new Stack<>();

    Stack<Integer> stack2 = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {

    }
    
    public void push(int x) {
        if(stack.isEmpty()){
            stack2.push(x);
        }else{
            stack2.push(Math.min(x, stack2.peek()));
        }
        stack.push(x);
    }
    
    public void pop() {
        stack.pop();
        stack2.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int min() {
        return stack2.peek();
    }
}

