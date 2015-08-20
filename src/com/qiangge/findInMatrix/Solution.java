package com.qiangge.findInMatrix;

public class Solution {
	/**
	 * 暴力查找
	 * 
	 * @param array
	 * @param target
	 * @return
	 */
	public boolean Find(int[][] array, int target) {
		boolean result = false;
		if (array != null && array.length != 0) {

			int row = array.length; // 获取行数
			int col = array[0].length; // 获取列数
			for (int i = 0; i < row; i++)
				for (int j = 0; j < col; j++)
					if (array[i][j] == target) {
						result = true;
					}
		}

		return result;
	}

	/**
	 * 选取数组右上角的数字来逐步删除，如果右上角的数组等于要查找的数字则查找结束； 如果该数字大于要查找的数字则筛除该数字所在列；
	 * 如果小于要找的数字则筛除所在行； 逐步缩小查找范围。
	 * 
	 * @param array
	 * @param target
	 * @return
	 */
	public boolean Find1(int[][] array, int target) {
		boolean result = false;
		if (array != null && array.length != 0) {

			int row = array.length; // 获取行数
			int col = array[0].length; // 获取列数
			int x = 0;
			int y = col-1;
			while (x < row && y >= 0) {
				if (array[x][y] == target) {
					result = true;
					break;
				} else if (array[x][y] > target) {
					y--;
				} else {
					x++;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[][] array = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 },
				{ 6, 8, 11, 15 } };
		System.out.println(solution.Find(array, 100));
		System.out.println(solution.Find1(array, 100));
	}

}
