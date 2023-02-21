import java.util.HashSet;
import java.util.Set;

public class A160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode listNode = new ListNode(-1);
        Set<ListNode> set = new HashSet<>();
        while(headA != null){
            set.add(headA);
            headA = headA.next;
        }

        while(headB!=null){
            if(set.contains(headB)){
                listNode.next = headB;
                return listNode;
            }
            headB = headB.next;
        }
        return listNode;
    }
}
