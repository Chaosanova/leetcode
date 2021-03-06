//The recursion would convergence to n = 0, the complexity is O(lgn)
public class Solution {
    public double pow(double x, int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(n == 0) return 1.0;
        double half = pow(x, n / 2);
        if(n % 2 == 0){
            return half * half;
        }else if(n > 0){
            return half * half * x;
        }else{
            return half * half / x;
        }
    }
}
