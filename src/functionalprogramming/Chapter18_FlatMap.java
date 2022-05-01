package functionalprogramming;

import functionalprogramming.model.Order;
import functionalprogramming.model.OrderLine;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 */

public class Chapter18_FlatMap {
    public static void main(String[] args) {
        String[][] cities = new String[][]{
                {"Seoul", "Busan"},
                {"San Fracisco", "New York"},
                {"Madrid", "Barcelona"}
        };
        Stream<String[]> cityStream = Arrays.stream(cities);
        Stream<Stream<String>> cityStreamStream = cityStream.map(x -> Arrays.stream(x));
        List<Stream<String>> cityStreamList = cityStreamStream.collect(Collectors.toList());

        Stream<String[]> cityStream2 = Arrays.stream(cities);
        Stream<String> flattenCityStream = cityStream2.flatMap(x -> Arrays.stream(x));
        List<String> flattenCityList = flattenCityStream.collect(Collectors.toList());
        System.out.println(flattenCityList);

        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        Order order1 = Order.builder()
                .id(1001)
                .orderStatus(Order.OrderStatus.CREATED)
                .createdByUserId(101)
                .createdAt(now.minusHours(1))
                .orderLines(Arrays.asList(
                        new OrderLine(10001, OrderLine.OrderLineType.PURCHASE, BigDecimal.valueOf(5000)),
                        new OrderLine(10002, OrderLine.OrderLineType.PURCHASE, BigDecimal.valueOf(4000))
                ))
                .build();

        Order order2 = Order.builder()
                .id(1002)
                .orderStatus(Order.OrderStatus.ERROR)
                .createdByUserId(103)
                .createdAt(now.minusHours(4))
                .orderLines(Arrays.asList(
                        new OrderLine(10003, OrderLine.OrderLineType.PURCHASE, BigDecimal.valueOf(2000)),
                        new OrderLine(10004, OrderLine.OrderLineType.DISCOUNT, BigDecimal.valueOf(-1000))
                ))
                .build();
        Order order3 = Order.builder()
                .id(1003)
                .orderStatus(Order.OrderStatus.PROCESSED)
                .createdByUserId(102)
                .createdAt(now.minusHours(36))
                .orderLines(Arrays.asList(
                        new OrderLine(10005, OrderLine.OrderLineType.PURCHASE, BigDecimal.valueOf(2000))
                ))
                .build();
        List<Order> orders = Arrays.asList(order1,order2,order3);
        List<OrderLine> mergeOrderLines = orders.stream()
                .map(Order::getOrderLines)
                .flatMap(List::stream)
                .collect(Collectors.toList());
        System.out.println(mergeOrderLines);
    }
}
