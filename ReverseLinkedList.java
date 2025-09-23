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

    public static void main(String[] args) {
        ListNode head = new ListNode(1,
                          new ListNode(2,
                          new ListNode(3,
                          new ListNode(4))));

        ListNode reversedHead = reverseList(head);
        ListNode curr = reversedHead;

        while (curr != null) {
            System.out.print(curr.val + (curr.next != null ? " -> " : "\n"));
            curr = curr.next;
        }
      
    }
}
