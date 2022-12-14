public class A98 {
    public boolean isValidBST(TreeNode root) {
        return help(root, root.val);
    }

    public boolean help(TreeNode root, int target){
        if(root == null) return true;
        boolean left=root.left!=null ? (root.left.val < root.val)&&(root.val <= target) : true;
        boolean right = root.right!=null ? (target <= root.val)&&(root.val<root.right.val) : true;
        return left&&right&&help(root.left, root.val) &&help(root.right, root.val);
    }
    
}
