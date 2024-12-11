package com.capstone.myrefrigerator.service.member;

import com.capstone.myrefrigerator.domain.Member;

public interface MemberQueryService {

    Member findMember(Long memberId);

    Member getMemberProfile(Long memberId);
}
