public class Solution {
    public void rotate(int[][] matrix) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int layerNumber = matrix.length;
        for(int layer = 0; layer < layerNumber / 2; layer++){
            int first = layer;
            int last = layerNumber - 1 - layer;
            for(int i = first; i < last; i++){
                int offset = i - first;
                
                int top = matrix[first][i];
                
                matrix[first][i] = matrix[last - offset][first];
                matrix[last - offset][first] = matrix[last][last - offset];
                matrix[last][last -offset] = matrix[i][last];
                matrix[i][last] = top;
            }
        }
        
    }
}
