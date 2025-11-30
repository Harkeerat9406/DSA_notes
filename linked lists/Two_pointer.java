/* Slow fast method of traversal also using in Floyd's Cycle detection method requires two pointers.
One pointer traverses through EVERY node while the other pointer traverses through ALTERNATE nodes.
Used in problems like:
1) Find the middle element of the LL.
    Here we take the idea that if fast pointer moves at double speed then slow pointer will only reach mid
    when the fast pointer reaches the last Node

2) Find if there is a cycle in the LL(tail points to a node back again in the node)
    Here again we use a slow pointer and a fast pointer, for a cycle there always comes a point when fast=slow

The most important thing is taking care of the traversing while also avoid null pointer error.
 */


// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Two_pointer {
    public boolean hasCycle(ListNode head) {
        ListNode slow= head, fast=head;
        boolean bool=false;
        while(fast!=null)
        {
            if(fast==slow)              // can also check (fast.next==slow)
            {
                bool=true;
                break;
            }
            slow=slow.next;
            if(fast.next!=null)         //first check if next node isn't null otherwise raises null pointer error
            {
                fast= fast.next.next;
                continue;
            }
            fast=fast.next;             // just go to next node if next node is null
        }
        return bool;
    }
}