// Question: Find the position of an element in a sorted array of infinite numbers.// Link: 
// https://www.geeksforgeeks.org/dsa/find-position-element-sorted-array-infinite-numbers/

public class InfiniteArray {
    public static void main(String[] args) {
        int []arr = {3,5,7,9,10,90,100,130,140,160,170};
        int target = 10;
        System.out.println(findingAns(arr, target));

    }
    static int findingAns(int[] arr, int target){
        // find the range
        // first start with a box of size 2
        int start = 0;
        int end = 1;
        // condition for target to lie in the range
        while ( target > arr[end]) {
            // double the box size
            int newStart = end + 1; // new start will be previous end + 1
            // end will be old end + size of box * 2
            end = end + (end - start + 1) * 2; // size of box is (end - start + 1)
            start = newStart;
        }
        // now do normal binary search
        return binarySearch(arr, target, start, end);
    }
    static int binarySearch(int[] arr, int target, int start, int end) {
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
}
