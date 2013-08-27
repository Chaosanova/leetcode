public class Solution {
    public boolean isValid(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(s == null || s.length() == 0) return true;
        Stack bracketQ = new Stack();
        for(int i = 0; i < s.length(); i++){
            char currChar = s.charAt(i);
            if(currChar == '(' || currChar == '{' || currChar == '[') bracketQ.push(currChar);
            else if(currChar == ')'){
                if(bracketQ.size() == 0 || !bracketQ.peek().equals('(')) return false;
                else bracketQ.pop();
            }else if(currChar == '}'){
                if(bracketQ.size() == 0 || !bracketQ.peek().equals('{')) return false;
                else bracketQ.pop();
            }else if(currChar == ']'){
                if(bracketQ.size() == 0 || !bracketQ.peek().equals('[')) return false;
                else bracketQ.pop();
            }else continue;
        }
        
        if(bracketQ.size() == 0) return true;
        else return false;
    }
}
