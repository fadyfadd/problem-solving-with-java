import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.*;

public class TwoSums {
    
    public static int[] twoSums(int[] nums, int target) {
        Map<Integer, Integer> lookup = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int delta = target - nums[i];
            if (lookup.containsKey(delta)) {
                return new int[] { lookup.get(delta), i };
            }
            lookup.put(nums[i], i);
        }
        

        return new int[0]; // No match found
    }

    @Test
    void testTypicalCase() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSums(nums, target);
        assertArrayEquals(new int[]{0, 1}, result);
    }
}
