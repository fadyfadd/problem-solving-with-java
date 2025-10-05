import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class IntervalMerger {

    public static List<List<Integer>> mergeTwoEntries(List<Integer> a, List<Integer> b) {
        List<Integer> left = a.get(0) <= b.get(0) ? a : b;
        List<Integer> right = a.get(0) <= b.get(0) ? b : a;

        if (left.get(1) >= right.get(0)) {
            int mergedEnd = Math.max(left.get(1), right.get(1));
            return Collections.singletonList(Arrays.asList(left.get(0), mergedEnd));
        } else {
            return Arrays.asList(left, right);
        }
    }

    public static List<List<Integer>> insertInterval(List<List<Integer>> main, List<Integer> toInsert) {
        List<List<Integer>> intervals = new ArrayList<>();
        intervals.add(toInsert);
        intervals.addAll(main);

        intervals.sort(Comparator.comparingInt(a -> a.get(0)));

        List<List<Integer>> results = new ArrayList<>();
        results.add(intervals.get(0));

        for (int i = 1; i < intervals.size(); i++) {
            List<Integer> arr1 = intervals.get(i);
            List<Integer> arr2 = results.remove(results.size() - 1);
            List<List<Integer>> merged = mergeTwoEntries(arr1, arr2);

            results.add(merged.get(0));
            if (merged.size() == 2) {
                results.add(merged.get(1));
            }
        }

        return results;
    }

    @Test
    public void insertInterval_Test() {
        List<List<Integer>> mainIntervals = Arrays.asList(
            Arrays.asList(1, 3),
            Arrays.asList(6, 9)
        );
        List<Integer> toInsert = Arrays.asList(2, 5);

        List<List<Integer>> expected = Arrays.asList(
            Arrays.asList(1, 5),
            Arrays.asList(6, 9)
        );

        List<List<Integer>> result = insertInterval(mainIntervals, toInsert);

        assertEquals(expected, result); 
    }

}




