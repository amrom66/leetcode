import java.util.ArrayList;
import java.util.List;

public class A94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        help(root, list);
        return list;
    }

    public void help(TreeNode root, List list){
        if(root == null) return;
        if(root.left != null) {
            help(root.left, list);
        }
        list.add(root.val);
        if(root.right != null){
            help(root.right, list);
        }
    }
}