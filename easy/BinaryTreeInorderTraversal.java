//二叉树中序遍历即从左节点到根节点到右节点的遍历

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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root==null) return res;
        inorder(root,res);
        return res;
    }
    
     public static void inorder(TreeNode root, List<Integer> list){
        if(root != null){
            inorder(root.left,list);
            list.add(root.val);
            inorder(root.right,list);
        }
    }
    
}
