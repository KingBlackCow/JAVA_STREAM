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
    @Setter
    private String name;
    private String emailAddress;
    @Setter
    private boolean isVerified;
    @Setter
    private LocalDateTime createdAt;
    @Setter
    private List<Integer> friendMemberIds;

    @Builder
    public Member(int id, String name, String emailAddress, boolean isVerified, List<Integer> friendMemberIds) {
        this.id = id;
        this.name = name;
        this.emailAddress = emailAddress;
        this.isVerified = isVerified;
        this.friendMemberIds = friendMemberIds;
    }

    public Optional<String> getEmailAddressOptional(){
        return Optional.ofNullable(emailAddress);
    }
}
