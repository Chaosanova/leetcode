//import java.util.*;
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
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<TreeNode>> resNodes = new ArrayList<ArrayList<TreeNode>>();
        if(root == null) return res;
        
        ArrayList<TreeNode> init = new ArrayList<TreeNode>();
        init.add(root);
        resNodes.add(init);
        ArrayList<TreeNode> nextLayer = genNewLevel(init);
        while(nextLayer.size() != 0){
            resNodes.add(nextLayer);
            nextLayer =  genNewLevel(nextLayer);
        }
        
        for(int i = 0; i < resNodes.size(); i++){
            ArrayList<TreeNode> currNodes = resNodes.get(i);
            ArrayList<Integer> currIntegers = new ArrayList<Integer>();
            for(int j = 0; j < currNodes.size(); j++){
                TreeNode currNode = currNodes.get(i);
                currIntegers.add(currNode.val);
            }
            res.add(currIntegers);
        }
        
        return res;
    }
    
    private ArrayList<TreeNode> genNewLevel(ArrayList<TreeNode> currLayer){
        
        ArrayList<TreeNode> returnList = new ArrayList<TreeNode>();
        for(int i = 0; i < currLayer.size(); i++){
            TreeNode currNode = currLayer.get(i);
            if(currNode.left != null) returnList.add(currNode.left);
            if(currNode.right != null) returnList.add(currNode.right);
        }
        
        return returnList;
    }
}