// PeakIndex in a Mountain Array
//https://leetcode.com/problems/peak-index-in-a-mountain-array/?envType=problem-list-v2&envId=array
public class PeakIndex {
    public static void main(String[] args) {
        int[] arr = {0,2,1,0};
        int ans = peakIndexInMountainArray(arr);
        System.out.println("Peak Index: " + ans);
    }
    public static int peakIndexInMountainArray(int[] arr) {
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
}
