import java.util.ArrayList;
import java.util.List;

public class A234 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null){
            list.add(head.val);
            head = head.next;
        }

        for(int i=0; i<list.size()/2;  i++){
            if(list.get(i) != list.get(list.size()-1-i)) return false;
        }

        return true;
    }
}
