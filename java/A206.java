import java.util.*;

public class A206 {
    //head = [1,2,3,4,5] to [5,4,3,2,1]
    public ListNode reverseList(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        ListNode newNode = new ListNode(0);
        ListNode curr = newNode;

        for(int i=list.size()-1; i>=0; i--){
           curr.next = new ListNode(list.get(i));
           curr = curr.next;
        }
        return newNode.next;
    }
}

