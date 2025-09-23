import java.util.*;

public class DuplicateChecker {
    public static boolean checkIfContainsDuplicates(int[] nums) {
        Set<Integer> lookup = new HashSet<>();

        for (int entry : nums) {
            if (lookup.contains(entry)) {
                return true;
            } else {
                lookup.add(entry);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkIfContainsDuplicates(new int[] {1, 1, 1, 3, 3, 4, 3, 2, 4, 2})); 
        System.out.println(checkIfContainsDuplicates(new int[] {}));                          
    }
}
