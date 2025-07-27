//https://leetcode.com/problems/arranging-coins/
public class ArrangingCoins {
    public static void main(String[] args) {
        int n = 5; // Example number of coins
        int result = arrangeCoins(n);
        System.out.println("Complete rows that can be formed: " + result);
    }

     static int arrangeCoins(int n) {
        long start = 0;
        long end = n;

        while (start <= end ){
            long mid = start + ( end - start )/ 2; // Calculate the mid-point
            long coinUsed = mid * (mid + 1) / 2;// Calculate the number of coins used to form complete rows

            if (coinUsed == n){
                return (int) mid;// If the exact number of coins matches, return mid
            }
            if ( coinUsed < n){
                start = mid + 1;// If the coins used are less than n, move to the right half
            }
            else {
                end = mid - 1;// If the coins used are more than n, move to the left half
            }
        }

        return (int)end;// When the loop ends, end will be the largest mid that can be formed with n coins
    }
}
