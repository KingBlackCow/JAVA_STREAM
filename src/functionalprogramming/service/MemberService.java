package functionalprogramming.service;

import functionalprogramming.model.Member;

public class MemberService extends AbstractMemberService {

    @Override
    protected boolean validateMember(Member member) {
        System.out.println("Validating member " + member.getName());
        return member.getName() != null && member.getEmailAddressOptional().isPresent();
    }

    @Override
    protected void writeToDB(Member member) {
        System.out.println("Writing member " + member.getName() + " to DB");
    }
}
