package functionalprogramming.service;

import functionalprogramming.model.Member;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractMemberService {
    protected abstract boolean validateMember(Member member);

    protected abstract void writeToDB(Member member);

    public void createMember(Member member) {
        if (validateMember(member)) {
            writeToDB(member);
        } else {
            System.out.println("Cannot create member");
        }
    }
}
