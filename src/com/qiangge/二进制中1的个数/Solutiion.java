package com.qiangge.二进制中1的个数;

public class Solutiion {
	public int NumberOf1(int n) {
		String str = Integer.toBinaryString(n);
		int times = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1') {
				times++;
			}
		}
		return times;

	}

	/**
	 * 规避 -1>>1 死循环
	 * 
	 * @param n
	 * @return
	 */
	public int NumberOf1_1(int n) {
		int times = 0;
		int flag = 1;
		// 负数-2147483648（补码为：1000 0000 0000 0000 0000 0000 0000 0000）左移一位则为0
		while (flag != 0) {
			if ((n & flag) != 0) {
				times++;
			}
			System.out.println(flag);
			flag <<= 1;
		}
		return times;
	}

	/**
	 * 把一个整数减去1，再和原来数相&这样会把最右边的一个1变成0
	 * 
	 * @param n
	 * @return
	 */
	public int NumberOf1_2(int n) {
		int times = 0;
		while (n != 0) {
			times++;
			n = (n - 1) & n;
		}
		return times;
	}

	public static void main(String[] args) {
		Solutiion solutiion = new Solutiion();
		System.out.println(solutiion.NumberOf1(-1));
		System.out.println(solutiion.NumberOf1_1(-1));
		System.out.println(solutiion.NumberOf1_2(-1));
		System.out.println("``````````````````````````````````````````");
		System.out.println(0xFFFFFFFF >> 1);
		System.out.println(0xC0000000);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		String str = Integer.toBinaryString(-2147483648);
		System.out.println(str);
		System.out.println("===============================");
		System.out.println(-2147483648<<1);
	}
}
