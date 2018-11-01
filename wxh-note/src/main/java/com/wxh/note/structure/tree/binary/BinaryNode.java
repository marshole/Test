package com.wxh.note.structure.tree.binary;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author weixuhui
 * @Description
 * @Date 18/7/12 下午8:45
 **/

@Data
@AllArgsConstructor
public class BinaryNode<T> {

    private T element;

    private BinaryNode<T> leftNode;

    private BinaryNode<T> rightNode;

}
