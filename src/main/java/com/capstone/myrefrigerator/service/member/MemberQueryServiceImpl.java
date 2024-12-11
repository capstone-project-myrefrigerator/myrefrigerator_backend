package com.capstone.myrefrigerator.service.member;

import com.capstone.myrefrigerator.apiPayload.code.status.ErrorStatus;
import com.capstone.myrefrigerator.apiPayload.exception.handler.MemberHandler;
import com.capstone.myrefrigerator.domain.Member;
import com.capstone.myrefrigerator.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService{

    private final MemberRepository memberRepository;

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
    }

    @Override
    public Member getMemberProfile(Long memberId) {
        return memberRepository.findById(memberId).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
    }
}
