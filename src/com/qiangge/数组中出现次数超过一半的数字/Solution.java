package com.qiangge.数组中出现次数超过一半的数字;

public class Solution {
	public int MoreThanHalfNum_Solution(int[] array) {
		if (null == array || array.length == 0) {
			return -2;
		}
		return MoreThanHalfNumcheck(array, 0, array.length - 1);
	}

	private int MoreThanHalfNumcheck(int[] array, int start, int end) {
		int middle = (array.length - 1) >> 1; // 中位数
		int index = partition(array, start, end);
		while (index != middle) {
			if (index > middle) {
				end = index - 1;
				index = partition(array, start, end);
			} else {
				start = index + 1;
				index = partition(array, start, end);
			}
		}
		int result = array[middle];
		// 遍历数组判断 result是否出现次数超过一半
		int times = 0;
		for (int x : array) {
			if (x == result) {
				times++;
			}
		}
		if (times < array.length / 2) {
			return -20;
		} else {
			return result;
		}
	}

	private int partition(int[] array, int start, int end) {
		// 随机生成一下标
		int partition = -1;
		int randomIndex = (int) (Math.random() * array.length);
		swap(array, start, randomIndex);
		int index = array[start];
		int left = start;
		int right = end + 1;
		while (true) {
			// left的范围是0到倒数第二位 若left=end ++left会越界
			while (left < end && array[++left] < index)
				;
			// right向左运动到left处会停止 因为start是枢值

			while (array[--right] > index)
				;
			if (left < right) {
				swap(array, left, right);
			} else {
				break;
			}

		}
		swap(array, start, right);
		partition = right;

		return partition;
	}

	private void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;

	}

	public int MoreThanHalfNum_Solution_1(int[] array) {
		// 遍历数组是保存两个值：1.数组中的数字 2.数字出现的次数
		// 当遍历到下一个数字时 ，如果和我们之前遍历的数字相同则次数加1，否则减1；
		// 如果次数为0，保存下一个数字 并设次数为0；
		if (null == array || array.length == 0) {
			return -2;
		}
		int result = array[0];
		int times = 1;
		for (int i = 1; i < array.length; i++) {
			if (times == 0) {
				result = array[i];
				times = 1;
			} else if (result == array[i]) {
				times++;
			} else {
				times--;
			}

		}
		// 遍历数组判断 result是否出现次数超过一半
		int times2 = 0;
		for (int x : array) {
			if (x == result) {
				times2++;
			}
		}
		if (times2 < array.length / 2) {
			return -20;
		} else {
			return result;
		}
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] array = { 3, 5, 3, 56, 3, 45, 3, 3, 5, 3, 3, 4, 34, 3, 3, 4, 3,
				7, 56, 3, 3 };
		// int[] array1 = { 3, 5, 3, 56, 3, 45, 3, 6, 5, 3, 6, 4, 34, 3, 3, 4,
		// 6,
		// 7, 56, 6, 3 }; // 反例测试
		// int result = solution.MoreThanHalfNum_Solution(array1);
		int result = solution.MoreThanHalfNum_Solution_1(array);
		System.out.println(result);
	}
}