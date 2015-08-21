package com.qiangg.斐波那契数列;

public class Solution {

	// pre curent temp
	// ------pre current temp
	// ----------- pre current temp

	public int Fibonacci(int n) {
		if (n < 0) {
			System.out.println("error");
		}
		if (n == 0) {
			return 0;
		}
		if (n == 1 || n == 2) {
			return 1;
		}
		int i = 3;
		int pre = 1;
		int current = 1, temp;
		while (i <= n) {
			temp = pre + current;
			pre = current;
			current = temp;
			i++;
		}
		return current;

	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int x = solution.Fibonacci(6);
		System.out.println(x);
	}
}
