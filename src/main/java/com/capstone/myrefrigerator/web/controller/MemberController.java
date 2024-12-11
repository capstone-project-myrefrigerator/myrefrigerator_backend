package com.capstone.myrefrigerator.web.controller;

import com.capstone.myrefrigerator.apiPayload.ApiResponse;
import com.capstone.myrefrigerator.converter.MemberConverter;
import com.capstone.myrefrigerator.domain.Member;
import com.capstone.myrefrigerator.service.member.MemberQueryService;
import com.capstone.myrefrigerator.web.dto.MemberResponseDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@Validated
@Tag(name = "Member", description = "Member 관련 API")
@RequestMapping("/api/members")
public class MemberController {

    private final MemberQueryService memberQueryService;

    @GetMapping("/my/profile/{memberId}")
    @Operation(summary = "나의 프로필 조회 API", description = "나의 프로필 정보 조회를 위한 API이다.")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "OK, 성공")
    })
    public ApiResponse<MemberResponseDTO.MemberDetail> memberProfile(@PathVariable("memberId") Long memberId){
        Member member = memberQueryService.getMemberProfile(memberId);
        return ApiResponse.onSuccess(MemberConverter.memberDetailDTO(member));
    }
}
