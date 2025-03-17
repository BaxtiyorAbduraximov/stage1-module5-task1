package com.epam.mjc;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x -> x.stream()
                .allMatch(s -> !s.isEmpty() && Character.isUpperCase(s.charAt(0)));
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return list -> {
            List<Integer> evens = new ArrayList<>();

            for (int num : list) {
                if (num % 2 == 0) {
                    evens.add(num);
                }
            }

            list.addAll(evens);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () ->
            values.stream().filter(s -> !s.isEmpty() && Character.isUpperCase(s.charAt(0))
                    && s.endsWith(".")
                    && Arrays.stream(s.split("\\s+")).count() > 3)
                    .collect(Collectors.toList());
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> map = new HashMap<>();
            for(String list : x){
                map.put(list, list.length());
            }

            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }
}
