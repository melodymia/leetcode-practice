//平衡二叉树，即判断左子树的最大深度和右子树的最大深度之差是否小于1

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root) {
        if(root == null)
             return true;
        int leftH = getHeight(root.left);
        int rightH = getHeight(root.right);
        int diff = Math.abs(leftH - rightH);
        if(diff>1){
            return false;
        }else{
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }
    
    int getHeight(TreeNode root){
        if(root == null){ return 0;}
        return 1+Math.max(getHeight(root.left),getHeight(root.right));
    }
        
}
