package com.qiangge.singleton;

/**
 * 
 * @author zha_zha 这种方法最优（建议使用这个方法 ）
 */

class Singleton3 {
	private Singleton3() {

	}

	private static Singleton3 instance = new Singleton3();

	public static Singleton3 getInstance() {
		return instance;
	}

}

class Singleton3_change {
	private Singleton3_change() {

	}

	private static class LazyHolder {
		private static final Singleton3_change instance = new Singleton3_change();
	}

	public static Singleton3_change getInstance() {
		return LazyHolder.instance;
	}

}
