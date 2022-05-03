package functionalprogramming;

import functionalprogramming.model.Member;
import functionalprogramming.model.Order;
import functionalprogramming.service.EmailService;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chapter28_PartitioningBy {
    public static void main(String[] args) {
        List<Integer> nums = Stream.of(13, 2, 101, 203, 304, 402, 305, 349, 2312, 203)
                .collect(Collectors.toList());

        Map<Boolean, List<Integer>> numPartitionMap = nums.stream()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));
        System.out.println(numPartitionMap);
        System.out.println("Even Num " + numPartitionMap.get(true));
        System.out.println("Odd Num " + numPartitionMap.get(false));

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

        member1.setFriendMemberIds(Arrays.asList(201, 202, 203, 204, 211, 212, 213, 214));
        member2.setFriendMemberIds(Arrays.asList(204, 205, 206));
        member3.setFriendMemberIds(Arrays.asList(204, 205, 207, 218));
        List<Member> members = Arrays.asList(member1, member2, member3);
        Map<Boolean, List<Member>> userPartition = members.stream()
                .collect(Collectors.partitioningBy(member -> member.getFriendMemberIds().size() > 5));

        EmailService emailService = new EmailService();
        for (Member member:userPartition.get(true)) {
                emailService.sendPlayWithFriends(member);
        }

        for (Member member:userPartition.get(false)) {
            emailService.sendMakeMoreFriendsEmail(member);
        }
    }
}
