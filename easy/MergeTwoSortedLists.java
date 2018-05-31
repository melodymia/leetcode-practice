//Solution 1 (Recursion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode mergedList = null;
        
        //以下部分也可用三目运算符替代
        //mergedList = l1.val < l2.val ? l1 : l2;
        //mergedList.next = l1.val < l2.val ? mergeTwoLists(l1.next, l2) : mergeTwoLists(l1, l2.next);
        
        if(l1.val<l2.val){
            mergedList = l1;
            mergedList.next = mergeTwoLists(l1.next, l2);
        }
        else{
            mergedList = l2;
            mergedList.next = mergeTwoLists(l1, l2.next);
        }
        return mergedList;
    }
}


//Solution 2 (non-recursion)

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)return l2;
        if(l2==null)return l1;
        ListNode head = null, index = null, current1 = l1, current2 = l2;
        if(current1.val<=current2.val){
            head = index= current1;
            current1=current1.next;
        }else{
            head = index = current2;
            current2 = current2.next;
        }
        while(current1!=null&&current2!=null){
            if(current1.val<=current2.val){
                index = index.next = current1;
                current1 = current1.next;
            }else{
                index = index.next = current2;
                current2 = current2.next;
            }
        }
        while(current1!=null){
            index = index.next = current1;
            current1 = current1.next;
        }
        while(current2!=null){
            index = index.next = current2;
            current2 = current2.next;
        }
        return head;
    }
}
