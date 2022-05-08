package functionalprogramming.service;

import functionalprogramming.model.Member;
import lombok.RequiredArgsConstructor;

import java.util.function.Consumer;
import java.util.function.Predicate;

@RequiredArgsConstructor
public class MemberServiceInFunctionalWay {
    private final Predicate<Member> validateMember;
    private final Consumer<Member> writeTODB;

    public void createMember(Member member) {
        if (validateMember.test(member)) {
            writeTODB.accept(member);
        } else {
            System.out.println("Cannot create member");
        }
    }
}
