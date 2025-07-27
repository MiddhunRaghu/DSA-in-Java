import java.util.Arrays;

public class RowColumnMatrix {
    public static void main(String[] args) {
        int [][] arr = {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 48},
            {32, 33, 39, 50}
        };
        System.out.println(Arrays.toString(search(arr, 37)));
    }

    static int [] search(int[][] matrix , int target){
        int r =0;
        int c = matrix[0].length - 1; // start from the top-right corner
        while(r < matrix.length && c >= 0){
            if(matrix[r][c] == target){
                return new int []{r,c}; // found the target
            }
            if(matrix[r][c] < target){
                r++; // move down if the current element is less than target
            } else {
                c--; // move left if the current element is greater than target
            }
        }
        return new int []{-1,-1}; // target not found
    }   
}
