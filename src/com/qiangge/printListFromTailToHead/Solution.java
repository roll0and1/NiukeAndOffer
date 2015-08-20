package com.qiangge.printListFromTailToHead;

import java.util.ArrayList;

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}

class LinkedList {
	private ListNode first;

	public ListNode getFirst() {
		return first;
	}

	public ListNode getTail() {
		return tail;
	}

	private ListNode tail;

	public LinkedList() {
		first = null;
		tail = null;
	}

	/**
	 * 头插法
	 * 
	 * @param value
	 */
	public void HeadInsert(int value) {
		ListNode newNode = new ListNode(value);
		newNode.next = first;
		first = newNode;

	}

	/**
	 * 尾插法
	 * 
	 * @param value
	 */
	public void TailInsert(int value) {
		ListNode newNode = new ListNode(value);
		if (first == null) {
			first = newNode;
			tail = first;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
	}

	public void displayList() {
		ListNode begin = this.first;
		while (begin != null) {
			System.out.println(begin.val);
			begin = begin.next;
		}
	}
}

public class Solution {
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> alist1 = new ArrayList<Integer>();
		ArrayList<Integer> alist2 = new ArrayList<Integer>();
		while (listNode != null) {
			alist1.add(listNode.val);
			listNode = listNode.next;
		}
		Object[] objects = alist1.toArray();
		for (int i = objects.length - 1; i >= 0; i--)
			alist2.add((Integer) objects[i]);
		return alist2;
	}

	/**
	 * 递归
	 * 
	 * @param listNode
	 * @return
	 */
	public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (listNode != null) {
			print(listNode, result);
		}
		return result;
	}

	private void print(ListNode listNode, ArrayList<Integer> result) {
		if (listNode.next != null) {
			print(listNode.next, result);
		}
		result.add(listNode.val);
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.TailInsert(5);
		list.TailInsert(4);
		list.TailInsert(3);
		list.TailInsert(2);
		list.TailInsert(1);
		list.TailInsert(0);
		list.displayList();
		System.out.println();
		Solution solution = new Solution();
		ArrayList<Integer> result=solution.printListFromTailToHead1(list.getFirst());
		for(int x:result){
			System.out.println(x+";");
		}
	}
}
