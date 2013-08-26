public class Solution {
    public int threeSumClosest(int[] num, int target) {
           // Start typing your Java solution below
        // DO NOT write main() function
        if(num.length < 3) return Integer.MAX_VALUE;
        Arrays.sort(num);
        int res = num[0] + num[1] + num[2];
        for(int i = 0; i < num.length - 2; i++){
            if(i > 0 && num[i] == num[i - 1]) continue;
            int start = i + 1;
            int end = num.length - 1;
            while(start < end){
                int sum = num[i] + num[start] + num[end];
                if(Math.abs(sum - target) < Math.abs(res - target)){
                    res = sum;
                }
                
                if(res == target) return res;
                
                if(sum < target) start++;
                else end--;
            }
        }
        return res;
    }
}
