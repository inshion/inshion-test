package me.inshion.test.lang;

import java.util.concurrent.ConcurrentHashMap;

class MyObj {

    MyObj(String name) {

        System.out.println("Newed " + name);
    }

}

public class TestMP {

    static ConcurrentHashMap<String, MyObj> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {

        MyObj obj1 = map.computeIfAbsent("a", MyObj::new);
        System.out.println(obj1);

        MyObj obj2 = map.computeIfAbsent("a", MyObj::new);
        System.out.println(obj2);

        System.out.println(obj1 == obj2);

    }
}
