package com.hrao.model.first;

/**
 * 合并两个有序的链表
 * 实现方法为:递归方式
 */
public class MergeTwoListsDemo {


    public static ListNode mergeTwoLists(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        /**
         * 模拟场景1 : l1= 3,5 l2= 8,6
         * 如果l1的值比l2的值小,则递归取l1得下一个元素与l2进行比较,当l1全部递归比较完成时(l1的next为空,递归退出),则返回l2,那么l1的最后一个节点为l2的第一个节点。
         * 其他的场景可以依此类推。
         */
        if (node1.getVal() < node2.getVal()) {
            ListNode next1 =  mergeTwoLists(node1.getNext(), node2);
            node1.setNext(next1);
            return node1;
        } else {
            ListNode next2 =  mergeTwoLists(node1, node2.getNext());
            node2.setNext(next2);
            return node2;
        }
    }





    public static void main(String[] args) {
        ListNode l1 = new ListNode(null,1);
        ListNode l2 = new ListNode(null,6);
        ListNode l3 = new ListNode(null,9);
        l1.setNext(l2);
        l2.setNext(l3);


        ListNode l6 = new ListNode(null,4);
        ListNode l7 = new ListNode(null,5);
        ListNode l8 = new ListNode(null,7);
        l6.setNext(l7);
        l7.setNext(l8);


        ListNode mergeNode =  mergeTwoLists(l1,l6);
        while(mergeNode.getNext()!=null){
            System.out.println(mergeNode.getVal());
            mergeNode=mergeNode.getNext();
        }
        System.out.println(mergeNode.getVal());


    }

}



class ListNode {

    public ListNode next;
    public int val;

    public ListNode(ListNode next, int val) {
        this.next = next;
        this.val = val;
    }

    public ListNode() {
    }

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
