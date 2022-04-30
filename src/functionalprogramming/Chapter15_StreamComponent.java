package functionalprogramming;

import functionalprogramming.model.Member;
import functionalprogramming.model.Order;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 */

public class Chapter15_StreamComponent {
    public static void main(String[] args) {
        Member member1 = Member.builder()
                .id(101)
                .name("Alice")
                .isVerified(true)
                .emailAddress("alice@naver.com")
                .build();

        Member member2 = Member.builder()
                .id(102)
                .name("Bob")
                .isVerified(false)
                .emailAddress("bob@naver.com")
                .build();

        Member member3 = Member.builder()
                .id(103)
                .name("Charlie")
                .isVerified(true)
                .emailAddress("charlie@naver.com")
                .build();

        List<Member> members = Arrays.asList(member1, member2, member3);

        List<String> emails = new ArrayList<>();
        for (Member member : members) {
            if (!member.isVerified()) {
                String email = member.getEmailAddress();
                emails.add(email);
            }
        }
        System.out.println(emails);

        List<String> emails2 = members.stream()
                .filter(member -> !member.isVerified())
                .map(Member::getEmailAddress).collect(Collectors.toList());
        System.out.println(emails2);


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
        List<Long> collect = orders
                .stream()
                .filter(order -> order.getStatus().equals(Order.OrderStatus.ERROR))
                .map(Order::getCreatedByUserId)
                .collect(Collectors.toList());
        System.out.println(collect);

        List<Order> orders24 = orders.stream()
                .filter(order -> order.getStatus().equals(Order.OrderStatus.ERROR))
                .filter(order -> order.getCreatedAt().isAfter(now.minusHours(24)))
                .collect(Collectors.toList());
        System.out.println(orders24);
    }
}
