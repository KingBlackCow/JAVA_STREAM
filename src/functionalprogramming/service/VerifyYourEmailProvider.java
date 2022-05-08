package functionalprogramming.service;

import functionalprogramming.model.Member;

public class VerifyYourEmailProvider implements EmailProvider {
    @Override
    public String getEmail(Member member) {
        return "'Verify your' email for " + member.getName();
    }
}
