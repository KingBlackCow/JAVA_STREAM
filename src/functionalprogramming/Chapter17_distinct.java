package functionalprogramming;

import functionalprogramming.model.Member;
import functionalprogramming.model.Order;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 */

public class Chapter17_distinct {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(3, -5, 4, -5, 2, 3);
        List<Integer> distinctNums = nums.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(distinctNums);

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
        List<Long> ordersUniqueCreateByUserid = orders.stream()
                .map(Order::getCreatedByUserId)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        for (long o: ordersUniqueCreateByUserid) {
            System.out.println(o);
        }
    }
}
