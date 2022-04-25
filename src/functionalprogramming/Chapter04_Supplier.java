package functionalprogramming;

import java.util.function.Supplier;

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
