package functionalprogramming;

import functionalprogramming.model.*;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 */

public class Chapter12_Stream {
    public static void main(String[] args) {
        Stream<String> nameStream = Stream.of("Alice", "Bob", "Charlie");
        List<String> names = nameStream.collect(Collectors.toList());
        System.out.println(names);

        String[] cityArray = new String[]{"San Jose", "Seoul", "Tokyo"};
        Stream<String> cityStream = Arrays.stream(cityArray);
        List<String> cityLists = cityStream.collect(Collectors.toList());
        System.out.println(cityLists);

        Set<Integer> numSet = new HashSet<>(Arrays.asList(3,5,7));
        Stream<Integer> numStream = numSet.stream();
        List<Integer> numList = numStream.collect(Collectors.toList());
        System.out.println(numList);
    }
}
