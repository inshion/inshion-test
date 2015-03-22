package me.inshion.test.lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

interface MyInterface2 {

	int foo(int a, int b);

}

public class TestLambda2 {

	Logger logger = LoggerFactory.getLogger(getClass());

	private void test2(MyInterface2 inter) {

		logger.info("2ret:{}", inter.foo(4, 5));
	}

	private void test3() {

		test2(this::foo);
	}

	private static int multi(int a, int b) {
		return a * b;
	}

	private static int add(int a, int b) {
		return a + b;
	}

	private int foo(int a, int b) {
		return a - b;
	}

	public static void main(String[] args) {

		TestLambda2 t = new TestLambda2();
		t.test2(new MyInterface2() {

			@Override
			public int foo(int a, int b) {
				return a * b;
			}
		});

		System.out.println("step 1");
		t.test2((a, b) -> {
			return a + b;
		});

		System.out.println("step 2");
		t.test2(TestLambda2::multi);
		t.test2(TestLambda2::add);
		t.test2("".equals("") ? TestLambda2::add : TestLambda2::multi);
		System.out.println("step 3");

		t.test3();
	}
}
