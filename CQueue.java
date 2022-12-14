import java.util.Stack;

public class CQueue {

    Stack<Integer> stack1 = new Stack<>();  //入队列
    Stack<Integer> stack2 = new Stack<>();  //出队列

    public CQueue() {

    }
    
    public void appendTail(int value) {
        stack1.push(value);
    }
    
    public int deleteHead() {
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) stack2.push(stack1.pop());
        }
        return stack2.isEmpty() ? -1 : stack2.pop();
    }
}