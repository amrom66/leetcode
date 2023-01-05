import java.lang.reflect.Array;
import java.util.*;

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

    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length <nums2.length) return intersect(nums2, nums1);
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for(Integer num : nums1){
            map1.put(num, map1.getOrDefault(num, 0)+1);
        }
        for(Integer num : nums2) {
            map2.put(num, map2.getOrDefault(num,0)+1);
        }
        int[] nums = new int[nums2.length];
        int index = 0;
        for(Map.Entry<Integer, Integer> entry : map2.entrySet()){
            int repeat = Math.min(entry.getValue(), map1.getOrDefault(entry.getKey(),0));
            while (repeat >0){
                nums[index] = entry.getKey();
                index ++;
                repeat --;
            }
        }
        return Arrays.copyOf(nums,index);
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1000,1000,1000};
        int[] nums2 = new int[]{1000,1000};
        int[] out = new A203().intersect(nums1, nums2);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(nums1.length < nums2.length){
            merge(nums2, n, nums1, m);
            return;
        }
        int index = m+n-1;
        while(m >=1 && n>=1){
            if(nums1[m-1] >= nums2[n-1]){
                nums1[index--] = nums1[m-1];
                m--;
            }else{
                nums1[index--] = nums2[n-1];
                n--;
            }
        }
        if(n>=1){
            System.arraycopy(nums2, 0, nums1, 0, n);
        }
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


