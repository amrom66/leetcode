public class A21 {
    /**
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode preHead = new ListNode(-1);
        ListNode pre = preHead;
        while(list1 != null && list2 != null){
            if(list1.val > list2.val){
                pre.next = list2;
                list2 = list2.next;
            }else{
                pre.next = list1;
                list1 = list1.next;
            }
            pre = pre.next;
        }
        if(list1 != null) pre.next = list1;
        if(list2 != null) pre.next = list2;
        return preHead.next;
    }
}

