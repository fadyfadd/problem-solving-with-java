import java.util.*;

public class PermutationFinder {

public static List<List<Integer>> findAllPermutations(List<Integer> nums) {
    if (nums.size() == 0) return new ArrayList<>();

    if (nums.size() == 1) {
        List<List<Integer>> base = new ArrayList<>();
        base.add(new ArrayList<>(nums));
        return base;
    }

    int head = nums.get(0);
    List<Integer> tail = nums.subList(1, nums.size());

    List<List<Integer>> tailPermutations = findAllPermutations(tail);
    List<List<Integer>> result = new ArrayList<>();

    for (List<Integer> perm : tailPermutations) {
        for (int i = 0; i <= perm.size(); i++) {
            List<Integer> newPerm = new ArrayList<>(perm);
            newPerm.add(i, head); 
            result.add(newPerm);
        }
    }

    return result;
}


    public static void main(String[] args) {
        System.out.println(findAllPermutations(Arrays.asList(1, 2, 3)));
        System.out.println(findAllPermutations(Arrays.asList(1, 2)));
    }
}
