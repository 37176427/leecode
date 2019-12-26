package org.heasy.stack;

import java.util.Stack;

public class MyQueue {


	/**
	 * 使用辅助栈
	 * 一定要保证 hStack 为空的时候，才能把元素从 stack 里拿到 hStack 中。
	 */
        private Stack<Integer> stack;
        private Stack<Integer> hStack;


        /** Initialize your data structure here. */
        public MyQueue() {
        	stack = new Stack<>();
        	hStack = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
        	stack.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
        	if (hStack.isEmpty()){
		        while (stack.size()>0){
			        hStack.push(stack.pop());
		        }
	        }
			return hStack.pop();
        }

        /** Get the front element. */
        public int peek() {
	        if (hStack.isEmpty()){
		        while (stack.size()>0){
			        hStack.push(stack.pop());
		        }
	        }
	        return hStack.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
			return stack.isEmpty()&&hStack.isEmpty();
        }

}
