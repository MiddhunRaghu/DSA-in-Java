public class FloorofNumber {
    public static void main(String[] args) {
        int[] arr ={2,3,5,9,14,16,18};
        int target = 15;
        int ans = floorofNumber(arr, target);
        System.out.println(ans); 
    }

    //return the index

    static int floorofNumber(int[] arr, int target) {
        // if target is less than the smallest element in the array
        if (target < arr[0]) {
            return -1; // or throw an exception, or return a specific value indicating not found
        }
        int start = 0;
        int end = arr.length -1 ;

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
        return arr[end]; // target not found, return the index of the smallest number greater than target
    }
}
