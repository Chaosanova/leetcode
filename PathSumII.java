class Solution {
    //Path Sum II
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        // Start typing your Java solution below
        // DO NOT write main() function
        
	if(root == null){
	    return new ArrayList<ArrayList<Integer>>();
	}else{
	    if(root.left == null && root.right == null){
		if(sum == root.val){
		    ArrayList<ArrayList<Integer>> sol = new ArrayList<ArrayList<Integer>>();
		    ArrayList<Integer> init = new ArrayList<Integer>();
		    init.add(sum);
		    sol.add(init);
		    return sol;
		}else{
		    return new ArrayList<ArrayList<Integer>>();
		}
	    }
            
	    ArrayList<ArrayList<Integer>> curr = null;
            
	    if(root.left != null && root.right != null){
		curr = pathSum(root.left, sum - root.val);
		curr.addAll(pathSum(root.right, sum - root.val));
	    }else if(root.left != null){
		curr = pathSum(root.left, sum - root.val);
	    }else{
		curr = pathSum(root.right, sum - root.val);
	    }
            
	    if(!curr.isEmpty()){
		for(ArrayList<Integer> subPath:curr){
		    subPath.add(0, root.val);
		}
	    }
                
	    return curr;
	}
    }
}
