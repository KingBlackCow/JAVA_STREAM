package functionalprogramming;

import functionalprogramming.model.Member;
import functionalprogramming.model.Order;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */

public class Chapter16_Sorted {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(3, -5, 7, 4);
        List<Integer> sortedNums = nums.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedNums);

        Member member1 = Member.builder()
                .id(101)
                .name("Paul")
                .isVerified(true)
                .emailAddress("alice@naver.com")
                .build();

        Member member2 = Member.builder()
                .id(102)
                .name("David")
                .isVerified(false)
                .emailAddress("bob@naver.com")
                .build();

        Member member3 = Member.builder()
                .id(103)
                .name("John")
                .isVerified(true)
                .emailAddress("charlie@naver.com")
                .build();

        List<Member> members = Arrays.asList(member1, member2, member3);
        List<Member> sortedMembers = members.stream()
                .sorted((u1, u2) -> u1.getName().compareTo(u2.getName()))
                .collect(Collectors.toList());
        System.out.println(sortedMembers);

        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        Order order1 = Order.builder()
                .id(1001)
                .orderStatus(Order.OrderStatus.CREATED)
                .createdByUserId(101)
                .createdAt(now.minusHours(1))
                .build();

        Order order2 = Order.builder()
                .id(1002)
                .orderStatus(Order.OrderStatus.ERROR)
                .createdByUserId(103)
                .createdAt(now.minusHours(4))
                .build();
        Order order3 = Order.builder()
                .id(1003)
                .orderStatus(Order.OrderStatus.PROCESSED)
                .createdByUserId(102)
                .createdAt(now.minusHours(36))
                .build();
        Order order4 = Order.builder()
                .id(1004)
                .orderStatus(Order.OrderStatus.ERROR)
                .createdByUserId(104)
                .createdAt(now.minusHours(15))
                .build();
        Order order5 = Order.builder()
                .id(1005)
                .orderStatus(Order.OrderStatus.IN_PROGRESS)
                .createdByUserId(101)
                .createdAt(now.minusHours(10))
                .build();

        List<Order> orders = Arrays.asList(order1, order2, order3, order4, order5);
        List<Order> ordersByCreatedAt = orders.stream()
                .sorted((c1, c2) -> c1.getCreatedAt().compareTo(c2.getCreatedAt()))
                .collect(Collectors.toList());
        for (Order o: ordersByCreatedAt) {
            System.out.println(o.getCreatedAt());
        }
        //System.out.println(ordersByCreatedAt);
    }
}
