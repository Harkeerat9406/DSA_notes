/* Three pointer method is mostly used to reverse an array 
we take prev, curr, front pointers and keep udating them to reverse as:

ListNode next= curr.next;
curr.next= prev;
back=curr;
curr=next;



If we have a question where we have to reverse a LL in a particular range then we first need to have a dummy
node before head that points to head. We use the idea that in the range we simply reverse the LL but the address
part of nodes that have not been in the range have to be updated. 
So we take two more Node variables, one stores the Node just before the start of range and other stores the Node
where range starts as after reversing it will be at the end.

After reversing, prev will point to the last Node in original array, so after reversing we set 
    before_left.next= prev
and the node originally at prev will be at end to we set, rev_last.next= curr;   as curr will be pointing at Node
just after the range. 
*/




/*
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

public class Three_pointer 
{
    public ListNode reverseRange(ListNode head, int left, int right)
    {
        ListNode dummy= new ListNode(0);
        dummy.next= head;
        ListNode before_left= dummy;

        for(int i=1; i<left; i++)
        {
            before_left= before_left.next;
        }
        ListNode curr= before_left.next;
        ListNode prev= null;
        ListNode rev_last= curr;

        for(int i=left; i<=right; i++)
        {
            ListNode next= curr.next;
            curr.next= prev;
            prev= curr;
            curr=next;
        }

        before_left.next= prev;      // prev will be at Node last node of rag 
        rev_last.next= curr;         // curr wil be at Node just after range

        return dummy.next;
    }
}
