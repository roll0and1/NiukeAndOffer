package com.qiangge.singleton;

/**
 * 
 * @author zha_zha 此类创建的单例适用于多线程环境 但因为枷锁了性能降低不少 
 */

public class Singleton2 {
	private Singleton2() {

	}

	private static Object o;
	private static Singleton2 instance = null;

	public static Singleton2 getInstance() {
		synchronized (o) {
			if (instance == null) {
				instance = new Singleton2();
			}
		}
		return instance;
	}

	// public synchronized static Singleton2 getInstance() {
	// if (instance == null) {
	// instance = new Singleton2();
	// }
	// return instance;
	// }

}
