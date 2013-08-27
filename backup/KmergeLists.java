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
 * Insert all the list nodes to build a heap, then pop the heap nodes to generate 
 * a sorted list, therefore the total running time would be O(knlogk)
 */
public class Solution {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(lists == null || lists.size() == 0) return null;
        if(lists.size() == 1) return lists.get(0);
        nodeComparator comp = new nodeComparator();
        PriorityQueue<ListNode> listNodes = new PriorityQueue<ListNode>(lists.size(), comp);
        for(ListNode list: lists){
            if(list != null) listNodes.add(list);
        }
        if(listNodes.size() == 0) return null;
        
        ListNode head = listNodes.poll();
        ListNode returnHead = head;
        if(head.next != null) listNodes.add(head.next);
        while(listNodes.size() != 0){
            ListNode curr = listNodes.poll();
            head.next = curr;
            head = head.next;
            if(curr.next != null) listNodes.add(curr.next);
        }
        
        return returnHead;
    }
}

class nodeComparator implements Comparator<ListNode>{
    public int compare(ListNode node1, ListNode node2){
        if(node1.val < node2.val) return -1;
        else if(node1.val > node2.val) return 1;
        else return 0;
    }
}
