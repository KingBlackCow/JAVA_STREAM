package functionalprogramming.model;


import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Getter

@ToString
@RequiredArgsConstructor
public class Member {
    private int id;
    private String name;
    private String emailAddress;
    private boolean isVerified;
    @Setter
    private LocalDateTime createdAt;
    @Setter
    private List<Integer> friendMemberIds;

    @Builder
    public Member(int id, String name, String emailAddress, boolean isVerified) {
        this.id = id;
        this.name = name;
        this.emailAddress = emailAddress;
        this.isVerified = isVerified;
    }

    public Optional<String> getEmailAddressOptional(){
        return Optional.ofNullable(emailAddress);
    }
}
