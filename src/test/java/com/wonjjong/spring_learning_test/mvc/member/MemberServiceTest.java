package com.wonjjong.spring_learning_test.mvc.member;

import com.wonjjong.spring_learning_test.domain.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class MemberServiceTest {
    @Autowired
    public MemberRepository memberRepository;

    @Autowired
    private MemberService memberService;

    @Test
    @DisplayName("회원등록")
    public void 회원등록() {
        //given
        MemberInsertDto memberInsertDto = new MemberInsertDto();
        memberInsertDto.setName("wonjjong");
        memberInsertDto.setMobileNumber("010-1111-2222");

        //when
        Long savedMemberId = memberService.saveMember(memberInsertDto);

        //then
        Member savedMember = memberRepository.findById(savedMemberId).get();
        assertThat(savedMember.getId()).isEqualTo(savedMemberId);
    }

    @Test
    @DisplayName("회원수정")
    public void 회원수정() {
        //given
        String newName = "wonjjong-test";
        MemberInsertDto memberInsertDto = new MemberInsertDto();
        memberInsertDto.setName("wonjjong");
        memberInsertDto.setMobileNumber("010-1111-2222");
        Long savedMemberId = memberService.saveMember(memberInsertDto);

        //when
        MemberUpdateDto memberUpdateDto = new MemberUpdateDto();
        memberUpdateDto.setId(savedMemberId);
        memberUpdateDto.setName(newName);
        memberService.updateMember(memberUpdateDto);

        //then
        Member member = memberRepository.findById(savedMemberId).get();
        assertThat(member.getName()).isEqualTo(newName);
    }


}