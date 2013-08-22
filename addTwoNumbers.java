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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ListNode list = null;
        ListNode tail = null;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int sum = num1 + num2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            if(list == null){
                list = new ListNode(sum);
                tail = list;
            }else{
                tail.next = new ListNode(sum);
                tail = tail.next;
            }
            l1 = l1 == null? null : l1.next;
            l2 = l2 == null? null : l2.next;
        }
        
        return list;
    }
}
