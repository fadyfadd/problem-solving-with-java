import static org.junit.Assert.assertTrue;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.*;

public class CommonPrefixFinder {

    public static String findLongestCommonPrefix(List<String> strings) {
        if (strings == null || strings.isEmpty()) {
            return "";
        }

        Collections.sort(strings);
        String first = strings.get(0);
        String last = strings.get(strings.size() - 1);
        StringBuilder result = new StringBuilder();

        int i = 0;
        while (i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)) {
            result.append(first.charAt(i));
            i++;
        }

        return result.toString();
    }

    @Test
    public void findLongestCommonPrefix_1() {
        List<String> strings = Arrays.asList("flower", "flow", "flight");
        String prefix = findLongestCommonPrefix(strings);
        assertTrue(prefix.equals("fl"));
       
    }

}
