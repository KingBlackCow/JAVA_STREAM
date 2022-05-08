package functionalprogramming;

import functionalprogramming.model.Member;
import functionalprogramming.service.*;

import java.util.Arrays;
import java.util.List;

public class Chapter35_TemplateMethodPattern {
    public static void main(String[] args) {
        Member member1 = Member.builder()
                .id(1)
                .name("Alice")
                .isVerified(false)
                .emailAddress("alice@naver.com")
                .friendMemberIds(Arrays.asList(201, 202, 203, 204, 211, 212, 213, 214))
                .build();

        MemberService memberService = new MemberService();
        InternalMemberService internalMemberService = new InternalMemberService();

        memberService.createMember(member1);
        internalMemberService.createMember(member1);

        MemberServiceInFunctionalWay memberServiceInFunctionalWay = new MemberServiceInFunctionalWay(
                member -> {
                    System.out.println("Validating member " + member.getName());
                    return member.getName() != null && member.getEmailAddressOptional().isPresent();
                },
                member -> {
                    System.out.println("Writing member " + member.getName() + " to DB");
                });
        memberServiceInFunctionalWay.createMember(member1);
    }
}
