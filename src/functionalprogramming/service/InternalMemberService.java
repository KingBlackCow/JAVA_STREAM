package functionalprogramming.service;

import functionalprogramming.model.Member;

public class InternalMemberService extends AbstractMemberService {

    @Override
    protected boolean validateMember(Member member) {
        System.out.println("Validating internal member " + member.getName());
        return true;
    }

    @Override
    protected void writeToDB(Member member) {
        System.out.println("Writing member " + member.getName() + " to internal DB");
    } 
}
