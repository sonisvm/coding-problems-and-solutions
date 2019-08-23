/**
 * Given a linked list of numbers and a pivot k, partition the linked list so that all nodes less than k come before
 * nodes greater than or equal to k.
 *
 * For example, given the linked list 5 -> 1 -> 8 -> 0 -> 3 and k = 3, the solution could be 1 -> 0 -> 5 -> 8 -> 3.
 */
public class DailyCoding208 {
    public static void main(String[] args) {
        ListNode five = new ListNode(5);
        ListNode one = new ListNode(1);
        ListNode eight = new ListNode(8);
        ListNode zero = new ListNode(0);
        ListNode three = new ListNode(3);

        five.next = one;
        one.next = eight;
        eight.next = zero;
        zero.next = three;

        printList(partition(five, 3));
    }
    public static void printList(ListNode head) {
        ListNode tmp = head;
        while (tmp != null) {
            System.out.print(tmp.val + "->");
            tmp = tmp.next;
        }
        System.out.println("");
    }
    public static ListNode partition(ListNode head, int x) {
        if(head==null){
            return head;
        }
        ListNode left = null, curr = head, tmp=null, right=null, lefthead = null, righthead=null;
        while(curr!=null){
            if(curr.val < x){
                if(left==null){
                    left = curr;
                    lefthead = curr;
                } else {
                    left.next = curr;
                    left = curr;
                }
            } else {
                if(right == null){
                    right = curr;
                    righthead = curr;
                } else {
                    right.next = curr;
                    right = curr;
                }
            }
            tmp = curr.next;
            curr.next = null;
            curr = tmp;
        }
        if(lefthead!=null){
            left.next = righthead;
        } else {
            lefthead = righthead;
        }

        return lefthead;
    }
}
