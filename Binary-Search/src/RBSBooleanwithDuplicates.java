public class RBSBooleanwithDuplicates {
    public static void main(String[] args) {
        int[] arr = {2,5,6,0,0,1,2};
        int target = 0;
        boolean ans = search(arr, target);
        System.out.println(ans);
    }
     static boolean search(int[] nums, int target) {
        int pivot = FindPivot(nums);
        if(pivot == -1){
            //array is not rotated, do normal binary search
            return binarySearch(nums, target, 0, nums.length - 1);
        }
        //if pivot is found, we have 2 sorted arrays
        if(nums[pivot] == target){
            return true; //found the target at pivot
        }
        if(target >= nums[0]){
            //search in the left side of the pivot
            return binarySearch(nums, target, 0, pivot - 1);
        }
        return binarySearch(nums, target, pivot + 1, nums.length - 1);
        //search in the right side of the pivot

    }
    static boolean binarySearch(int[] arr, int target, int start, int end) {
    while (start <= end) {
        int mid = start + (end - start) / 2;

        if (arr[mid] == target) {
            return true; // Found the target
        } else if (arr[mid] < target) {
            start = mid + 1;
        } else {
            end = mid - 1;
        }
    }
    return false; // Target not found
}
    static int FindPivot(int[] arr){
        int start = 0;
        int end =arr.length -1;
        
        while( start <= end){
            //find the middle element
            int mid = start + (end - start)/2;

            if (mid < end && arr[mid] == arr[end]) {
                end--;
            } else if (mid > start && arr[mid] == arr[start]) {
            start++;
            }
            //4 cases
            else if(mid < end && arr[mid] > arr[mid+1]){
                return mid; //found the pivot
            }
            else if(mid > start && arr[mid] < arr[mid-1]){
                return mid - 1; //found the pivot
            }
            else if(arr[mid] <= arr[start]){
                end = mid - 1; //pivot is in left side
            }
            else{
                start = mid + 1; //pivot is in right side
            }
        }
        return -1; //no pivot found, array is not rotated
    }
}