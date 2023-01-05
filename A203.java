import java.util.List;
import java.util.Stack;

public class A203 {

    //head = [1,2,6,3,4,5,6], val = 6
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        if(head.val == val) {
            head.next = head.next.next;
        }
        ListNode curr = new ListNode(0);
        curr.next = head;
        while(head.next != null){
            if(head.next.val == val){
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }

        return curr.next;
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        Stack<ListNode> stack = new Stack<>();
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        ListNode tmp = null;
        while (k >0){
            tmp = stack.pop();
            k--;
        }
        return tmp;
    }
}


