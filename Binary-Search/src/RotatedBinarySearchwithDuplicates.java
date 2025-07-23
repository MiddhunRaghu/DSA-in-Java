public class RotatedBinarySearchwithDuplicates {
    public static void main(String[] args) {
        int [] arr = {2,2,2,2,9};
        System.out.println(FindPivotWithDuplicates(arr));
    }

    static int search(int[] arr, int target) {
        int pivot = FindPivotWithDuplicates(arr);
        if(pivot == -1){
            //array is not rotated, do normal binary search
            return binarySearch(arr, target, 0, arr.length - 1);
        }
        //if pivot is found, we have 2 sorted arrays
        if(arr[pivot] == target){
            return pivot; //found the target at pivot
        }
        if(target >= arr[0]){
            //search in the left side of the pivot
            return binarySearch(arr, target, 0, pivot - 1);
        }
        return binarySearch(arr, target, pivot + 1, arr.length - 1);
        //search in the right side of the pivot

    }
     static int binarySearch(int[] arr, int target , int start, int end) {
        while (start <= end) {
            // find the middle element
           // int mid = (start + end) / 2;  might be possible that (start + end) exceeds the range of int
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            }
            else if (target > arr[mid]){
                start = mid + 1;
            }
            else {
                // found the target
                return mid;
            }
        }
        return -1; // target not found
    }
    static int FindPivotWithDuplicates(int[] arr){
        int start = 0;
        int end =arr.length -1;
        while( start <= end){
            //find the middle element
            int mid = start + (end - start)/2;
            //4 cases
            if(mid < end && arr[mid] > arr[mid+1]){
                return mid; //found the pivot
            }
            if(mid > start && arr[mid] < arr[mid-1]){
                return mid - 1; //found the pivot
            }
            
            //if elements at start, mid, and end are equal,then just skip the duplicates
            if(arr[mid] == arr[start] && arr[mid] == arr[end]){
                // skip the duplicates
                //Note: What if the element at start and end are the pivot?
                //check if start is pivot
                if(arr[start] > arr[start + 1]){
                    return start;
                }
                start++;
                //check if end is pivot
                if(arr[end] < arr[end - 1]){
                    return end - 1;
                }
                end--;
            }
            //left side is sorted, pivot is in right side
            else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])){
                start = mid + 1; //pivot is in left side
            }
            else{
                start = mid - 1; //pivot is in right side
            }
        }
        return -1; //no pivot found, array is not rotated
    }
}
