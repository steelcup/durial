package s0151;
/*
155. Min Stack
Easy

Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

    push(x) -- Push element x onto stack.
    pop() -- Removes the element on top of the stack.
    top() -- Get the top element.
    getMin() -- Retrieve the minimum element in the stack.

Example:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.
 */
import java.util.*;

public class ST0155 {
    //only push in the min when there is a change
    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;

    public ST0155() {

    }

    public void push(int x) {
        if (x <= this.min) {
            stack.push(this.min);
            this.min = x;
        }
        stack.push(x);
    }

    public void pop() {
        int n = stack.pop();
        if (n == this.min) {
            this.min = stack.pop();
        }
    }

    public int top() {
        return this.stack.peek();
    }

    public int getMin() {
        return min;
    }
}
