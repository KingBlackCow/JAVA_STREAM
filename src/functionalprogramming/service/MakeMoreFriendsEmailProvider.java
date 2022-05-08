package functionalprogramming.service;

import functionalprogramming.model.Member;

public class MakeMoreFriendsEmailProvider implements EmailProvider {
    @Override
    public String getEmail(Member member) {
        return "'Make More Friends' email for " + member.getEmailAddress();
    }
}
