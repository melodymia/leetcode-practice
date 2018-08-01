/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 //首先求得单链表的length，然后遍历length/2距离查到单链表的中间节点
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode test = head;
        int length = 0;
        //求得单链表长度
        while(test!=null){
            length++;
            test=test.next;
        }
        
        int count = 0;
        test=head;
        while(count<length/2){
            count++;
            test=test.next;
        }
        
        return test;
    }
}
