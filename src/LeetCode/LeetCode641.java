package LeetCode;

public class LeetCode641 {
}
class MyCircularDeque {
    private ListNode head,tail;
    private int count;
    private int capacity;


    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        this.capacity = k;
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(count==capacity)
            return false;
        else{
            ListNode listNode = new ListNode(value);
            if(count==0){
                head=tail = listNode;
            }else {
                head.pre = listNode;
                listNode.next = head;
                head = listNode;
            }
            count++;
            return true;
        }
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(count==capacity)
            return false;
        else{
            ListNode listNode = new ListNode(value);
            if(count==0){
                head=tail = listNode;
            }else {
                listNode.pre = tail;
                tail.next = listNode;
                tail = tail.next;
            }
            count++;
            return true;
        }
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(count==0)
            return false;
        else {
            head = head.next;
            count--;
            return true;
        }
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(count==0)
            return false;
        else {
            tail = tail.pre;
            count--;
            return true;
        }
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(count==0)
            return -1;
        else
            return head.val;
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(count==0)
            return -1;
        else
            return tail.val;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return count==0;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return count==capacity;
    }
}

/**
 * Your LeetCode.MyCircularDeque object will be instantiated and called as such:
 * LeetCode.MyCircularDeque obj = new LeetCode.MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */