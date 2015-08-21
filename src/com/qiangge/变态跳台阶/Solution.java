package com.qiangge.变态跳台阶;

public class Solution {
	public int JumpFloorII(int target) {
		if (target < 0) {
			return -1;
		}
		if (target == 0) {
			return 1;
		}
		return 1 << (target - 1);
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int x = solution.JumpFloorII(5);
		System.out.println(x);
	}
}
