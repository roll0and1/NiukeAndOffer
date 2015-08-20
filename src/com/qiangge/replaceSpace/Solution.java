package com.qiangge.replaceSpace;

public class Solution {
	public String replaceSpace(StringBuffer str) {
		String result = null;
		if (str != null) {
			while (str.indexOf(" ") != -1) {
				int i = str.indexOf(" "); // 找到空格的位置
				str.deleteCharAt(i);// 删除该位置
				str.insert(i, "%20");// 将替代物插入
			}
			result = str.toString();
		}
		return result;
	}

	public String replaceSpace1(StringBuffer str) {
		String result = null;
		if (str != null) {
			String temp = str.toString();
			result = temp.replace(" ", "%20");
		}
		return result;
	}

	public static void main(String[] args) {

		Solution solution = new Solution();
		StringBuffer str = new StringBuffer("hah hah ");
		String xString = solution.replaceSpace(str);
		System.out.println(xString);
		String xString1 = solution.replaceSpace1(str);
		System.out.println(xString1);
	}
}
