package me.inshion.test.lang;

public class TestMethodRef {

	interface Method<FROM, TO> {

		TO parse(FROM from);
	}

	public static void main(String[] args) {

		Method<String, Integer> x = Integer::valueOf;

		Integer to = x.parse("1234");
		System.out.println(to);
	}
}
