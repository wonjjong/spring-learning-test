package com.wonjjong.spring_learning_test.mvc.member;

import com.wonjjong.spring_learning_test.domain.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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
