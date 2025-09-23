import java.util.*;

public class ReverseList {

    public static void reverseList(List<Integer> s) {
        int i = 0;
        int j = s.size() - 1;

        while (i < j) {
            int temp = s.get(i);
            s.set(i, s.get(j));
            s.set(j, temp);
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 2, 3));
        reverseList(a);
        System.out.println(a); 
    }
}
