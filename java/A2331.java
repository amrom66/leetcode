public class A2331 {
    public boolean evaluateTree(TreeNode root) {
        if(root.val == 2) {
            return evaluateTree(root.left) || evaluateTree(root.right);
        }else if(root.val == 3){
            return evaluateTree(root.left) && evaluateTree(root.right);
        }else if(root.val == 0){
            return false;
        }
        return true;
    }
}
