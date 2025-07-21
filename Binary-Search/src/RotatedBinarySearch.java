//https://leetcode.com/problems/search-in-rotated-sorted-array/description/?envType=problem-list-v2&envId=binary-search
public class RotatedBinarySearch {
    public static void main(String[] args) {
        int [] arr = {4,5,6,7,0,1,2};
        System.out.println(FindPivot(arr));
    }

    static int search(int[] nums, int target) {
        int pivot = FindPivot(nums);
        if(pivot == -1){
            //array is not rotated, do normal binary search
            return binarySearch(nums, target, 0, nums.length - 1);
        }
        //if pivot is found, we have 2 sorted arrays
        if(nums[pivot] == target){
            return pivot; //found the target at pivot
        }
        if(target >= nums[0]){
            //search in the left side of the pivot
            return binarySearch(nums, target, 0, pivot - 1);
        }
        return binarySearch(nums, target, pivot + 1, nums.length - 1);
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
    static int FindPivot(int[] arr){
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
            if(arr[mid] <= arr[start]){
                end = mid - 1; //pivot is in left side
            }
            else{
                start = mid + 1; //pivot is in right side
            }
        }
        return -1; //no pivot found, array is not rotated
    }
}
