public class SingleElementSorted {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        SingleElementSorted singleElementSorted = new SingleElementSorted();
        System.out.println(singleElementSorted.singleNonDuplicate(nums));
    }
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length-1;

        while (start < end){
            int mid = start  +(end - start)/2;
            if( mid%2 == 1){
                mid--;
            }
            if(nums[mid] == nums[mid +1]){
                start = mid +2;
            }
            else {
                end = mid ;
            }
        }
        return nums[start];
    }
}