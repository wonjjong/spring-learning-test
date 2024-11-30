package com.wonjjong.spring_learning_test.mvc.member;

import com.wonjjong.spring_learning_test.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    public List<Member> findAll();
}
