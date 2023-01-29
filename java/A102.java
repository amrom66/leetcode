import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class A102{
    // middle
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return null;
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        help(root, lists, 0);
        return lists;
    }

    public void help(TreeNode root, List<List<Integer>> lists, int level){
        if(root == null) return ;
        if(lists.size() <= level){
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            lists.add(list);
        }else{
            lists.get(level).add(root.val);
        }
        help(root.left, lists, level+1);
        help(root.right, lists, level+1);
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        if(root == null) return null;
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>(size);
            for(int i=0; i<size; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right !=null) queue.add(node.right);
            }
            lists.add(list);
        }
        return lists;
    }
}