public class Solution {
    public ArrayList<String> anagrams(String[] strs) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(strs == null && strs.length == 0) return new ArrayList<String>();
        ArrayList<String> res = new ArrayList<String>();
        HashMap<String, ArrayList<String>> anagram = new HashMap<String, ArrayList<String>>();
        for(String eachString: strs){
            String indexString = genIndex(eachString);
            ArrayList<String> relateString = null;
            if(anagram.containsKey(indexString)) relateString = anagram.get(indexString);
            else relateString = new ArrayList<String>();
            
            relateString.add(eachString);
            anagram.put(indexString, relateString);
        }
        
        for(ArrayList<String> eachRes: anagram.values()){
            if(eachRes.size() > 1) res.addAll(eachRes);
        }
        
        return res;
    }
    
    private String genIndex(String inputString){
        char[] string2char = inputString.toCharArray();
        int[] convertChars = new int[26];
        for(char eachChar: string2char){
            convertChars[eachChar - 'a'] += 1;
        }
        
        return Arrays.toString(convertChars);
    }
}
