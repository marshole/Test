/*
 * Copyright (c) 2023 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.java.test;

/**
 * @author weixuhui Date: 2023/11/3 Time: 15:38
 */
public class ListNodeTest {

    public static void main(String[] args) {

        ListNode head = new ListNode(1,new ListNode(1,new ListNode(1, new ListNode(1, new ListNode(2)))));
        ListNode duplicateNodes = removeDuplicateNodes(head);
        System.out.println();
    }

    public static ListNode removeDuplicateNodes(ListNode head) {

        ListNode curr = head;
        while(curr != null){
            ListNode compare = curr;
            while(compare != null && compare.next != null){
                if(curr.val == compare.next.val){
                    compare.next = compare.next.next;
                }else{
                    compare = compare.next;
                }
            }
            curr = curr.next;
        }

        return head;
    }


}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x, ListNode next) {
        val = x;
        this.next = next;
    }

    ListNode(int x) {
        val = x;
        next = null;
    }
}
