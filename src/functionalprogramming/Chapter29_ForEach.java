package functionalprogramming;

import functionalprogramming.model.Member;
import functionalprogramming.service.EmailService;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chapter29_ForEach {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(3,5,2,1);
        //nums.stream().forEach(num->System.out.println("The Number is "+ num));
        nums.forEach(num->System.out.println("The Number is "+ num));

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


        List<Member> members = Arrays.asList(member1, member2, member3);

        EmailService emailService = new EmailService();
        members.stream()
                .filter(member -> !member.isVerified())
                .forEach(emailService::sendVerifyYourEmail);

    }
}
