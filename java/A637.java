import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
public class A637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> lists = new ArrayList<>();
        if(root == null) return lists;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            double sum =0.0;
            for(int i=0;i<size; i++){
                TreeNode node = queue.poll();
                sum = sum + node.val;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            Double val = sum/size;
            lists.add(val);
        }

        return lists;
    }
}