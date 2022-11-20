import java.util.*;

public class A206 {
    //head = [1,2,3,4,5] to [5,4,3,2,1]
    public ListNode reverseList(ListNode head) {
        ListNode curr = new ListNode(0);
        ListNode copy = head;
        curr.next = copy;
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }
        for(int i=list.size()-1; i>=0; i--){
            ListNode tmp = new ListNode(list.get(i));
            copy.next = tmp;
            copy = copy.next;
        }
        return curr.next;
    }
}



class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
