package functionalprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

/**
 * BiConsumer: input은 2개 있지만 아무것도 반환하지 않는 Functional interface
 */

public class Chapter06_BiConsumer {
    public static void main(String[] args) {
        BiConsumer<Integer, Double> consumer =
                (index, inputs) -> System.out.println("인덱스: " + index + "값: " + inputs);

        List<Double> list = Arrays.asList(1.1, 2.2, 3.3);
        process(list, consumer);

    }

    private static <T> void process(List<T> inputs, BiConsumer<Integer, T> processor) {
        for (int i = 0; i < inputs.size(); i++) {
            processor.accept(i, inputs.get(i));
        }
    }
}
