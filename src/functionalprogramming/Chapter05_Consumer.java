package functionalprogramming;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Consumer: input은 있지만 아무것도 반환하지 않는 Functional interface
 */

public class Chapter05_Consumer {
    public static void main(String[] args) {
        Consumer<String> consumer = str -> System.out.println(str);
        consumer.accept("hello js");

        List<Integer> list1 = Arrays.asList(1, 2, 3);
        Consumer<Integer> consumer1 = x ->
                System.out.println("컨슈머1: " + x);
        process(list1, consumer1);

        Consumer<Integer> consumer2 = x ->
                System.out.println("컨슈머2: " + x);
        process(list1, consumer2);

        Consumer<Double> consumer3 = x ->
                System.out.println("컨슈머3: " + x);
        List<Double> doubles = Arrays.asList(1.1, 2.2, 3.3);
        process(doubles, consumer3);
    }

    private static <T> void process(List<T> inputs, Consumer<T> processor) {
        for (T input: inputs){
            processor.accept(input);
        }
    }
}
