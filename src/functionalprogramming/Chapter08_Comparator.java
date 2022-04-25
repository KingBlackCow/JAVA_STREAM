package functionalprogramming;

import functionalprogramming.model.User;

import java.util.*;
import java.util.function.Predicate;

/**
 * @FunctionalInterface public interface Comparator<T>{
 * int compare(T o1, T o2);
 * }
 * 음수면 o1 < o2
 * 0이면 o1 = o2
 * 양수면 o1 > o2
 */

public class Chapter08_Comparator {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User(3, "Alice"));
        users.add(new User(1, "Charlie"));
        users.add(new User(5, "Bob"));
        //System.out.println(users);

        //아이디순
        Comparator<User> idComparator = (u1,u2) ->  u1.getId() - u2.getId();
        Collections.sort(users, idComparator);
        System.out.println(users);

        //이름순
        Collections.sort(users, (u1, u2) -> u1.getName().compareTo(u2.getName()));
        System.out.println(users);
    }
}
