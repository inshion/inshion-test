package me.inshion.test.lang;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface F {

	void a();

	void b();

}

class FA implements InvocationHandler {

	FA(F f) {
		this.f = f;
	}

	F f;

	public void test() {
		System.out.println("f:" + f);
	}

	@Override
	public Object invoke(Object o, Method m, Object[] objs) throws Throwable {
		System.out.println("invoking");
		return m.invoke(f, objs);
	}

}

public class TestProxy {

	public static void main(String[] args) {
		F f = new F() {

			@Override
			public void b() {
				System.out.println("bbbb");
			}

			@Override
			public void a() {
				System.out.println("aaaa");

			}
		};
		F p = (F) Proxy.newProxyInstance(TestProxy.class.getClassLoader(), f.getClass().getInterfaces(), new FA(f));

		p.a();
		p.b();

	}
}
