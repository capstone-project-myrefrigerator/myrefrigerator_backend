package com.capstone.myrefrigerator.converter;

import com.capstone.myrefrigerator.domain.Member;
import com.capstone.myrefrigerator.repository.MemberRepository;
import com.capstone.myrefrigerator.web.dto.MemberResponseDTO;

public class MemberConverter {

    public static MemberResponseDTO.MemberDetail memberDetailDTO(Member member){
        return MemberResponseDTO.MemberDetail.builder()
                .memberId(member.getId())
                .name(member.getName())
                .height(member.getHeight())
                .weight(member.getWeight())
                .build();
    }
}
