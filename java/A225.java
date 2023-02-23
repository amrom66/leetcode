import java.util.ArrayDeque;
import java.util.Queue;

public class A225 {
    Queue<Integer> q1 ;
    Queue<Integer> q2 ;
    public A225() {
        q1 = new ArrayDeque<>();
        q2 = new ArrayDeque<>();
    }
    
    public void push(int x) {
        q2.offer(x);
        while(!q1.isEmpty()){
            q2.offer(q1.poll());
        }
        Queue<Integer> queue = q1;
        q1 = q2;
        q2 = queue;
    }
    
    public int pop() {
        return q1.poll();
    }
    
    public int top() {
        return q1.peek();
    }
    
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }
}
