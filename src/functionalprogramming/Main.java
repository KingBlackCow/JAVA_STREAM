package functionalprogramming;

import functionalprogramming.utils.Adder;

import java.util.function.Function;

public class Main{
    public static void main(String[] args) {
        Function<Integer, Integer> adder = new Adder();
        int res = adder.apply(5);
        System.out.println(res);
    }
}