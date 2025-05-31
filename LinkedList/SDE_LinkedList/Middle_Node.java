package LinkedList.SDE_LinkedList;

import java.util.ArrayList;
import java.util.List;

class ListNode 
{
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class MiddleOfLinkedListSolutions 
{
    // Method 1: Fast & Slow Pointer (Optimal)
    // Time: O(n) | Space: O(1)
    public static ListNode middleNodeFastSlow(ListNode head) 
    {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null)   // I ALLWAYS FORGET TO PUT && AND PUT || BOTH SHOULD BE TRUE
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Method 2: Two-Pass Approach
    // Time: O(n) | Space: O(1)
    public static ListNode middleNodeTwoPass(ListNode head) 
    {
        int count = 0;
        ListNode temp = head;
        while (temp != null) 
        {
            count++;
            temp = temp.next;
        }
        temp = head;
        for (int i = 0; i < count/2; i++)
            temp = temp.next;
        return temp;
    }

    // Method 3: Array Conversion
    // Time: O(n) | Space: O(n)
    
    public static ListNode middleNodeArray(ListNode head) 
    {
        List<ListNode> nodes = new ArrayList<>();
        while (head != null) 
        {
            nodes.add(head);
            head = head.next;
        }
        return nodes.get(nodes.size()/2);
    }
}

