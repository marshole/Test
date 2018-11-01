package com.wxh.note.structure.tree.binary;


import java.util.Objects;

/**
 * @author weixuhui
 * @Description
 * @Date 18/7/12 下午8:53
 **/
public class BinaryTree {

    private BinaryNode root;



    public static void main(String[] args) {
        //BinaryNode
    }


    /**
     * @Description 初始化一个二叉树 返回根节点
     * @Author xuhui.wei
     * @Date 18/7/13 下午3:24
     * @Param []
     * @return com.wxh.note.structure.tree.binary.BinaryNode
     **/
    private static BinaryNode initBinaryTree(){
        BinaryNode J = new BinaryNode(8, null, null);
        BinaryNode H = new BinaryNode(4, null, null);
        BinaryNode G = new BinaryNode(2, null, null);
        BinaryNode F = new BinaryNode(7, null, J);
        BinaryNode E = new BinaryNode(5, H, null);
        BinaryNode D = new BinaryNode(1, null, G);
        BinaryNode C = new BinaryNode(9, F, null);
        BinaryNode B = new BinaryNode(3, D, E);
        BinaryNode A = new BinaryNode(6, B, C);
        return A;
    }

    /**
     * @Description 前序遍历
     * @Author xuhui.wei
     * @Date 18/7/13 下午3:09
     * @Param [root]
     * @return void
     **/
    private static void preorderTraversal(BinaryNode root){

        println(root);

        if(Objects.nonNull(root.getLeftNode())){
            preorderTraversal(root.getLeftNode());
        }

        if(Objects.nonNull(root.getRightNode())){
            preorderTraversal(root.getRightNode());
        }
    }

    /**
     * @Description 中序遍历
     * @Author xuhui.wei
     * @Date 18/7/13 下午3:19
     * @Param [root]
     * @return void
     **/
    private static void inorderTraversal(BinaryNode root){

        if(Objects.nonNull(root.getLeftNode())){
            inorderTraversal(root);
        }

        println(root);

        if(Objects.nonNull(root.getRightNode())){
            inorderTraversal(root);
        }
    }

    /**
     * @Description 后续遍历
     * @Author xuhui.wei
     * @Date 18/7/13 下午3:22
     * @Param [root]
     * @return void
     **/
    private  static void postorderTraversal(BinaryNode root){

        if(Objects.nonNull(root.getLeftNode())){
            inorderTraversal(root);
        }

        if(Objects.nonNull(root.getRightNode())){
            inorderTraversal(root);
        }

        println(root);

    }

    private static void println(BinaryNode BinaryNode){
        System.out.println(BinaryNode.getElement());
    }

}
