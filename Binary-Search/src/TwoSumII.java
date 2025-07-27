//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/submissions/1711624125/
public class TwoSumII {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15};
        int target = 9; // Example target
        int[] result = twoSums(numbers, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }

    // Function to find two numbers in a sorted array that add up to a target sum
    static int[] twoSums(int[] numbers , int target){
        int left = 0;
        int right = numbers.length-1;
        while(left < right){
            int sum = numbers[left] + numbers[right];
            if(sum == target){
                return new int[]{left + 1, right + 1}; // return 1-based indices
            }
            if (sum < target){
                left ++; // move left pointer to the right if sum is less than target
            }
            else{
                right --; // move right pointer to the left if sum is greater than target
            }
        }
        return new int []{-1,-1}; // return -1 if no such pair exists}
    }
}
