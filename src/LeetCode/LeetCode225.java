package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class LeetCode225 {
}
class LeetCode225MyStack {
    List<Integer> Stack;
    /** Initialize your data structure here. */
    public LeetCode225MyStack() {
        Stack = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        Stack.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return Stack.remove(Stack.size()-1);
    }

    /** Get the top element. */
    public int top() {
        return Stack.get(Stack.size()-1);
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return Stack.size()==0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
