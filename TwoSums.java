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

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSums(new int[] {2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSums(new int[] {3, 2, 4}, 6)));     
        System.out.println(Arrays.toString(twoSums(new int[] {1, 5, 3, 7}, 8)));
        System.out.println(Arrays.toString(twoSums(new int[] {1, 2, 3}, 10)));   
    }
}
