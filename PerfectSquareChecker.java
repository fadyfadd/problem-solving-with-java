public class PerfectSquareChecker {

    public static boolean isPerfectSquare(int num) {
        if (num < 0) {
            return false;
        }
        if (num <= 1) {
            return true;
        }

        int value = 1;
        while (value * value < num) {
            value++;
        }

        System.out.println(value * value);
        return value * value == num;
    }

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16)); 
    }
}
