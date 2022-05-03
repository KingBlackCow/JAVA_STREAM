package functionalprogramming.service;

import functionalprogramming.model.Member;

public class EmailService {
    public void sendPlayWithFriends(Member member){
        member.getEmailAddressOptional().ifPresent(email -> System.out.println("Sending Play with Friend email to " + email));
    }

    public void sendMakeMoreFriendsEmail(Member member){
        member.getEmailAddressOptional().ifPresent(email -> System.out.println("Sending Make More Friend email to " + email));
    }

    public void sendVerifyYourEmail(Member member){
        member.getEmailAddressOptional().ifPresent(email -> System.out.println("Sending Verify your email to " + email));
    }
}
