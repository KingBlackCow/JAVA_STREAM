package functionalprogramming;

import functionalprogramming.model.Member;
import functionalprogramming.model.Order;
import functionalprogramming.model.OrderLine;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chapter27_GroupingBy {
    public static void main(String[] args) {
        List<Integer> nums = Stream.of(13, 2, 101, 203, 304, 402, 305, 349, 2312, 203)
                .collect(Collectors.toList());

        Map<Integer, List<Integer>> unitDigitMap = nums.stream()
                .collect(Collectors.groupingBy(num -> num % 10));
        System.out.println(unitDigitMap);

        Map<Integer, Set<Integer>> unitDigitSet = nums.stream()
                .collect(Collectors.groupingBy(num -> num % 10, Collectors.toSet()));
        System.out.println(unitDigitSet);

        Map<Integer, List<String>> unitDigitStrMap = nums.stream()
                .collect(Collectors.groupingBy(num -> num % 10, Collectors.mapping(number -> "unit number is "+ number,Collectors.toList())));
        System.out.println(unitDigitStrMap);
        Order order1 = Order.builder()
                .id(1001)
                .orderStatus(Order.OrderStatus.CREATED)
                .createdByUserId(101)
                .amount(BigDecimal.valueOf(2000))
                .build();

        Order order2 = Order.builder()
                .id(1002)
                .orderStatus(Order.OrderStatus.ERROR)
                .createdByUserId(103)
                .amount(BigDecimal.valueOf(4000))
                .build();
        Order order3 = Order.builder()
                .id(1003)
                .orderStatus(Order.OrderStatus.ERROR)
                .createdByUserId(102)
                .amount(BigDecimal.valueOf(3000))
                .build();
        Order order4 = Order.builder()
                .id(1004)
                .orderStatus(Order.OrderStatus.PROCESSED)
                .createdByUserId(104)
                .amount(BigDecimal.valueOf(7000))
                .build();
        List<Order> orders = Arrays.asList(order1, order2, order3, order4);

        Map<Order.OrderStatus, List<Order>> orderStatusListMap = orders.stream()
                .collect(Collectors.groupingBy(Order::getStatus));
        System.out.println(orderStatusListMap);

        Map<Order.OrderStatus, BigDecimal> orderStatusBigDecimalMap = orders.stream().collect(Collectors.groupingBy(Order::getStatus,
                Collectors.mapping(Order::getAmount,
                        Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))));
        System.out.println(orderStatusBigDecimalMap);
    }
}
