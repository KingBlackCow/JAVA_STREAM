package functionalprogramming;

import java.util.function.Function;

/*
 * 매개변수의 타입이 유추 가능할 경우 타입 생략 가능
 * 매개변수가 하나일 경우 괄호 생략 가능
 * 바로 리턴하는 경우 중괄호 생략 가능
 */

public class Chapter01_Function {
    public static void main(String[] args) {
        //1.
//        Function<Integer, Integer> adder = new Adder();

        //2.
//        Function<Integer, Integer> adder = (Integer x) -> {
//          return x+10;
//        };

        //3.
        Function<Integer, Integer> adder = x -> x+10;

        int res = adder.apply(5);
        System.out.println(res);
    }
}