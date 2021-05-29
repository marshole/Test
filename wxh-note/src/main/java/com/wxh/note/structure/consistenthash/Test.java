/*
 * Copyright (c) 2021 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.structure.consistenthash;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author weixuhui Date: 2021/5/1 Time: 5:07 下午
 */
public class Test {


    /**
     * 验证普通 hash 对于增减节点，原有会不会出现移动。
     */
    public static void main(String[] args) {

        NodeArray nodeArray = new NodeArray();

        Node[] nodes = {
                new Node("Node--> 1"),
                new Node("Node--> 2"),
                new Node("Node--> 3")
        };

        for (Node node : nodes) {
            nodeArray.addNode(node);
        }

        Obj[] objs = {
                new Obj("1"),
                new Obj("2"),
                new Obj("3"),
                new Obj("4"),
                new Obj("5")
        };

        for (Obj obj : objs) {
            nodeArray.put(obj);
        }

        validate(nodeArray, objs);
    }

    private static void validate(NodeArray nodeArray, Obj[] objs) {
        for (Obj obj : objs) {
            System.out.println(nodeArray.get(obj));
        }

        nodeArray.addNode(new Node("anything1"));
        nodeArray.addNode(new Node("anything2"));

        System.out.println("========== after  =============");

        for (Obj obj : objs) {
            System.out.println(nodeArray.get(obj));
        }
    }

    static class Obj {
        String key;

        Obj(String key) {
            this.key = key;
        }

        @Override
        public int hashCode() {
            return key.hashCode();
        }

        @Override
        public String toString() {
            return "Obj{" +
                    "key='" + key + '\'' +
                    '}';
        }
    }


    static class Node {

        Map<Integer, Obj> node = new HashMap<>();
        String name;

        Node(String name) {
            this.name = name;
        }

        public void putObj(Obj obj) {
            node.put(obj.hashCode(), obj);
        }

        Obj getObj(Obj obj) {
            return node.get(obj.hashCode());
        }

        @Override
        public int hashCode() {
            return name.hashCode();
        }
    }

/*    static class NodeArray {

        Node[] nodes = new Node[1024];
        int size = 0;

        public void addNode(Node node) {
            nodes[size++] = node;
        }

        Obj get(Obj obj) {
            int index = obj.hashCode() % size;
            return nodes[index].getObj(obj);
        }

        void put(Obj obj) {
            int index = obj.hashCode() % size;
            nodes[index].putObj(obj);
        }
    }*/


    static class NodeArray {

        /** 按照 键 排序*/
        TreeMap<Integer, Node> nodes = new TreeMap<>();

        void addNode(Node node) {
            nodes.put(node.hashCode(), node);
        }

        void put(Obj obj) {
            int objHashcode = obj.hashCode();
            Node node = nodes.get(objHashcode);
            if (node != null) {
                node.putObj(obj);
                return;
            }

            // 找到比给定 key 大的集合
            SortedMap<Integer, Node> tailMap = nodes.tailMap(objHashcode);
            // 找到最小的节点
            int nodeHashcode = tailMap.isEmpty() ? nodes.firstKey() : tailMap.firstKey();
            nodes.get(nodeHashcode).putObj(obj);

        }

        Obj get(Obj obj) {
            Node node = nodes.get(obj.hashCode());
            if (node != null) {
                return node.getObj(obj);
            }

            // 找到比给定 key 大的集合
            SortedMap<Integer, Node> tailMap = nodes.tailMap(obj.hashCode());
            // 找到最小的节点
            int nodeHashcode = tailMap.isEmpty() ? nodes.firstKey() : tailMap.firstKey();
            return nodes.get(nodeHashcode).getObj(obj);
        }
    }


}
