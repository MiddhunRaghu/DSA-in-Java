public class RotationCountInRotatedArray {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(findRotationCount(arr));
    }
    static int findRotationCount(int[] arr) {
        int pivot = findPivot(arr);
        if (pivot == -1) {
            return 0; // array is not rotated
        }
        return pivot + 1; // rotation count is pivot index + 1
    }
    static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid; // found the pivot
            }
            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1; // found the pivot
            }
            if (arr[mid] >= arr[start]) {
                start = mid + 1; // pivot is in right side
            } else {
                end = mid - 1; // pivot is in left side
            }
        }
        return -1; // no pivot found, array is not rotated
    }
}
