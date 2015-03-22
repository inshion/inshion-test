package me.inshion.test.lang;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

interface MyInterface {

	int foo(int a, int b);
	
	default String bar(String x) {
		return x;
	}
}

public class TestLambda1 {

	Logger logger = LoggerFactory.getLogger(getClass());

	private void test1() {

		MyInterface m = (a, b) -> {
			return a + b;
		};

		int ret = m.foo(1, 4);

		logger.info("ret:{} {}", ret, m.bar("bbb"));
	}

	public static void main(String[] args) {

		TestLambda1 t = new TestLambda1();
		t.test1();
	}
}
