package me.inshion.test.lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLambda {

	Logger logger = LoggerFactory.getLogger(getClass());

	public static void main(String[] args) {
		TestLambda t = new TestLambda();
		t.test1();
		t.test2();
		t.test3();

		System.out.println("Over");
	}

	private void test1() {
		Runnable r = new Runnable() {

			@Override
			public void run() {
				logger.info("I am Test1");

			}
		};

		r.run();
	}

	private void test2() {
		Runnable r = () -> {
			Runnable r_inner = new Runnable() {

				@Override
				public void run() {
					logger.info("I am Test2");
				}
			};
			r_inner.run();
		};

		r.run();

	}

	private void test3() {
		Runnable r = () -> logger.info("I am Test3");

		r.run();

	}
}
