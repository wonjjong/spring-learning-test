package mvc.member;

import domain.Member;
import lombok.Getter;

@Getter
public class MemberInsertDto {
    private String name;

    private String mobileNumber;

    public Member toEntity() {
        return Member.builder()
                .name(name)
                .mobileNumber(mobileNumber)
                .build();
    }
}
