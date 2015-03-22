package me.inshion.test.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLog {

	static final Logger logger = LoggerFactory.getLogger(TestLog.class);

	public static void main(String[] args) {

		System.out.println("Current Log Impl:" + logger.getClass());

		logger.info("{}", 123);

		System.out.println("Run Over:" + TestLog.class.getSimpleName());
	}
}
