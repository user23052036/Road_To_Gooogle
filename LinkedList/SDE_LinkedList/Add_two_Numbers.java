package LinkedList.SDE_LinkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution 
{

    /**
     * Approach 1: In-place addition (modify l1, append as needed)
     * -----------------------------------------------------------
     * - Modifies l1 to store the result, appending new nodes if l2 is longer or there's a final carry.
     * - Saves space by reusing l1 nodes as much as possible.
     * 
     * Time Complexity:  O(max(n, m)), where n and m are the lengths of l1 and l2.
     * Space Complexity: O(1) (ignoring the output list, which is required anyway).
     */
    public ListNode addTwoNumbersInPlace(ListNode l1, ListNode l2)  // my technique
    {
        int carry = 0;
        ListNode head = l1, prev = l1;

        while (l1 != null || l2 != null) 
        {
            int sum = carry;
            if (l1 != null) sum += l1.val;
            if (l2 != null) sum += l2.val;
            carry = sum / 10;

            if (l1 != null) 
            {
                l1.val = sum % 10;
                prev = l1;
                l1 = l1.next;
            } 
            else 
            {
                prev.next = new ListNode(sum % 10);
                prev = prev.next;
            }
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) prev.next = new ListNode(carry);
        return head;
    }

    /**
     * Approach 2: New list for result (always allocates new nodes)
     * ------------------------------------------------------------
     * - Does not modify input lists. Always creates a new result list.
     * - Uses a dummy node for easier handling of the head.
     * 
     * Time Complexity:  O(max(n, m)), where n and m are the lengths of l1 and l2.
     * Space Complexity: O(max(n, m)) (for the new result list).
     */
    public ListNode addTwoNumbersNewList(ListNode l1, ListNode l2) 
    {
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode mover = dummy;

        while (l1 != null || l2 != null) 
        {
            int sum = carry;
            if (l1 != null) sum += l1.val;
            if (l2 != null) sum += l2.val;

            mover.next = new ListNode(sum % 10);
            mover = mover.next;
            carry = sum / 10;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry > 0) mover.next = new ListNode(carry);
        return dummy.next;
    }
}

/*
 * Summary:
 * - Use addTwoNumbersInPlace if you can safely modify l1 and want to save space.
 * - Use addTwoNumbersNewList if you need to preserve the input lists or always want a fresh result list.
 */
