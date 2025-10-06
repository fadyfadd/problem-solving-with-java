import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MergeSortedLists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        ListNode head = new ListNode(0);
        ListNode last = head;

        ListNode list1Pointer = list1;
        ListNode list2Pointer = list2;

        while (list1Pointer != null && list2Pointer != null) {
            if (list1Pointer.val < list2Pointer.val) {
                last.next = list1Pointer;
                last = list1Pointer;
                list1Pointer = list1Pointer.next;
            } else {
                last.next = list2Pointer;
                last = list2Pointer;
                list2Pointer = list2Pointer.next;
            }
        }

        while (list1Pointer != null) {
            last.next = list1Pointer;
            last = list1Pointer;
            list1Pointer = list1Pointer.next;
        }

        while (list2Pointer != null) {
            last.next = list2Pointer;
            last = list2Pointer;
            list2Pointer = list2Pointer.next;
        }

        return head.next;
    }

    @Test
    void mergeTwoLists_1() {

        ListNode a = new ListNode(1, new ListNode(3, new ListNode(5)));
        ListNode b = new ListNode(2, new ListNode(4, new ListNode(6)));

        ListNode merged = mergeTwoLists(a, b);

        assertEquals(merged.val , 1);
        assertEquals(merged.next.val , 2);
        assertEquals(merged.next.next.val , 3);
        assertEquals(merged.next.next.next.val , 4);
        assertEquals(merged.next.next.next.next.val , 5);
        assertEquals(merged.next.next.next.next.next.val , 6);  
    }

 
}
