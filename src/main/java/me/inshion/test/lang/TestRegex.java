package me.inshion.test.lang;

import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestRegex {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " " + isPrime(i));
        }
    }

    private static boolean isPrime(Integer e) {
        Pattern p = Pattern.compile("^1?$|^(11+?)\\1+$");
        return !p.matcher(Stream.iterate("1", f -> f).limit(e).collect(Collectors.joining()))
                .matches();
    }
}
