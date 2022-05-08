package functionalprogramming;

import functionalprogramming.model.Member;
import functionalprogramming.model.Price;
import functionalprogramming.service.*;

import java.util.Arrays;
import java.util.List;

public class Chapter34_StrategyPattern {
    public static void main(String[] args) {
        Member member1 = Member.builder()
                .id(1)
                .name("Alice")
                .isVerified(false)
                .emailAddress("alice@naver.com")
                .friendMemberIds(Arrays.asList(201, 202, 203, 204, 211, 212, 213, 214))
                .build();
        Member member2 = Member.builder()
                .id(2)
                .name("Bob")
                .isVerified(true)
                .emailAddress("bob@naver.com")
                .friendMemberIds(Arrays.asList(212, 213, 214))
                .build();
        Member member3 = Member.builder()
                .id(3)
                .name("Charlie")
                .isVerified(true)
                .emailAddress("charlie@naver.com")
                .friendMemberIds(Arrays.asList(201, 202, 203, 204, 211, 212))
                .build();
        List<Member> members = Arrays.asList(member1, member2, member3);

        EmailSender emailSender = new EmailSender();
        EmailProvider verifyYourEmailProvider = new VerifyYourEmailProvider();
        EmailProvider makeMoreFriendsEmailProvider = new MakeMoreFriendsEmailProvider();

        emailSender.setEmailProvider(verifyYourEmailProvider);
        members.stream()
                .filter(member -> !member.isVerified())
                .forEach(emailSender::sendEmail);

        emailSender.setEmailProvider(makeMoreFriendsEmailProvider);
        members.stream()
                .filter(Member::isVerified)
                .filter(member -> member.getFriendMemberIds().size() <= 5)
                .forEach(emailSender::sendEmail);

        emailSender.setEmailProvider(member -> "'Play With Friends' email for'" + member.getName());
        members.stream()
                .filter(Member::isVerified)
                .filter(member -> member.getFriendMemberIds().size() > 5)
                .forEach(emailSender::sendEmail);
    }
}
