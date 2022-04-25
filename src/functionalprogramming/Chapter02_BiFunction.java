package functionalprogramming;

import java.util.function.BiFunction;

  public class Chapter02_BiFunction {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Integer> add = (x,y) -> x+y;

        int res = add.apply(5,3);
        System.out.println(res);
    }
}