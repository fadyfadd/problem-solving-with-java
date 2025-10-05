import java.util.*;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void checkIfContainsDuplicates_1() {
        assertTrue(checkIfContainsDuplicates(new int[] {1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
        assertFalse(checkIfContainsDuplicates(new int[] {}));
    }
}
