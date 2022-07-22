package com.hrao.model.first;

public class MergeTwoListsDemo {


    public ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        if (node1.getVal() > node2.getVal()) {
            node1.setNext(mergeTwoLists(node1.getNext(), node2));
            return node1;
        } else {
            node2.setNext(mergeTwoLists(node2.getNext(), node1));
            return node2;
        }
    }


}


class ListNode {

    private ListNode next;
    private int val;

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}
