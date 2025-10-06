import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

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

    @Test
    void reverseList_1() {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4));
        ReverseList.reverseList(list);
        assertEquals(List.of(4, 3, 2, 1), list);
    }
}
