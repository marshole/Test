/*
 * Copyright (c) 2019 Wormpex.com. All Rights Reserved.
 */
package com.wxh.note.arithmetic.exam;

/**
 * <p>
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p/>
 *
 * @author weixuhui Date: 19/6/14 Time: 下午3:19
 */
public class Test1 {

	/*思路*/

	//利用二维数组由上到下，由左到右递增的规律，
	//那么选取右上角或者左下角的元素a[row][col]与target进行比较，
	//当target小于元素a[row][col]时，那么target必定在元素a所在行的左边,
	//即col--；
	//当target大于元素a[row][col]时，那么target必定在元素a所在列的下边,
	//即row++；


	/**
	 * 从左下角开始找
	 *
	 * @param target
	 * @param array
	 * @return
	 */
	private boolean findFromLowerLeftCorner(int target, int[][] array) {

		int row = array.length - 1;

		int i = 0;

		while (row >= 0 && i < array[0].length) {
			if (array[row][i] > target) {
				row--;
			} else if (array[row][i] < target) {
				i++;
			} else {
				return true;
			}

		}
		return false;
	}

	/**
	 * 从右上角开始找
	 *
	 * @param target
	 * @param array
	 * @return
	 */
	private boolean findFromUpperRightCorner(int target, int[][] array) {

		int column = array[0].length - 1;

		int row = 0;

		while (column >= 0 && row < array.length) {
			if (array[row][column] > target) {
				column--;
			} else if (array[row][column] < target) {
				row++;
			} else {
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int[][] array = {
				{1, 2, 3, 4},
				{2, 3, 4, 5},
				{3, 4, 5, 6},
				{4, 5, 6, 7}
		};

		int target = 3;
	}
}
