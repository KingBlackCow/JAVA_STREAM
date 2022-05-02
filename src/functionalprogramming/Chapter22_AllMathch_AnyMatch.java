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

public class Chapter22_AllMathch_AnyMatch {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(3, -4, 2, 7, 9);
        boolean allPositive = nums.stream()
                .allMatch(num -> num > 0);
        System.out.println(allPositive);
        boolean anyNagative = nums.stream()
                .anyMatch(num -> num < 0);
        System.out.println(anyNagative);

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
        List<Member> members = Arrays.asList(member1, member2, member3, member4);
        boolean areAllUserVerified = members.stream()
                .allMatch(Member::isVerified);
        System.out.println(areAllUserVerified);

        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
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
        boolean orderInError = orders.stream()
                .anyMatch(order -> order.getStatus().equals(Order.OrderStatus.ERROR));
        System.out.println(orderInError);

    }
}
