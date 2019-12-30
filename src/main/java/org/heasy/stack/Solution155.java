package org.heasy.stack;

import java.util.EmptyStackException;
import java.util.Stack;

public class Solution155 {

    private Stack<Integer> mStack;
    private Stack<Integer> stack;

    /**
     * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
     *
     * push(x) -- 将元素 x 推入栈中。
     * pop() -- 删除栈顶的元素。
     * top() -- 获取栈顶元素。
     * getMin() -- 检索栈中的最小元素。
     */
    /** initialize your data structure here. */
    public Solution155() {
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
