package me.inshion.test.lang;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestStream {

    public static void main(String[] args) {

        String[] numbers = { "1", "2", "3", "4", "5", "6" };
        List<String> l = Arrays.asList(numbers);
        List<Integer> r = l.stream().map(e -> new Integer(e)).filter(e -> isPrime(e)).distinct()
                .collect(Collectors.toList());
        System.out.println(r);

        l.stream().map(e -> new Integer(e)).filter(e -> isPrime(e)).distinct();
        System.out.println("OK");
    }

    private static boolean isPrime(Integer e) {
        System.out.println("isP:" + e);
        if (e == 2 || e == 5) {
            return true;
        }
        return false;

    }
}
