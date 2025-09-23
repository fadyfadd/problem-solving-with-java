public class FibonacciPrinter {

    public static void printFibonacci(int nbr) {
        int a1 = 0;
        int a2 = 1;
        int sum = a1 + a2;

        for (int i = 0; i < nbr; i++) {
            System.out.println(sum);
            a1 = a2;
            a2 = sum;
            sum = a1 + a2;
        }
    }

    public static void main(String[] args) {
        printFibonacci(10); 
    }
}
