/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void flatten(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(root != null){
            flatten(root.left);
            flatten(root.right);
            if(root.left != null){
                TreeNode mount = root.left;
                while(mount.right != null){
                    mount = mount.right;
                }
                mount.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            
        }
    }
}
