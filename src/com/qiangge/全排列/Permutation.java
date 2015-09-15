package com.qiangge.全排列;

public class Permutation {
	int i = 1;

	public void permutation(String str) {
		rePermutation("", str);
	}

	/**
	 * 
	 * @param current
	 *            当前字符串
	 * @param rest
	 *            剩下的字符串
	 */
	// 依次从剩余中取一个字符加到current中，当剩余的字符串为“”时打印current
	private void rePermutation(String current, String rest) {
		if ("".equals(rest)) {
			System.out.println(current + ":" + (i++));
		} else {
			for (int i = 0; i < rest.length(); i++) {
				rePermutation(current + rest.charAt(i), rest.substring(0, i)
						+ rest.substring(i + 1));
			}
		}
	}

	public static void main(String[] args) {
		Permutation permutation = new Permutation();
		permutation.permutation("12345");
	}
}
