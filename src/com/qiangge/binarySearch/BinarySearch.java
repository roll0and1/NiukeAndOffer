package com.qiangge.binarySearch;

import java.util.Arrays;

public class BinarySearch {
	/**
	 * 常规写法（不考虑溢出）
	 * 
	 * @param array
	 *            （有序）
	 * 
	 * @param left
	 * @param right
	 */
	public void binarySearch(int[] array, int target) {
		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			int middle = (left + right)>>1;
			if (array[middle] == target) {
				System.out.println("找到了，在第" + middle + "个位置");
				return;
			}
			if (array[middle] < target) {
				left = ++middle;
			} else {
				right = --middle;
			}

		}
		// 没找到
		System.out.println("没发现" + target + "这个数！");
		System.out.println(1>>1);

	}

	/**
	 * 第一种查找并没有考虑到溢出的问题，left与right的和有可能会溢出
	 * 
	 * @param array
	 * @param target
	 */
	public void binarySearch1(int[] array, int target) {
		int left = 0;
		int right = array.length - 1;
		while (left <= right) {
			// 防止溢出 ,多用移位
			int middle =left+ (right - left) >>1 ;
			if (array[middle] == target) {
				System.out.println("找到了，在第" + middle + "个位置");
				return;
			}
			if (array[middle] < target) {
				left = ++middle;
			} else {
				right = --middle;
			}

		}
		// 没找到
		System.out.println("没发现" + target + "这个数！");

	}

	public static void main(String[] args) {
		BinarySearch b = new BinarySearch();
		int[] array = { 2, 5, 6, 1, 9 };
		Arrays.sort(array);
		b.binarySearch(array, 10);
	}
}
