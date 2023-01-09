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
        if(A==null || B==null) return false;
        List<Integer> list_a = new ArrayList<>();
        list_a = help_isSubStructure(A, list_a);
        List<Integer> list_b = new ArrayList<>();
        list_b = help_isSubStructure(B, list_b);

        for(int i=0; i<list_a.size()-list_a.size(); i++){
            List<Integer> tmp = list_a.subList(i, i+list_b.size());
            boolean flag = true;
            for(int j=0; j<tmp.size(); j++){
                if(tmp.get(j) != list_b.get(j)) flag = false;
            }
            if(flag) return true;
        }
        return false;
    }
    public List<Integer> help_isSubStructure(TreeNode root, List<Integer> list){
        if(root == null) return list;
        list.add(root.val);
        if(root.left != null) {
            help_isSubStructure(root.left, list);
        }else {
            list.add(null);
        }
        if(root.right != null){
            help_isSubStructure(root.right, list);
        }else {
            list.add(null);
        }
        return list;
    }

}
