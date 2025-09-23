public class IntegerReverser {

    public static int reverseInteger(int nbr) {
        int value = 0;

        while (nbr != 0) {
            value = value * 10 + nbr % 10;
            nbr = nbr / 10;
        }

        return value;
    }

    public static void main(String[] args) {
        System.out.println(reverseInteger(1000));  
        System.out.println(reverseInteger(1));      
        System.out.println(reverseInteger(125));   
        System.out.println(reverseInteger(46120)); 
    }
}
