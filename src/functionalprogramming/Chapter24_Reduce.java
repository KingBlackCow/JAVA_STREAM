package functionalprogramming;

import functionalprogramming.model.Member;
import functionalprogramming.model.Order;
import functionalprogramming.model.OrderLine;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Chapter24_Reduce {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 4, -2, -5, 3);
        int sum = nums.stream()
                .reduce((x, y) -> x + y)
                .get();
        System.out.println(sum);

        int min = nums.stream()
                .reduce((x, y) ->
//                    if (x < y) {
//                        return x;
//                    }
//                    return y;
                    x > y ? y : x
                ).get();
        System.out.println(min);

        int product = nums.stream()
                .reduce(1, (x,y)-> x*y);
        System.out.println(product);

        List<String> numsStrList = Arrays.asList("3","2","5","-4");
        int sumOfNums = numsStrList.stream()
                .map(Integer::parseInt)
                .reduce(0, (x, y) -> x + y);
        System.out.println(sumOfNums);

        List<String> numsStrList2 = Arrays.asList("3","2","5","-4");
        int sumOfNums2 = numsStrList.stream()
                .reduce(0, (num, str) -> num + Integer.parseInt(str), (num1, num2)-> num1+ num2);
        System.out.println(sumOfNums2);

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


        member1.setFriendMemberIds(Arrays.asList(201,202,203,204));
        member2.setFriendMemberIds(Arrays.asList(204,205, 206));
        member3.setFriendMemberIds(Arrays.asList(204,205,207));
        List<Member> members = Arrays.asList(member1, member2, member3);
        Integer friendsSum = members.stream()
                .map(Member::getFriendMemberIds)
                .map(List::size)
                .reduce(0, (x, y) -> x + y);
        System.out.println(friendsSum);

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
        BigDecimal sumOfAmount = orders.stream()
                .map(Order::getOrderLines)
                .flatMap(List::stream)
                .map(OrderLine::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(sumOfAmount);
    }
}
