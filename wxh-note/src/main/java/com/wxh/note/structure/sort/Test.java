package com.wxh.note.structure.sort;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author weixuhui
 * @Description
 * @Date 18/11/8 下午5:45
 **/
public class Test {

    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 7, 9, 2, 4, 6, 8, 0};

        int[] result = bubbleSort(nums);

        System.out.println(Arrays.stream(result).mapToObj(Integer::valueOf).collect(Collectors.toList()));
    }


    public static int[] quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
        return array;
    }

    public static void quickSort(int[] array, int left, int right) {

        if (left >= right) {
            return;
        }

        int base = array[left];
        int head = left;
        int tail = right;

        while (left != right) {

            while (array[right] >= base && left < right) {
                right--;
            }

            while (array[left] <= base && left < right) {
                left++;
            }

            int temp = array[right];
            array[right] = array[left];
            array[left] = temp;
        }

        array[head] = array[left];
        array[left] = base;

        quickSort(array, head, left - 1);
        quickSort(array, left + 1, tail);
    }

    public static int[] insertSort(int[] array) {

        int length = array.length;

        for (int i = 1; i < length; i++) {

            int insertIndex = i;
            int insertValue = array[insertIndex];

            for (int j = i - 1; j >= 0; j--) {

                int compareIndex = j;
                int compareValue = array[compareIndex];

                if (insertValue > compareValue) {
                    break;
                }

                array[compareIndex] = insertValue;
                array[insertIndex] = compareValue;
                insertIndex = compareIndex;
            }

        }
        return array;
    }

    public static int[] bubbleSort(int[] array) {

        int length = array.length;

        for (int i = 0; i < length - 1; i++) {

            for (int j = 0; j < length - 1; j++) {

                int bubbleValue = array[j];
                int compareValue = array[j + 1];

                if (bubbleValue > compareValue) {

                    array[j] = compareValue;
                    array[j + 1] = bubbleValue;
                }
            }
        }

        return array;
    }
}
