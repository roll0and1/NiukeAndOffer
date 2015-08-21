package com.qiangge.跳台阶;

public class Solution {
	public int JumpFloor(int target) {
		if (target < 0) {
			return -1;
		}
		if (target == 0 || target == 1) {
			return 1;
		}
		return JumpFloor(target - 1) + JumpFloor(target - 2);

	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int x = solution.JumpFloor(3);
		System.out.println(x);
	}
}
