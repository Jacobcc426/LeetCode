package LeetCode;

import java.util.Stack;

public class LeetCode232 {
}
class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    /** Initialize your data structure here. */
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(stack1.empty())
            return -1;

        while(!stack1.empty()){
            stack2.push(stack1.pop());
        }
        int res = stack2.pop();
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return res;
    }

    /** Get the front element. */
    public int peek() {
        if(stack1.empty())
            return -1;

        while(!stack1.empty()){
            stack2.push(stack1.pop());
        }
        int res = stack2.peek();
        while (!stack2.empty()){
            stack1.push(stack2.pop());
        }
        return res;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.empty();
    }
}

/**
 * Your LeetCode.MyQueue object will be instantiated and called as such:
 * LeetCode.MyQueue obj = new LeetCode.MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */