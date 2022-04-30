package functionalprogramming;

import functionalprogramming.model.Member;
import functionalprogramming.model.Order;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * map: 데이터를 변형하는데 사용
 * 데이터에 함수가 적용된 결과물을 제공하는 stream을 리턴
 */

public class Chapter14_map {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(3, 6, -4);
        List<Integer> numsX2 = nums.stream()
                .map(x -> x * 2)
                .collect(Collectors.toList());
       // System.out.println(numsX2);

        List<String> stringList = nums.stream().map(x -> "Number is " + x).collect(Collectors.toList());
        //System.out.println(stringList);

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
        //Stream<String> memberStream = members.stream().map(m -> m.getEmailAddress());
        List<String> emails = members.stream()
                .map(Member::getEmailAddress)
                .collect(Collectors.toList());
        //System.out.println(emails);

        Order order1 = Order.builder()
                .id(1001)
                .orderStatus(Order.OrderStatus.CREATED)
                .createdByUserId(101)
                .build();

        Order order2 = Order.builder()
                .id(1002)
                .orderStatus(Order.OrderStatus.ERROR)
                .createdByUserId(103)
                .build();
        Order order3 = Order.builder()
                .id(1003)
                .orderStatus(Order.OrderStatus.PROCESSED)
                .createdByUserId(102)
                .build();
        Order order4 = Order.builder()
                .id(1004)
                .orderStatus(Order.OrderStatus.ERROR)
                .createdByUserId(104)
                .build();
        Order order5 = Order.builder()
                .id(1005)
                .orderStatus(Order.OrderStatus.IN_PROGRESS)
                .createdByUserId(101)
                .build();

        List<Order> orders = Arrays.asList(order1,order2,order3,order4,order5);
        List<Long> collect = orders
                .stream()
                .map(Order::getCreatedByUserId)
                .collect(Collectors.toList());
        System.out.println(collect);

    }
}
