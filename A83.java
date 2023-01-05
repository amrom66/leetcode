import java.util.HashSet;
import java.util.Set;

public class A83 {
    //1 1 2 
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dumyListNode = new ListNode(0);
        dumyListNode.next = head;
        if(head == null) return head;
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        while(head != null && head.next != null){
            if(set.contains(head.next.val)){
                head.next = head.next.next;
            }else{
                set.add(head.next.val);
                head = head.next;
            }
        }
        return dumyListNode.next;
    }
}



