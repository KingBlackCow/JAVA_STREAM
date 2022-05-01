package functionalprogramming;

import functionalprogramming.model.Member;
import functionalprogramming.model.Order;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Chapter20_MaxMinCount {
    public static void main(String[] args) {
        Optional<Integer> max = Stream.of(5, 3, 6, 2, 1)
                //.max((x,y)-> x-y);
                .max(Integer::compareTo);
        System.out.println(max.get());

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

        Member member4 = Member.builder()
                .id(104)
                .name("David")
                .isVerified(true)
                .emailAddress("charlie@naver.com")
                .build();


        long positiveIntegerCount = Stream.of(1, -4, 5, -3, 6)
                .filter(x -> x > 0)
                .count();
        System.out.println(positiveIntegerCount);

        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        member1.setCreatedAt(now.minusHours(2));
        member2.setCreatedAt(now.minusHours(10));
        member3.setCreatedAt(now.minusHours(1));
        member4.setCreatedAt(now.minusHours(27));
        List<Member> members = Arrays.asList(member1, member2, member3, member4);
        Member firstMember = members.stream()
                .min((m1, m2) -> m1.getName().compareTo(m2.getName()))
                .get();
        System.out.println(firstMember.getId());

        long count = members.stream()
                .filter(member -> member.getCreatedAt().isAfter(now.minusDays(1)))
                .filter(member -> !member.isVerified())
                .count();
        System.out.println(count);

        Order order1 = Order.builder()
                .id(1001)
                .orderStatus(Order.OrderStatus.CREATED)
                .createdByUserId(101)
                .amount(BigDecimal.valueOf(2000))
                .createdAt(now.minusHours(1))
                .build();

        Order order2 = Order.builder()
                .id(1002)
                .orderStatus(Order.OrderStatus.ERROR)
                .createdByUserId(103)
                .amount(BigDecimal.valueOf(4000))
                .createdAt(now.minusHours(4))
                .build();
        Order order3 = Order.builder()
                .id(1003)
                .orderStatus(Order.OrderStatus.ERROR)
                .createdByUserId(102)
                .amount(BigDecimal.valueOf(3000))

                .createdAt(now.minusHours(36))
                .build();
        Order order4 = Order.builder()
                .id(1004)
                .orderStatus(Order.OrderStatus.PROCESSED)
                .createdByUserId(104)
                .amount(BigDecimal.valueOf(7000))
                .createdAt(now.minusHours(15))
                .build();

        List<Order> orders = Arrays.asList(order1, order2, order3, order4);
        Optional<Order> errorStatusMaxAmount = orders.stream()
                .filter(order -> order.getStatus().equals(Order.OrderStatus.ERROR))
                .max((o1, o2) -> o1.getAmount().compareTo(o2.getAmount()));
        System.out.println(errorStatusMaxAmount.get().getAmount());


    }


}
