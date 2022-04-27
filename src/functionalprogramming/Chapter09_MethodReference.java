package functionalprogramming;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 */

public class Chapter09_MethodReference {

    public static int calculate(int x, int y, BiFunction<Integer, Integer, Integer> operator) {
        return operator.apply(x, y);
    }

    public static int multiply(int x, int y) {
        return x * y;
    }

    public int subtract(int x, int y) {
        return x - y;
    }

    public void myMethod(){
        System.out.println(calculate(10,3, this::subtract));
    }

    public static void main(String[] args) {
        Function<String, Integer> str2int = Integer::parseInt;
        System.out.println(str2int.apply("20"));

        String str = "hello";
        Predicate<String> equalsToString = str::equals;
        System.out.println(equalsToString.test("hello"));

        System.out.println(calculate(8, 2, (x, y) -> x + y));
        System.out.println(calculate(8, 2, Chapter09_MethodReference::multiply));

        Chapter09_MethodReference instance = new Chapter09_MethodReference();
        System.out.println(calculate(8,2, instance::subtract));
        instance.myMethod();
    }
}
