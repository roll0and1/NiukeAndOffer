package com.qiangge.singleton;

/**
 * 
 * @author zha_zha 
 * 此类创建的单例只适用于单线程环境
 */

public class Singleton1 {
	private Singleton1() {

	}

	private static Singleton1 instance = null;

	public static Singleton1 getInstance() {
		if (instance == null) {
			instance = new Singleton1();
		}
		return instance;
	}

}
