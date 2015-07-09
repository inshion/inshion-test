package me.inshion.test.lang;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStream {

    public static void main(String[] args) {
        String[] numbers = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
        List<String> l = Arrays.asList(numbers);
        List<Integer> r = l.stream().map(e -> new Integer(e)).filter(TestStream::isPrime).distinct()
                .collect(Collectors.toList());
        System.out.println(r);
        System.out.println("OK");

        Stream.of("1", "2", "3", "4", "5", "6", "7", "8", "9").mapToInt(Integer::parseInt)
                .forEach(System.out::print);
        System.out.println();
        Stream.of("1", "2", "3", "4", "5", "6", "7", "8", "9").map(TestStream::cut)
                .forEach(System.out::print);
        System.out.println("-------");
        System.out.println("-------");
        Stream.of(Arrays.asList(1), Arrays.asList(2, 3), Arrays.asList(4, 5, 6))
                .peek(System.out::print).flatMap((v) -> v.stream()).forEach(System.out::print);

        System.out.println("  |=============>");
        Stream.of("one", "two", "three", "four").filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e)).map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e)).collect(Collectors.toList());
        
        Stream.iterate(1, f -> f + 1).parallel().limit(10).forEach(System.out::println);
    }

    private static String cut(String x) {
        return null;
    }

    private static boolean isPrime(Integer e) {
        Pattern p = Pattern.compile("^1?$|^(11+)\\1+$");
        return !p.matcher(Stream.iterate("1", f -> f).limit(e).collect(Collectors.joining()))
                .matches();
    }
}
