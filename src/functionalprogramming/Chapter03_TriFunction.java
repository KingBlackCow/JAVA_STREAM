package functionalprogramming;


import functionalprogramming.utils.TriFunction;

public class Chapter03_TriFunction {
    public static void main(String[] args) {
        TriFunction<Integer, Integer, Integer, Integer> add = (x, y, z) -> x + y + z;

        int res = add.apply(5, 3, 2);
        System.out.println(res);
    }
}