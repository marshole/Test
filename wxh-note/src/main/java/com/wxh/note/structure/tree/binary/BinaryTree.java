package com.wxh.note.structure.tree.binary;


import lombok.AllArgsConstructor;

import java.util.Objects;

/**
 * @author weixuhui
 * @Description
 * @Date 18/7/12 下午8:53
 **/
@AllArgsConstructor
public class BinaryTree {

    private BinaryNode root;


    public static void main(String[] args) {
        //BinaryNode
        BinaryTree binaryTree = new BinaryTree(BinaryTree.initBinaryTree());
        postorderTraversal(binaryTree.root);
    }


    /**
     * @Description 初始化一个二叉树 返回根节点
     * @Author xuhui.wei
     * @Date 18/7/13 下午3:24
     * @Param []
     * @return com.wxh.note.structure.tree.binary.BinaryNode
     **/
    private static BinaryNode initBinaryTree(){
        BinaryNode J = new BinaryNode("J", null, null);
        BinaryNode H = new BinaryNode("H", null, null);
        BinaryNode G = new BinaryNode("G", null, null);
        BinaryNode F = new BinaryNode("F", null, J);
        BinaryNode E = new BinaryNode("E", H, null);
        BinaryNode D = new BinaryNode("D", null, G);
        BinaryNode C = new BinaryNode("C", F, null);
        BinaryNode B = new BinaryNode("B", D, E);
        BinaryNode A = new BinaryNode("A", B, C);
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
            inorderTraversal(root.getLeftNode());
        }

        println(root);

        if(Objects.nonNull(root.getRightNode())){
            inorderTraversal(root.getRightNode());
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
            postorderTraversal(root.getLeftNode());
        }

        if(Objects.nonNull(root.getRightNode())){
            postorderTraversal(root.getRightNode());
        }

        println(root);

    }

    private static void println(BinaryNode BinaryNode){
        System.out.println(BinaryNode.getElement());
    }

}
