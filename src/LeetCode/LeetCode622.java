package LeetCode;

public class LeetCode622 {
}
class MyCircularQueue {
    private ListNode head,tail;
    private int count;
    private int capacity;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.capacity = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(this.capacity==this.count)
            return false;

        ListNode listNode = new ListNode(value);
        if (this.count == 0) {
            head = tail = listNode;
        }else {
            tail.next = listNode;
            tail = listNode;
        }
        this.count++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(this.count==0)
            return false;
        this.head = this.head.next;
        this.count--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(this.count==0)
            return -1;
        return this.head.val;
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(this.count==0)
            return -1;
        return this.tail.val;

    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return this.count==0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return this.count==this.capacity;
    }
}

/**
 * Your LeetCode.MyCircularQueue object will be instantiated and called as such:
 * LeetCode.MyCircularQueue obj = new LeetCode.MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */