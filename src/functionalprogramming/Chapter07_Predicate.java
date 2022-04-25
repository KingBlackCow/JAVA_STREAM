package functionalprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

/**
 * @FunctionalInterface public interface Predicate<T>{
 * boolean test(T t)
 * }
 * 인자받아서 boolean반환
 */

public class Chapter07_Predicate {
    public static void main(String[] args) {
        Predicate<Integer> isPositive = x -> x > 0;
        //System.out.println(isPositive.test(-10));

        List<Integer> inputs = Arrays.asList(10, -5, 4, -2, 0, 3);
        System.out.println("Positive number: " + filter(inputs, isPositive));
        System.out.println("Non-Positive number: " + filter(inputs, isPositive.negate()));
        System.out.println("Non-Negaitive number: " + filter(inputs, isPositive.or(x -> x == 0)));
        System.out.println("Positive even number: " + filter(inputs, isPositive.and(x -> x % 2 == 0)));
    }

    private static <T> List<T> filter(List<T> inputs, Predicate<T> condition) {
        List<T> outputs = new ArrayList<>();
        for (T input : inputs) {
            if (condition.test(input)) {
                outputs.add(input);
            }
        }
        return outputs;
    }
}
