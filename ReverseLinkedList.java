import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ReverseLinkedList {

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

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode tempNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNext;
        }

        return prev;
    }

    private String listToString (ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) sb.append("->");
            head = head.next;
        }
        return sb.toString();
    }

    @Test
    void reverseList_1() {
        ReverseLinkedList.ListNode head = new ReverseLinkedList.ListNode(1,
                new ReverseLinkedList.ListNode(2));

        ReverseLinkedList.ListNode reversed = ReverseLinkedList.reverseList(head);

        assertEquals("2->1", listToString(reversed));
    }

}
