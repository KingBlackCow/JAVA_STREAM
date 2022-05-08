package functionalprogramming.service;

import functionalprogramming.model.Member;

public class EmailSender {
    private EmailProvider emailProvider;

    public EmailSender setEmailProvider(EmailProvider emailProvider) {
        this.emailProvider = emailProvider;
        return this;
    }

    public void sendEmail(Member member) {
        String email = emailProvider.getEmail(member);
        System.out.println("Sending " + email);
    }
}
