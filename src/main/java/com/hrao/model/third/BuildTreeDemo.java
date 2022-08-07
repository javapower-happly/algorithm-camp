package com.hrao.model.third;

import java.util.Arrays;

/**
 * 从中序与后序遍历序列构造二叉树
 */
public class BuildTreeDemo {


    public static void main(String[] args) {

        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        TreeNode node = buildTree(inorder, postorder);



    }




    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        int i_len = inorder.length;
        int p_len = postorder.length;
        if (i_len == 0 || p_len == 0) {
            return null;
        }
        //通过后序序列，查找子树的根节点
        int root_val = postorder[p_len - 1];
        //构造根节点
        TreeNode root = new TreeNode(root_val);
        //遍历中序序列，确定根结点在中序序列中的位置，从而确定左右子树
        int k = 0;
        for (int i = 0; i < i_len; i++) {
            if (root_val == inorder[i]) {
                k = i;
                break;
            }
        }
        //分割左右子树，分别创建左右子树的中序、后序序列
        int[] left_in = Arrays.copyOfRange(inorder, 0, k);
        int[] left_post = Arrays.copyOfRange(postorder, 0, k);
        root.left = buildTree(left_in, left_post);

        int[] right_in = Arrays.copyOfRange(inorder, k + 1, i_len);
        int[] right_post = Arrays.copyOfRange(postorder, k, p_len - 1);
        root.right = buildTree(right_in, right_post);
        return root;
    }


}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
