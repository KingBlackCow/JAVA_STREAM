package functionalprogramming;

import functionalprogramming.model.Member;

import java.util.Optional;

public class Chapter19_Optional {
    public static void main(String[] args) {
        Member m1 = Member.builder()
                .id(1001)
                .name("Alice")
                .isVerified(false)
                .build();

        Member m2 = Member.builder()
                .id(1001)
                .name("Alice")
                .isVerified(false)
                .emailAddress("alice@naver.com")
                .build();
        //버그발생! System.out.println("Same? : " + userEquals(m1, m2));
        String someEmail = "sgs1159@naver.com";
        String nullEmail = null;
        Optional<String> maybeEmail = Optional.of(someEmail);
        Optional<String> maybeEmail2 = Optional.empty();
        Optional<String> maybeEmail3 = Optional.ofNullable(someEmail);
        Optional<String> maybeEmail4 = Optional.ofNullable(nullEmail);

        String email = maybeEmail.get();
        System.out.println(email);

        if (maybeEmail2.isPresent()) {
            System.out.println(maybeEmail2.get());
        }

        String defaultEmail = "default@naver.com";
        String email3 = maybeEmail2.orElse(defaultEmail);
        System.out.println(email3);
        String email4 = maybeEmail2.orElseGet(() -> defaultEmail);
        System.out.println(email4);
        String email5 = maybeEmail2.orElseThrow(() -> new RuntimeException("email not present"));
        System.out.println(email5);
    }

    public static boolean userEquals(Member m1, Member m2) {
        return m1.getId() == m2.getId()
                && m1.getName().equals(m2.getName())
                && m1.getEmailAddress().equals(m2.getEmailAddress())
                && m1.isVerified() == m2.isVerified();
    }
}
