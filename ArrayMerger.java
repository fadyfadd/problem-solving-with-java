import java.util.*;

public class ArrayMerger {

    public static void merge(List<Integer> nums1, int m, List<Integer> nums2, int n) {
        List<Integer> res = new ArrayList<>();
        int i = 0, j = 0;

        while (i < m && j < n) {
            if (nums1.get(i) < nums2.get(j)) {
                res.add(nums1.get(i));
                i++;
            } else {
                res.add(nums2.get(j));
                j++;
            }
        }

        while (i < m) {
            res.add(nums1.get(i));
            i++;
        }

        System.out.println(res);
        while (j < n) {
            res.add(nums2.get(j));
            j++;
        }

        for (int k = 0; k < res.size(); k++) {
            nums1.set(k, res.get(k));
        }

        while (nums1.size() > m + n) {
            nums1.remove(nums1.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<Integer> nums1 = new ArrayList<>(Arrays.asList(1, 2, 3, 0, 0, 0));
        List<Integer> nums2 = Arrays.asList(2, 5, 6);
        merge(nums1, 3, nums2, 3);
        System.out.println(nums1);
    }
}
