public class FibonacciPrinter {

    public static void printFibonacci(int nbr) {
        if (nbr <= 0) {
            System.out.println("No Fibonacci numbers to display.");
            return;
        }

        int a1 = 0;
        int a2 = 1;

        for (int i = 0; i < nbr; i++) {
            System.out.println(a1);
            int sum = a1 + a2;
            a1 = a2;
            a2 = sum;
        }
    }

    public static void main(String[] args) {
        printFibonacci(10);
    }
}
