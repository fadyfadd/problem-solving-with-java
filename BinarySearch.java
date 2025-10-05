import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Arrays;
import org.junit.jupiter.api.*;

public class BinarySearch {
    
    public static Boolean BSearch(int[] arr, Integer target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int valueMid = arr[mid];

            if (valueMid == target) {
                return true; 
            } else if (valueMid < target) {
                int[] newArray = Arrays.stream(arr , mid + 1, arr.length).toArray();
                return BSearch(newArray, target);
            } else {
                int[] newArray = Arrays.stream(arr , 0 , mid).toArray(); 
                return BSearch(newArray, target);
            }
        }

        return false; 

    }

    @Test
    public void BSearch_1() {
        int[] BSearch = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer target = 10;
        Boolean result = BSearch(BSearch, target);
        assertTrue(!result);          
    }

    @Test
    public void BSearch_2() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        Integer target = 5;
        Boolean result = BSearch(arr, target);
        assertTrue(result); 
             
    }
}
