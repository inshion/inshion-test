package me.inshion.test.lang;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

interface DaoByCursor<Id, Model> {

    public List<Model> getByCursor(Id cursor, int limit);

}

class MyIter<Id, Model> implements Iterable<Model> {

    Id cursor;
    int limit;
    Function<Model, Id> convertor;

    MyIter(DaoByCursor<Id, Model> dao, Id cursor, int limit, Function<Model, Id> convertor) {

        this.dao = dao;
        this.cursor = cursor;
        this.limit = limit;
        this.convertor = convertor;
    }

    private DaoByCursor<Id, Model> dao = null;

    class itHolder {

        Iterator<Model> it = null;
    }

    @Override
    public Iterator<Model> iterator() {
        System.out.println("out itering...");
        itHolder ith = new itHolder();
        ith.it = getData();
        return new Iterator<Model>() {

            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Model next() {
                Model ret = null;
                if (ith.it.hasNext()) {
                    ret = ith.it.next();
                } else {
                    ith.it = getData();
                    ret = ith.it.next();
                }
                cursor = convertor.apply(ret);
                return ret;
            }

        };
    }

    private Iterator<Model> getData() {
        return dao.getByCursor(cursor, limit).iterator();
    }

    public Stream<Model> stream() {
        return StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator(),
                (Spliterator.NONNULL | Spliterator.IMMUTABLE)), false);
    }

}

public class TestIterator {

    public static void main(String[] args) {

        int count = 40;

        MyIter<Integer, String> itttt = new MyIter<>((cursor, limit) -> {
            System.out.println("gen from:" + cursor);
            List<String> ssss = Stream
                    .iterate((1 + cursor) + "", e -> String.valueOf(Integer.parseInt(e) + 1))
                    .limit(limit).collect(Collectors.toList());

            return ssss.subList(0, ssss.size());
        } , 0, 2, Integer::parseInt);

        itttt.stream().filter(e -> {
            return Integer.parseInt(e) % 2 == 0;
        }).limit(count).forEach(System.out::println);

    }

}
