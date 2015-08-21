package com.qiangge.旋转最小的数字;

public class Solution {
	public int minNumberInRotateArray(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int result = 0;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				result = array[i + 1];
				return result;
			}
		}
		// 数组将全部元素进行旋转 最小数是第一个
		result = array[0];
		return result;
	}

	public int minNumberInRotateArray1(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int left = 0;
		int right = array.length - 1;
		int middle = 0; // zhuyi
		// 此种循环不适合 类似于12345
		// while (left + 1 != right) {
		// middle = (left + right) / 2;
		// if (array[left] == array[right] && array[left] == array[middle]) {
		// return min(array, left, right);
		// }
		// if (array[left] <= array[middle]) {
		// left = middle;
		// } else if (array[middle] <= array[right]) {
		// right = middle;
		// }
		// }
		// return array[right];
		while (array[left] >= array[right]) {
			middle = (left + right) / 2;
			// 找到最小的数 return
			if (left + 1 == right) {
				return array[right];

			}
			// 此时无法判断 array[middle]是处于递增数组还是递减数组中必须逐个比较
			if (array[left] == array[middle] && array[middle] == array[right]) {
				return min(array, left, right);
			}
			if (array[left] <= array[middle]) {
				left = middle;
			} else if (array[middle] <= array[right]) {
				right = middle;
			}
		}
		// 跳出循环表明此数组是纯递增数组 最小值是第一个
		return array[left];
	}

	private int min(int[] array, int left, int right) {
		int result = 0;
		for (int i = left; i < right; i++) {
			if (array[i] > array[i + 1]) {
				result = array[i + 1];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] array = { 2, 3, 4, 5 };
		int x = solution.minNumberInRotateArray1(array);
		System.out.println(x);
	}
}
