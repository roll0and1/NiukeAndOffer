package com.qiangge.从1到n的整数中1出现的次数;


public class Solution {
	public int NumberOf1Between1AndN_Solution(int n) {
		int total = 0;
		if (n < 0) {
			return total;
		}
		// 从1开始遍历 分别计算每个数里1出现的个数
		for (int i = 1; i <= n; i++) {
			int j = i;
			while (j != 0) {
				if (j % 10 == 1) {
					total++;
				}
				j /= 10;
			}
		}
		return total;
	}
	public int NumberOf1Between1AndN_Solution1(int n) {
		int total=0;
		int temp=n;
		int length=0;
//		求出数字的位数
		while (temp!=0) {
			temp/=10;
			length++;
		}
		temp=n;
		for(int i=1;i<=length;i++){
			total+=temp/test(i)*test(i-1);
			int x=n/test(i-1)%10;
			if(x==1){
				total+=n%test(i-1)+1;
			}
			if(temp>1){
				total+=test(i-1);
			}
			
		}
		return total;
	}

	

	private int test(int a) {
		int num=1;
		if(a==0){
			return 1;
		}
		for(int i=1;i<=a;i++){
			num*=10;
		}
		return num;
	}
	public static void main(String[] args) {
		Solution solution = new Solution();
		int x = solution.NumberOf1Between1AndN_Solution(1234);
		int y = solution.NumberOf1Between1AndN_Solution1(88888);
		System.out.println(x);
		System.out.println(y);
	}
}
