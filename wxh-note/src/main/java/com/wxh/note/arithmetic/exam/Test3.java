/*
 * Copyright (c) 2019 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.arithmetic.exam;

import java.util.ArrayList;
import java.util.Stack;

/**
 * <p>输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。<p/>
 *
 * @author weixuhui Date: 19/6/14 Time: 下午5:44
 */
public class Test3 {


	ArrayList<Integer> arrayList = new ArrayList<Integer>();


	/**
	 * 利用递归
	 *
	 * @param listNode
	 * @return
	 */
	public ArrayList<Integer> recursive(ListNode listNode) {
		if (listNode != null) {
			recursive(listNode.next);
			arrayList.add(listNode.val);
		}
		return arrayList;
	}

	public ArrayList<Integer> useStack(ListNode listNode) {

		Stack<Integer> stack = new Stack();

		do {
			stack.push(listNode.val);
			listNode = listNode.next;
		} while (listNode != null);

		stack.forEach(arrayList::add);

		return arrayList;
	}


	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
}
