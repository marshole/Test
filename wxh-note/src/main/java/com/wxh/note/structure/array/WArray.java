package com.wxh.note.structure.array;


/**
 * @author weixuhui
 * @Description
 * @Date 18/11/1 下午4:05
 **/
public class WArray<E> {

    E[] elementData;

    private int size;

    //默认构造
    public WArray(){
        //数据容量默认为10
        this(10);
    }

    public WArray(int capacity) {
        if(capacity >= 0){
            this.elementData = (E[]) new Object[capacity];
        }else{
            throw new IllegalArgumentException("capacity < 0");
        }
    }

    /**
     * 获取数组容量
     * @return
     */
    public int getCapacity(){
        return elementData.length;
    }

    /**
     * 获取元素size
     * @return
     */
    public int getSize(){
        return this.size;
    }

    public void add(E element){

    }

    public void add(int index,E element){

    }

    public void remove(int index){

    }

    public void remove(E element){

    }

}
