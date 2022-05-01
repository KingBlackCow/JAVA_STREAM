package functionalprogramming;

import functionalprogramming.model.Member;
import functionalprogramming.model.User;

import java.util.Optional;

public class Chapter19_OptionalApplication {
    public static void main(String[] args) {
        Optional<Member> maybeMember = Optional.ofNullable(maybeGetMember(true));
        maybeMember.ifPresent(member -> System.out.println(member));

        Optional<Integer> maybeId = Optional.ofNullable(maybeGetMember(true))
                .map(member -> member.getId());
        maybeId.ifPresent(System.out::println);

        String userName = Optional.ofNullable(maybeGetMember(true))
                .map(Member::getName)
                .map(name -> "The name is " + name)
                .orElse("Name is empty");
        System.out.println(userName);

        String emailFlatMap = Optional.ofNullable(maybeGetMember(true))
                .flatMap(Member::getEmailAddressOptional)
                .map(email -> "The email is " + email)
                .orElse("email is empty");
        System.out.println(emailFlatMap);
    }

    public static Member maybeGetMember(boolean returnMember) {
       if(returnMember){
           return Member.builder()
                   .id(1001)
                   .name("Alice")
                   .emailAddress("sgs1159@naver.com")
                   .isVerified(false)
                   .build();
       }
       return null;
    }
}
