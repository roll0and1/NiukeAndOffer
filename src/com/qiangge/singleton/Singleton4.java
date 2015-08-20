package com.qiangge.singleton;

/**
 * double-check-locking 保证实例化对象的逻辑段被一个线程执行即可返回那段没必要同步
 */

public class Singleton4 {
	private Singleton4() {

	}

	private static Singleton4 instance = null;

	/**
	 * 如果没有第二次检查，若有两个线程AB同时进入该方法，他们都检测到instance为null，不管哪个线程占据同步锁，并创建实例对象
	 * 都不会阻止另一个线程进入实例化代码重新创建实力对象，这样同样会生成两个实例对象，因此在同步代码块里要进行第二次判断，判断对象是否创建
	 * 
	 * @return
	 */
	public static Singleton4 getInstance() {
		if (instance == null) {
			synchronized (Singleton4.class) {
				if (instance == null) {
					instance = new Singleton4();
				}
			}
		}
		return instance;
	}

}
