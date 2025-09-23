import java.util.*;

public class BitCounter {
    public static List<Integer> countBits(int n) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            res.add(Integer.bitCount(i));
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(countBits(5)); 
        System.out.println(countBits(0)); 
        System.out.println(countBits(1));
    }
}
