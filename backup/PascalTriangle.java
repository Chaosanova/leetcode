class Solution {
    //Pascal's Triangle
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
    	if(numRows == 0){
	    return new ArrayList<ArrayList<Integer>>();
    	}else if(numRows == 1){
	    ArrayList<ArrayList<Integer>> pascal = new ArrayList<ArrayList<Integer>>();
            ArrayList<Integer> init = new ArrayList<Integer>();
            init.add(1);
            pascal.add(init);
            return pascal;
        }else if(numRows == 2){
	    ArrayList<ArrayList<Integer>> pascal = generate(1);
            ArrayList<Integer> sec = new ArrayList<Integer>();
            sec.add(new Integer(1));
            sec.add(new Integer(1));
            pascal.add(sec);
            return pascal;
        }else{
            ArrayList<ArrayList<Integer>> aboveAll = generate(numRows - 1);
            ArrayList<Integer> others = new ArrayList<Integer>();
            others.add(1);
            ArrayList<Integer> above = aboveAll.get(numRows - 2);
            for(int i = 0; i < above.size() - 1; i++){
                int elem = above.get(i) + above.get(i + 1);
                others.add(elem);
            }
            others.add(1);
            aboveAll.add(others);
            return aboveAll;
        }
        
    }
}