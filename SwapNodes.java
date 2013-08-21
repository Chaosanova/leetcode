/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(head == null || head.next == null) return head;
        Boolean firstSwap = true;
        ListNode swaphead = head.next; //the swap head would be the original second list node 
        ListNode previousNode = head;
        ListNode currNode = head;
        while(currNode.next != null && currNode.next.next != null){
            if(firstSwap) firstSwap = false;
            else previousNode.next = currNode.next;
            ListNode futureNode = currNode.next.next;
            currNode.next.next = currNode;
            currNode.next = futureNode;
            previousNode = currNode;
            currNode = futureNode;
        }
        
        if(currNode.next != null){
            previousNode.next = currNode.next;
            currNode.next.next = currNode;
            currNode.next = null;
        }
        
        
        return swaphead;
    }
}
