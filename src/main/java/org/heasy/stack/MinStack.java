package org.heasy.stack;

import java.util.EmptyStackException;
import java.util.Stack;

public class MinStack {

    private Stack<Integer> mStack;
    private Stack<Integer> stack;

    /** initialize your data structure here. */
    public MinStack() {
        mStack = new Stack<>();
        stack = new Stack<>();
    }

    public void push(int x) {
        //注意使用小于等于 防止多个最小值只存了一个导致错误
        if (mStack.isEmpty() || mStack.peek()>=x){
            mStack.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        Integer pop = stack.pop();
        if (pop.equals(mStack.peek())) {
            mStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return mStack.peek();
    }
}
