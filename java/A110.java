public class A110 {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return Math.abs(help(root.left, 0)- help(root.right, 0)) <=1;
    }
    // return depth of the tree
    // [1,null,2,null,3]
    public int help(TreeNode root, int depth){
        if(root == null) return depth;
        int left = depth;
        int right = depth;
        if(root.left != null) left = help(root.left, depth+1);
        if(root.right != null) right = help(root.right, depth+1); 
        return Math.max(left, right);
    }
}