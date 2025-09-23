import java.util.*;

public class PermutationFinder {

    public static List<List<Integer>> findAllPermutations(List<Integer> nums) {
        if (nums.size() == 1) {
            List<List<Integer>> single = new ArrayList<>();
            single.add(new ArrayList<>(nums));
            return single;
        }

        List<List<Integer>> data = new ArrayList<>();

        for (int i = 0; i < nums.size(); i++) {
            int item = nums.get(i);
            List<Integer> nums1 = new ArrayList<>(nums);
            nums1.remove(i);

            List<List<Integer>> res = findAllPermutations(nums1);
            for (List<Integer> a : res) {
                a.add(0, item);
                data.add(a);
            }
        }

        return data;
    }

    public static void main(String[] args) {
        System.out.println(findAllPermutations(Arrays.asList(1, 2, 3)));
        System.out.println(findAllPermutations(Arrays.asList(1, 2)));
    }
}
