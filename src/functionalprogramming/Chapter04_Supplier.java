package functionalprogramming;

import java.util.function.Supplier;

/**
 * @param supplier: input은 없고 무엇을 반환하는 Functional interface
 */

public class Chapter04_Supplier {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "hello JS";
        System.out.println(supplier.get());

        Supplier<Double> supplier2 = () -> Math.random();
        System.out.println(supplier2.get());
        System.out.println(supplier2.get());
        System.out.println(supplier2.get());
        printRandomDoubles(supplier2, 5);
    }


    public static void printRandomDoubles(Supplier<Double> supplier, int cnt){
        for (int i = 0; i < cnt; i++) {
            System.out.println(supplier.get());
        }
    }
}
