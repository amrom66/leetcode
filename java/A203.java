import com.sun.source.tree.Tree;

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

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        lists.add(list);
        if(numRows ==1) return lists;
        for(int i=2; i<=numRows; i++){
            Integer[] nums = new Integer[i];
            nums[0] = 1;
            for(int j=1; j<nums.length-1; j++){
                nums[j] = lists.get(i-2).get(j-1) + lists.get(i-2).get(j);
            }
            nums[nums.length-1] = 1;
            lists.add(Arrays.asList(nums));
        }
        return lists;
    }
    public static void main(String[] args) {
        List out = new A203().generate(5);

    }

    public List<List<Integer>> levelOrder(TreeNode root) {
       List<List<Integer>> lists = new ArrayList<>();
       if(root == null) return lists;
       Queue<TreeNode> queue = new ArrayDeque<>();
       queue.add(root);
       while (!queue.isEmpty()){
           int size = queue.size();
           List<Integer> list = new ArrayList<>();
           for(int i=0; i<size; i++){
               TreeNode node = queue.poll();
               if(node.left != null) queue.add(node.left);
               if(node.right != null) queue.add(node.right);
               list.add(node.val);
           }
           if(lists.size() % 2 ==0){
               lists.add(list);
           }else {
               lists.add(help(list));
           }
       }
       return lists;
    }

    public List<Integer> help(List<Integer> list){
        for(int i=0; i<list.size()/2; i++){
            int tmp = list.get(i);
            list.set(i, list.get(list.size()-1 - i));
            list.set(list.size()-1-i, tmp);
        }
        return list;
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


