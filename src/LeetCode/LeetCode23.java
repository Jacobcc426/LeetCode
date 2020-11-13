package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LeetCode23 {
    PriorityQueue<ListNode> nodeQueue;
    public ListNode mergeKLists(ListNode[] lists) {
        nodeQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode listNode, ListNode t1) {
                return listNode.val-t1.val;
            }
        });
        for (ListNode listNode : lists) {
            if(null!=listNode){
                while(null!=listNode.next){
                    nodeQueue.add(listNode);
                    listNode = listNode.next;
                }
                nodeQueue.add(listNode);
            }
        }
        ListNode head = new ListNode();
        ListNode temp = head;
        while(!nodeQueue.isEmpty()){
            temp.next = nodeQueue.poll();
            temp = temp.next;
        }
        temp.next =null;
        return head.next;
    }
}
