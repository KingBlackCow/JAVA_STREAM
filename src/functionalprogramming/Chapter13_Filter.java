package functionalprogramming;

import functionalprogramming.model.Member;
import functionalprogramming.model.Order;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 */

public class Chapter13_Filter {
    public static void main(String[] args) {
//        Stream<Integer> numberStream = Stream.of(3, -5, 7, 10, -3);
//        Stream<Integer> filteredNumberStream = numberStream.filter(x -> x > 0);
//        Stream<Integer> filteredNumberStream = Stream.of(3, -5, 7, 10, -3).filter(x -> x > 0);
        List<Integer> filterNumList = Stream.of(3, -5, 7, 10, -3)
                .filter(x -> x > 0)
                .collect(Collectors.toList());
        //System.out.println(filterNumList);

        Member member1 =  Member.builder()
                .id(101)
                .name("Alice")
                .isVerified(true)
                .emailAddress("alice@naver.com")
                .build();

        Member member2 =  Member.builder()
                .id(102)
                .name("Bob")
                .isVerified(false)
                .emailAddress("bob@naver.com")
                .build();

        Member member3 =  Member.builder()
                .id(103)
                .name("Charlie")
                .isVerified(true)
                .emailAddress("charlie@naver.com")
                .build();

        List<Member> members = Arrays.asList(member1,member2,member3);

        //검증된 유저
        List<Member> verifiedMembers = members.stream()
                //.filter(member -> member.isVerified())
                .filter(Member::isVerified)
                .collect(Collectors.toList());
        //System.out.println(verifiedMembers);

        //검증되지 않은 유저
        List<Member> unVerifiedMembers = members.stream()
                .filter(member -> !member.isVerified())
                .collect(Collectors.toList());
        //System.out.println(unVerifiedMembers);

        Order order1 = Order.builder()
                .id(1001)
                .orderStatus(Order.OrderStatus.CREATED)
                .build();

        Order order2 = Order.builder()
                .id(1002)
                .orderStatus(Order.OrderStatus.ERROR)
                .build();
        Order order3 = Order.builder()
                .id(1003)
                .orderStatus(Order.OrderStatus.PROCESSED)
                .build();
        Order order4 = Order.builder()
                .id(1004)
                .orderStatus(Order.OrderStatus.ERROR)
                .build();
        Order order5 = Order.builder()
                .id(1005)
                .orderStatus(Order.OrderStatus.IN_PROGRESS)
                .build();

        List<Order> orders = Arrays.asList(order1,order2,order3,order4,order5);
        List<Order> errorOrders = orders.stream()
                .filter(order -> order.getStatus().equals(Order.OrderStatus.ERROR))
                .collect(Collectors.toList());
        System.out.println(errorOrders);

    }
}
