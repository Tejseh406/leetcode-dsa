/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        boolean isLoop = false;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                ListNode newNode = head;

                while(newNode != slow){
                    slow = slow.next;
                    newNode = newNode.next;
                }

                return slow;
            }
        }

        return null;
    }
}