package com.qiangge.去哪儿.二分查找;

public class BinarySearch {
	public int getPos(int[] A, int n, int val) {
		if (null == A || A.length == 0 || n < 0) {
			return -1;
		}
		int start = 0;
		int end = A.length - 1;
		int middle = -1;
		int pos = -1;
		while (start <= end) {
			middle = start + ((end - start) >> 1);
			if (A[middle] == val) {
				pos = middle;
				// 判断第一次出现的位置
				for (int i = pos - 1; i >= 0; i--) {
					if (A[i] != val) {
						return pos;
					}
				}
				return 0;
			} else if (A[middle] > val) {
				end = middle - 1;
			} else {
				start = middle + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		BinarySearch b = new BinarySearch();
		int[] A = {  6, 11, 28, };
		int x = b.getPos(A, 10, 11);
		System.out.println(x);
	}
}
