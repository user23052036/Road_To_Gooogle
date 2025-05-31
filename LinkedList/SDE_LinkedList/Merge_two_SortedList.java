package LinkedList.SDE_LinkedList;

/*
You're simply connecting the rest of the non-empty list to the merged list.
If list1 is not null, you attach the remaining part of list1.
If list2 is not null, you attach the remaining part of list2.

You do NOT need a while loop here because:
The remaining nodes are already in a linked list.
You just need to connect the current mover->next to the head of the remaining list.
There's no need to iterate and attach nodes one by one; they're already linked.
 */

 
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

    /**
     * OPTIMAL: Merge two sorted lists by reusing original nodes.
     * 
     * Time Complexity: O(n + m), where n and m are the lengths of list1 and list2.
     * Space Complexity: O(1) (no new nodes created, just relinking).
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) 
    {
        ListNode dummy = new ListNode();
        ListNode mover = dummy;

        while (list1 != null && list2 != null) 
        {
            if (list1.val < list2.val) 
            {
                mover.next = list1;
                list1 = list1.next;
            } 
            else 
            {
                mover.next = list2;
                list2 = list2.next;
            }
            mover = mover.next;
        }
        if (list1 != null) mover.next = list1;
        if (list2 != null) mover.next = list2;

        return dummy.next;
    }

    /**
     * ALTERNATE: Merge two sorted lists by creating a new list (new nodes).
     * 
     * Time Complexity: O(n + m), where n and m are the lengths of list1 and list2.
     * Space Complexity: O(n + m) (new nodes created for each element).
     */
    public ListNode mergeTwoListsWithNewList(ListNode list1, ListNode list2) 
    {
        ListNode dummy = new ListNode();
        ListNode mover = dummy;

        while (list1 != null && list2 != null) 
        {
            if (list1.val < list2.val) 
            {
                mover.next = new ListNode(list1.val);
                list1 = list1.next;
            } else 
            {
                mover.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            mover = mover.next;
        }
        while (list1 != null) 
        {
            mover.next = new ListNode(list1.val);
            mover = mover.next;
            list1 = list1.next;
        }
        while (list2 != null) 
        {
            mover.next = new ListNode(list2.val);
            mover = mover.next;
            list2 = list2.next;
        }
        return dummy.next;
    }
}

/*
 * INFO:
 * - The optimal solution reuses the nodes from the original lists, so it's O(1) extra space.
 * - The alternate solution creates a new node for each value, so it's O(n + m) extra space.
 * - Both solutions have O(n + m) time complexity, as each node is visited once.
 * - Use the optimal version unless you specifically need to preserve the original lists.
 */
