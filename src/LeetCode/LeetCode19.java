package LeetCode;

public class LeetCode19 {
    /*
    给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        ListNode behind = head;
        for(int i=0;i<n;i++){
            pre = pre.next;
        }
        if(null==pre)
            return head.next;
        while(null!=pre.next){
            pre = pre.next;
            behind = behind.next;
        }
        behind.next = behind.next.next;
        return head;
    }
}
