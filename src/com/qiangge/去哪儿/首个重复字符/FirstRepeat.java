package com.qiangge.去哪儿.首个重复字符;

import java.util.HashMap;
import java.util.Map;

public class FirstRepeat {
	public char findFirstRepeat(String A, int n) {
		if (null == A || A.length() == 0 || n < 0) {
			System.out.println("wrong");
			return '~';
		}
		char result = ' ';
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (int i = 0; i < A.length(); i++) {
			char temp = A.charAt(i);
			if (map.containsKey(temp)) {
				int value = (int) map.get(temp);
				if (value == 1) {
					result = temp;
					break;
				}
			} else {
				map.put(temp, 1);
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		FirstRepeat f = new FirstRepeat();
		char x = f.findFirstRepeat("qywyer23tdd", 11);
		System.out.println(x);

	}
}