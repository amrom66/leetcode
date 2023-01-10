import com.sun.source.tree.ReturnTree;
import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Offer {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int length = matrix.length;
        if(length ==0) return false;
        boolean flag = false;
        for (int i=0; i<matrix.length; i++) {
            int len = matrix[i].length;
            if(len ==0) continue;
            if (target >= matrix[i][0] && target <= matrix[i][len - 1]) {
                flag = flag || help_findNumberIn2DArray(matrix[i], target);
            }
        }
        return flag;
    }
    public boolean help_findNumberIn2DArray(int[] nums, int target){
        int left = 0;
        int right = nums.length -1;
        while (left <= right){
            int mid = left + (right-left)/2;
            if(target == nums[mid]){
                return true;
            }else if(target < nums[mid]){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }
        return false;
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A!=null && B!=null) && (help_isSubStructure(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));
    }
    public boolean help_isSubStructure(TreeNode A, TreeNode B){
        if(B ==null) return true;
        if(A ==null || A.val != B.val) return false;
        return help_isSubStructure(A.left, B.left) && help_isSubStructure(A.right, B.right);
    }

    public boolean isSymmetric(TreeNode root) {
        if(root ==null) return true;
        return help_isSymmetric(root, root);
    }
    public boolean help_isSymmetric(TreeNode left, TreeNode right){
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        return (left.val == right.val) && help_isSymmetric(left.left, right.right) && help_isSymmetric(left.right, right.left);
    }

    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode headA_copy = headA;
        ListNode headB_copy = headB;
        while (headA_copy != headB_copy){
            headA_copy = headA_copy == null ? headB : headA_copy.next;
            headB_copy = headB_copy == null ? headA : headB_copy.next;
        }
        return headA_copy;
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = mirrorTree(root.left);
        TreeNode right = mirrorTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

}
