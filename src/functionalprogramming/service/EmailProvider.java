package functionalprogramming.service;

import functionalprogramming.model.Member;

public interface EmailProvider {
    String getEmail(Member member);
}
