package com.qiangge.twoStacksImplementQueue;

import java.util.Stack;

public class Solution {
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void push(int node) {
		stack1.push(node);
	}

	public int pop() {
//		若stack2有元素 则直接弹出顶部元素
		while (!stack2.isEmpty()) {
			return stack2.pop();
		}
		while (!stack1.isEmpty()) {
			stack2.push(stack1.pop());
		}
		return stack2.pop();
	}
}
