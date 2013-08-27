public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(rowIndex == 0){
            ArrayList<Integer> init = new  ArrayList<Integer>();
            init.add(1);
            return init;
        }else if(rowIndex == 1){
            ArrayList<Integer> sec = new  ArrayList<Integer>();
            sec.add(1);
            sec.add(1);
            return sec;
        }else{
            ArrayList<Integer> above = getRow(rowIndex - 1);
            ArrayList<Integer> currLine = new ArrayList<Integer>();
            currLine.add(1);
            for(int i = 0; i < above.size() - 1; i++){
                currLine.add(above.get(i) + above.get(i + 1));
            }
            currLine.add(1);
            return currLine;
        }
    }
}