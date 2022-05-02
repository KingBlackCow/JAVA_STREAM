package functionalprogramming;

import functionalprogramming.model.Member;
import functionalprogramming.model.Order;
import functionalprogramming.model.OrderLine;
import functionalprogramming.model.User;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chapter26_toMap {
    public static void main(String[] args) {
        Map<Integer, String> maps = Stream.of(3, 5, -4, 2, 6)
                .collect(Collectors.toMap(x -> x, x -> "Number is "+ x));

        System.out.println(maps);

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
        Map<Integer, Member> memberIdToMemberMap = members.stream()
                .collect(Collectors.toMap(Member::getId, Function.identity()));
        System.out.println(memberIdToMemberMap);

        Order order1 = Order.builder()
                .id(1001)
                .orderStatus(Order.OrderStatus.CREATED)
                .createdByUserId(101)
                .orderLines(Arrays.asList(
                        new OrderLine(10001, OrderLine.OrderLineType.PURCHASE, BigDecimal.valueOf(1000)),
                        new OrderLine(10002, OrderLine.OrderLineType.PURCHASE, BigDecimal.valueOf(2000))
                ))
                .build();

        Order order2 = Order.builder()
                .id(1002)
                .orderStatus(Order.OrderStatus.ERROR)
                .createdByUserId(103)
                .orderLines(Arrays.asList(
                        new OrderLine(10003, OrderLine.OrderLineType.PURCHASE, BigDecimal.valueOf(2000)),
                        new OrderLine(10004, OrderLine.OrderLineType.DISCOUNT, BigDecimal.valueOf(3000))
                ))
                .build();
        Order order3 = Order.builder()
                .id(1003)
                .orderStatus(Order.OrderStatus.PROCESSED)
                .createdByUserId(102)
                .orderLines(Arrays.asList(
                        new OrderLine(10005, OrderLine.OrderLineType.PURCHASE, BigDecimal.valueOf(1000)),
                        new OrderLine(10005, OrderLine.OrderLineType.PURCHASE, BigDecimal.valueOf(2000))
                ))
                .build();
        List<Order> orders = Arrays.asList(order1, order2, order3);

        Map<Long, Order.OrderStatus> orderIdToOrderStatusMap = orders.stream()
                .collect(Collectors.toMap(Order::getId, Order::getStatus));
        System.out.println(orderIdToOrderStatusMap);

    }
}
