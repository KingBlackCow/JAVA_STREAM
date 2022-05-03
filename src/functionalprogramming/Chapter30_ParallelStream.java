package functionalprogramming;

import functionalprogramming.model.Member;
import functionalprogramming.service.EmailService;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Chapter30_ParallelStream {
    public static void main(String[] args) {
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

        Member member4 = Member.builder()
                .id(104)
                .name("David")
                .isVerified(true)
                .emailAddress("david@naver.com")
                .build();

        Member member5 = Member.builder()
                .id(105)
                .name("Eve")
                .isVerified(false)
                .emailAddress("eve@naver.com")
                .build();

        Member member6 = Member.builder()
                .id(106)
                .name("Frank")
                .isVerified(true)
                .emailAddress("frank@naver.com")
                .build();

        List<Member> members = Arrays.asList(member1, member2, member3, member4, member5, member6);

        //순차처리 13ms
        long startTime = System.currentTimeMillis();
        EmailService emailService = new EmailService();
        members.stream()
                .filter(member -> !member.isVerified())
                .forEach(emailService::sendVerifyYourEmail);
        long endTime = System.currentTimeMillis();
        System.out.println("Sequential: "+ (endTime-startTime) + "ms");

        //병렬처리 6ms
        startTime = System.currentTimeMillis();
        members.stream().parallel()
                .filter(member -> !member.isVerified())
                .forEach(emailService::sendVerifyYourEmail);
        endTime = System.currentTimeMillis();
        System.out.println("Parallel: "+ (endTime-startTime) + "ms");

        List<Member> processedMember = members.parallelStream()
                .map(member -> {
                    System.out.println("Capitalize user name for user " + member.getId());
                    member.setName(member.getName().toUpperCase());
                    return member;
                })
                .map(member -> {
                    System.out.println("set is verified to true for user " + member.getId());
                    member.setVerified(true);
                    return member;
                })
                .collect(Collectors.toList());
        System.out.println(processedMember);
    }
}
