package mvc.member;

import domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Long saveMember(MemberInsertDto memberRequestDto) {
        Member save = memberRepository.save(memberRequestDto.toEntity());

        return save.getId();
    }

    @Transactional
    public void updateMember(MemberUpdateDto memberUpdateDto) {
        Member member = memberRepository.findById(memberUpdateDto.getId()).get();
        member.changeName(memberUpdateDto.getName());

        // execute dirty check
    }
}
