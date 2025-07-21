//https://leetcode.com/problems/find-in-mountain-array/submissions/1703044304/
public class MountainArray {
    public static void main(String[] args) {
        
    }
    int search(int[] arr, int target){
        int peak= peakIndexInMountainArray(arr);
        int firstTry = orderAgnosticBS(arr, target, 0, peak);
        if(firstTry != -1){
            return firstTry; //found in the left side of the peak
        }
        //if not found in the left side, search in the right side
        return orderAgnosticBS(arr, target, peak + 1, arr.length - 1);
        //search in the left side of the peak
    }
    public int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while(start < end){
            //find the middle element
            int mid = start + (end -start) /2;
            if(arr[mid] > arr[mid +1]){
                //we are in decreasing part of the array
                //this may be the answer but look at left side
                end = mid; //mid can be the answer
            }
            else{
                //we are in increasing part of the array
                start = mid + 1; //because mid + 1 is greater than mid
            }
        }
        return start; //or end, both are same
    }
    static int orderAgnosticBS(int[] arr, int target ,int start, int end){
        //find whether the array is sorted in ascending or descending order
        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            // find the middle element
           // int mid = (start + end) / 2;  might be possible that (start + end) exceeds the range of int
            int mid = start + (end - start) / 2;

            if(arr[mid] ==target) {
                return mid; // found the target
            }

            if(isAsc){
                 if (target < arr[mid]) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
            else{
                 if (target > arr[mid]) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
            }
           
        }
        return -1; // target not found
    }
}
