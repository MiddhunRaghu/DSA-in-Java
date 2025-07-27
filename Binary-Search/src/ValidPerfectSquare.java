//https://leetcode.com/problems/valid-perfect-square/
public class ValidPerfectSquare {
    public static void main(String[] args) {
        int num = 16; // Example number
        boolean result = isPerfectSquare(num);
        System.out.println("Is " + num + " a perfect square? " + result);
    }
    static boolean isPerfectSquare(int num){
            if (num < 0){
            return false;
        }
        if (num == 0 || num == 1){
            return true;
        }

        int start = 1;
        int end = num;

        while (start <= end){
            int mid = start + (end - start) /2;

            long square =(long)mid * mid;

            if (square == num){
                return true;
            }
            if ( square < num){
                start = mid + 1;
            }
            else {
                end = mid -1 ;
            }
        }

        return false;
    }
    
}
