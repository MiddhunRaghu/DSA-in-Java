import java.util.Arrays;

public class SortedMatrix {
    public static void main(String[] args) {
        int [][]arr ={
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16}
        };
        System.out.println(Arrays.toString(search(arr, 6)));
    }
    // search in a row-wise and column-wise sorted matrix
    static int [] binarySearch(int [] [] matrix, int row, int cStart , int cEnd, int target){
       while (cStart <=cEnd) {
        int mid = cStart + (cEnd - cStart) / 2;
        if(matrix[row][mid] == target){
            return new int [] {row,mid}; // found the target
        }
        if (matrix[row][mid] < target){
            cStart = mid +1; // move right if the current element is less than target
        }
        else {
            cEnd = mid - 1; // move left if the current element is greater than target
        }
       }
       return new int []{-1,-1}; // target not found
    }    

    static int [] search(int [] [] matrix, int target){
        int rows = matrix.length;
        int cols = matrix[0].length; //be caustious of empty matrix
        if(rows == 1) {
            return binarySearch(matrix, 0 ,0, cols-1 , target);
        }
        int rStart = 0;
        int rEnd = rows -1;
        int cMid = cols / 2;
        // run the loop until we have at least 2 rows
        while (rStart <(rEnd -1)){
            int mid = rStart + (rEnd - rStart) / 2;
            if (matrix[mid][cMid] == target){
                return new int []{mid ,cMid}; // found the target
            }
            if (matrix[mid][cMid] < target){
                rStart = mid; // above rows will be ignored and srtart comes to middle row
            }
            else {
                rEnd = mid; // below rows will be ignored and end comes to middle row
            }
        }
        // now we have 2 rows
        // check whether the target is in the second row or first row
        if(matrix[rStart][cMid] == target){
            return new int []{rStart , cMid}; // found the target
        }
        if(matrix[rStart+1][cMid] == target){
            return new int []{rStart + 1 , cMid}; // found the target
        }
        // target is not in the middle column
        // search in 1st half
        if(target <= matrix[rStart][cMid-1]){
            return binarySearch(matrix, rStart, 0 , cMid -1, target);
        }
        // search in 2nd half
        if(target >= matrix[rStart][cMid+1] && target <= matrix[rStart][cols-1]){
            return binarySearch(matrix,rStart ,cMid+1, cols-1,target);
        }
        // search in 3rd half
        if(target <= matrix[rStart+1][cMid-1] ){
            return binarySearch(matrix, rStart + 1, 0, cMid - 1, target);
        }
        else{
            return binarySearch(matrix, rStart + 1, cMid + 1, cols - 1, target); // search in 4th half
        }
    }   
}

/*
 *  static boolean  binarySearch(int [] [] matrix, int row, int cStart , int cEnd, int target){
       while (cStart <=cEnd) {
        int mid = cStart + (cEnd - cStart) / 2;
        if(matrix[row][mid] == target){
           return true; // found the target
        }
        if (matrix[row][mid] < target){
            cStart = mid +1; // move right if the current element is less than target
        }
        else {
            cEnd = mid - 1; // move left if the current element is greater than target
        }
       }
       return false; // target not found
    }    

    static boolean search(int [] [] matrix, int target){
        int rows = matrix.length;
        int cols = matrix[0].length; //be caustious of empty matrix
        if(rows == 1) {
            return binarySearch(matrix, 0 ,0, cols-1 , target);
        }
        int rStart = 0;
        int rEnd = rows -1;
        int cMid = cols / 2;
        // run the loop until we have at least 2 rows
        while (rStart <(rEnd -1)){
            int mid = rStart + (rEnd - rStart) / 2;
            if (matrix[mid][cMid] == target){
                return true; // found the target
            }
            if (matrix[mid][cMid] < target){
                rStart = mid; // above rows will be ignored and srtart comes to middle row
            }
            else {
                rEnd = mid; // below rows will be ignored and end comes to middle row
            }
        }
        // now we have 2 rows
        // check whether the target is in the second row or first row
        if(matrix[rStart][cMid] == target){
            return true; // found the target
        }
        if(matrix[rStart+1][cMid] == target){
            return true; // found the target
        }
        // target is not in the middle column
        // search in 1st half
        if(target <= matrix[rStart][cMid-1]){
            return binarySearch(matrix, rStart, 0 , cMid -1, target);
        }
        // search in 2nd half
        if(target >= matrix[rStart][cMid+1] && target <= matrix[rStart][cols-1]){
            return binarySearch(matrix,rStart ,cMid+1, cols-1,target);
        }
        // search in 3rd half
        if(target <= matrix[rStart+1][cMid-1] ){
            return binarySearch(matrix, rStart + 1, 0, cMid - 1, target);
        }
        else{
            return binarySearch(matrix, rStart + 1, cMid + 1, cols - 1, target); // search in 4th half
        }
    }   
 */