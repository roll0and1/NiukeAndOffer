package com.qiangge.子集;

public class Subset {
	 int i=1;
	public void subset(String str) {
		if (null != str) {
			resubset("", str);

		}
	}

	/**
	 * 
	 * @param current
	 *            当前的字符串
	 * @param rest
	 *            剩下的字符串
	 */
	private void resubset(String current, String rest) {
		// 每次面临两次选择，选或不限rest中的第一个字符
		if ("".equals(rest)) {
			System.out.println(current+":"+(i++) );
			
		} else {
			// 每次都选一个
			resubset(current + rest.substring(0, 1), rest.substring(1));
			// 每次都不选
			resubset(current, rest.substring(1));

		}
	}

	public static void main(String[] args) {
		Subset subset = new Subset();
		subset.subset("abc");

	}
}
