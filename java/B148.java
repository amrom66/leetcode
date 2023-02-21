public class B148 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(3);
        new B148().sortList(listNode);
    }
    public ListNode sortList(ListNode head) {
        ListNode res = null;
        while(head != null){
            res = help(res, head.val);
            head = head.next;
        }
        return res;
    }

    public ListNode help(ListNode head, int val){
        if(head == null) {
            head = new ListNode(val);
            return head;
        }
        if(head.next == null){
            if(val < head.val) {
                ListNode node = new ListNode(val);
                node.next = head;
                return node;
            }
            head.next = new ListNode(val);
            return head;
        }
        if(val < head.val){
            ListNode node = new ListNode(val);
            node.next = head;
            return node;
        }

        ListNode currNode = new ListNode();
        currNode.next = head;
        while(head.next != null){
            if(head.val <= val && head.next.val >= val){
                ListNode node = new ListNode(val);
                node.next = head.next;
                head.next = node;
                return currNode.next;
            }
            head = head.next;
        }
        head.next = new ListNode(val);
        return currNode.next;
    }
}