package LinkedList.SDE_LinkedList;

import java.util.ArrayList;
import java.util.List;

//Definition for singly-linked list.
  class ListNode 
  {
    int val;
    ListNode next;
    
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 

class Solution 
{

    // 1. Iterative Approach (Optimal)
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public ListNode reverseListIterative(ListNode head) 
    {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next; // Save next node
            curr.next = prev;              // Reverse pointer
            prev = curr;                   // Move prev forward
            curr = nextTemp;               // Move curr forward
        }
        return prev; // New head as  y the end of iteration curr will be pointng to null
    }


    // 2. Recursive Approach
    // Time Complexity: O(n)
    // Space Complexity: O(n) (due to recursion stack)
    public ListNode reverseListRecursive(ListNode head) 
    {
        // Base case: empty list or last node
        if (head == null || head.next == null) return head;
    
        ListNode newHead = reverseListRecursive(head.next); // Recurse
        head.next.next = head; // Reverse pointer
        head.next = null;      // Set new tail
        return newHead;    // if you dry-run you will see that the newhead still stays the same 
    }

    // 3. Brute Force Approach (using extra space)
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public ListNode reverseListBruteForce(ListNode head) 
    {
        // Store values in an ArrayList
        List<Integer> vals = new ArrayList<>();
        ListNode curr = head;
        while (curr != null) 
        {
            vals.add(curr.val);
            curr = curr.next;
        }
        // Overwrite values in reverse order
        curr = head;
        for (int i = vals.size() - 1; i >= 0; i--) 
        {
            curr.val = vals.get(i);
            curr = curr.next;
        }
        return head;
    }
}
