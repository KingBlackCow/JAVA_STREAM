package functionalprogramming;

import functionalprogramming.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 *
 */

public class Chapter10_MethodReference2 {
    public static void main(String[] args) {
        Function<String, Integer> strLength = String::length;
        int length = strLength.apply("hello world");
        System.out.println(length);

        BiPredicate<String, String> strEquals = String::equals;
        boolean test = strEquals.test("hello", "world");
        System.out.println(test);

        List<User> users = new ArrayList<>();
        users.add(new User(3,"Alice"));
        users.add(new User(1,"Charlie"));
        users.add(new User(5,"Bob"));

        //printUserField(users, (User user)-> user.getId());
        printUserField(users, User::getId);
    }

    public static void printUserField(List<User> users, Function<User, Object> getter){
        for(User user: users){
            System.out.println(getter.apply(user));
        }
    }
}
